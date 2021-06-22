package levelUpBank.Jbdc.pool;

import java.sql.Connection;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

// Класс содержит список соединений

public class ConnectionPool {
    private final IdentityHashMap<Connection, Boolean> pool = new IdentityHashMap<>(); // ключи сравниваются по ссылкам

    public Connection acquireConnection() {
        Set<Map.Entry<Connection, Boolean>> entries = pool.entrySet(); // список всех пар из Map
        for (Map.Entry<Connection, Boolean> entry : entries) {

            if (!entry.getValue()) { // ищем незанятое соединение
                entry.setValue(true); // говорим, что соединение занято
                return entry.getKey(); // возвращаем само соединение
            }
        }
        return null;
    }

    public void releaseConnection(Connection connection) {
        pool.put(connection, false);
    }

    void putConnectionToPool(Connection connection) {
        pool.put(connection, false); // false - connection доступен для получения (соединение не занято)
    }
}
