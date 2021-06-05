package levelUpBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlConnectionManager implements ConnectionManager {
    //DriverManager
    //Driver
    //Connection
    @Override
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(
        "jdbc:postgresql://127.0.0.1:5432/bank_application",
        "postgres",
        "Nils#123"
        );
    }


}
