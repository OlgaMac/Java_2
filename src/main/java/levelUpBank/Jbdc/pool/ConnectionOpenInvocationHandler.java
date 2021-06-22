package levelUpBank.Jbdc.pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ConnectionOpenInvocationHandler implements InvocationHandler {
    private Object original;


    public ConnectionOpenInvocationHandler(Object original) {this.original = original;}
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method originalMethod = original.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
        if (originalMethod.getAnnotation(ConnectionTime.class) != null) {
            long start = System.nanoTime();
            Object result = method.invoke(original, args);
            System.out.println("Execution time: " + (System.nanoTime() - start));
            return result;
        }
        return method.invoke(original, args);
    }
}
