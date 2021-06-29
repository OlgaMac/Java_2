package Thread.counter;

public class ValueCounter {
    private int counter;

    public synchronized void increment(){
        counter++;
    }
    // синхронизировать надо только поток с общей памятью
    //acquire lock
    //release lock

    public int getCounter() {
        synchronized (this) {
            return counter;
        }
        //synchronized method
        //synchronize block - synchronize(this){}
    }
}
