package Thread.queue;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.LinkedList;

public class SynchronizedQueue implements Queue {

    private final Object empty = new Object(); // mutex for empty queue
    private final Object full = new Object();  // mutex for full
    private final LinkedList<Duplicate> duplicates;
    private final int maxSize;

    public SynchronizedQueue() {
        this.duplicates = new LinkedList<>();
        this.maxSize = 10;
    }

    @Override
    @SneakyThrows
    public void putDuplicate(Duplicate duplicate) {
        synchronized (full) {
            while (duplicates.size() == maxSize) {
                full.wait();
            }
        }
        synchronized (empty) {
            duplicates.offer(duplicate);
            empty.notifyAll();
        }

    }

    @Override
    public Duplicate takeDuplicate() throws InterruptedException {
        synchronized (empty) {
            while (duplicates.isEmpty()) {
                empty.wait();
            }
        }
        synchronized (full) {
            //Thread.sleep(1000) - плохой вариант, никогда не запускать внутри синхронизации, он не снимает блокировку монитора
            Duplicate duplicate = duplicates.poll();
            full.notifyAll();
            return duplicate;
        }
    }
}
