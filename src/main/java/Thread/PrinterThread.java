package Thread;

import lombok.SneakyThrows;


public class PrinterThread extends Thread {
    @SneakyThrows
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println((getName() + " " + i));
            Thread.sleep(3000);
        }
    }
}
