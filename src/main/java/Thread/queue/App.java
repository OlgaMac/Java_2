package Thread.queue;

import lombok.SneakyThrows;

public class App {
    @SneakyThrows
    public static void main(String[] args) {
        Queue queue = new ReentrantLockQueue();

        FindDuplicatesProducer producer1 = new FindDuplicatesProducer(queue);
        FindDuplicatesProducer producer2 = new FindDuplicatesProducer(queue);
        new Thread(producer1, "producer1").start();
        new Thread(producer2, "producer2").start();
        DuplicateConsumer consumer1 = new DuplicateConsumer(queue);
        Thread ct1 = new Thread(consumer1, "consumer1");
        ct1.start();

        Thread.sleep(1000);
        ct1.interrupt();
        //ct1.stop() - никогда не останавливать, иначе приведет к жесткой остановке
        // t.interrupt()
        // boolean t.isInterrupted()
        //boolean
        Thread.sleep(5000);
        System.out.println();

        DuplicateConsumer consumer2 = new DuplicateConsumer(queue);
        Thread ct2 = new Thread(consumer2, "consumer2");
        ct2.start();

    }
}
