package levelUpBank.Jbdc.pool;

import java.sql.SQLException;

public class ConnectionApp {


    public static void main(String[] args) throws SQLException {
        ConnectionFactory.timeFactory().openConnection();

    }
}
