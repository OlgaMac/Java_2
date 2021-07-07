package Thread.counter;

import java.util.concurrent.atomic.AtomicInteger;
//biased, thin, fat(full)
public class NonBlockingValueCounter {
    //java.util.concurrent.atomic
    // CAS - compare and set(compare amd swap)

    // 1.read value v1(100)
    // increment value -> 101
    // cas(100,101)
    // read value v2(100)
    // if(v1==v2) -> set(101)
    // else goto 1.
    private AtomicInteger counter = new AtomicInteger(0);
    public void increment(){
        counter.incrementAndGet();
    }
    public int getCounter(){
        return counter.getAcquire();
    }
}
