package Thread.queue;

public interface Queue {

    void putDuplicate(Duplicate duplicate) throws InterruptedException;

    Duplicate takeDuplicate() throws InterruptedException;
}
