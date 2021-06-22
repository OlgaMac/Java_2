package levelUpBank.Jbdc.pool;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class ConnectionFactory {
    public static ConnectionManager timeFactory(){
        return (ConnectionManager) Proxy.newProxyInstance(
                PostgreSqlConnectionManager.class.getClassLoader(),
                PostgreSqlConnectionManager.class.getInterfaces(),
                new ConnectionOpenInvocationHandler(new PostgreSqlConnectionManager())
        );
    }
}
