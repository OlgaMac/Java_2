package Thread.queue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockQueue implements Queue {
    private final LinkedList<Duplicate> duplicates = new LinkedList<>();
    private final int maxSize = 10;
    private final ReentrantLock sync = new ReentrantLock();
    private final Condition fullCondition = sync.newCondition();
    private final Condition emptyCondition = sync.newCondition();

    @Override
    public void putDuplicate(Duplicate duplicate) throws InterruptedException {
        sync.lock();// аналог synchronized
        try {
            while (duplicates.size() == maxSize) {
                fullCondition.await();
            }
            duplicates.offer(duplicate);
            emptyCondition.signalAll();
        } finally {
            sync.unlock();
        }
    }

    @Override
    public Duplicate takeDuplicate() throws InterruptedException {
        sync.lock();
        try {
            while (duplicates.isEmpty()){
                duplicates.poll();
            }
            Duplicate duplicate = duplicates.poll();
            fullCondition.signalAll();
            return duplicate;
        }finally {
            sync.unlock();
        }
    }
}
