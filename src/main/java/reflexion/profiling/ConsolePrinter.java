package reflexion.profiling;

public class ConsolePrinter implements Printer {
    @Override
    @Profiling
    public void printInformation() {
        System.out.println("Hello, i'm Printing");
    }
}
