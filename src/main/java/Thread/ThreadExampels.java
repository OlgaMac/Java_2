package Thread;

import lombok.SneakyThrows;

public class ThreadExampels {
    @SneakyThrows
    public static void main(String[] args) {
        Thread printer = new PrinterThread();
        // printer.run() - писать неправльно, просто выполним ран, нужно сначало запустить поток
        printer.start();

        printer.join();// поток в котором вызвали этот метод будет ждать пока поток Т не завершится

        Thread.sleep(3000);

        System.out.println("Поток main завершен");
    }
}
