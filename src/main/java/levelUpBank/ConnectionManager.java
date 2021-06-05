package levelUpBank;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager {
    Connection openConnection() throws SQLException;
}
