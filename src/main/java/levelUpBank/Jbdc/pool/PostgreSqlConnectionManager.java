package levelUpBank.Jbdc.pool;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlConnectionManager implements ConnectionManager {
    //DriverManager
    //Driver
    //Connection
    private final ConnectionPool pool;

    public PostgreSqlConnectionManager() {
        this.pool = new ConnectionPool();
    }

    @Override
    @ConnectionTime
    public Connection openConnection() throws SQLException {
        Connection connection = pool.acquireConnection();
        if (connection == null) {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/bank_application",
                    "postgres",
                    "Nils#123"
            );
            pool.putConnectionToPool(connection);
        }
        return connection;
    }

    private Connection proxyConnection(Connection realConnection) {
        return (Connection) Proxy.newProxyInstance(
                realConnection.getClass().getClassLoader(),
                realConnection.getClass().getInterfaces(),
                new ConnectionCloseInvocationHandler(realConnection, pool)
        );
    }
}
