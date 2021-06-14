package reflexion.profiling;

import java.lang.reflect.Proxy;

public class PrintFactory {
    public static  Printer getPrinter(){
        return (Printer) Proxy.newProxyInstance(
                ConsolePrinter.class.getClassLoader(),
                ConsolePrinter.class.getInterfaces(),
                new ProfilingInVacationHandler(new ConsolePrinter())
        );
    }
}
