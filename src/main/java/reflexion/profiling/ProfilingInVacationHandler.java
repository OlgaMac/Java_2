package reflexion.profiling;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfilingInVacationHandler implements InvocationHandler {
    private Object original;

    public ProfilingInVacationHandler(Object original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getAnnotation(Profiling.class) != null) {
            long start = System.nanoTime();
            Object result = method.invoke(original, args);
            System.out.println("Execution time: " + (System.nanoTime() - start));
            return result;
        }
        return method.invoke(original, args);
    }
}
