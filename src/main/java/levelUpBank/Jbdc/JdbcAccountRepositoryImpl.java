package levelUpBank.Jbdc;

import levelUpBank.Jbdc.pool.ConnectionManager;
import lombok.AllArgsConstructor;

import java.sql.*;

@AllArgsConstructor

public class JdbcAccountRepositoryImpl implements AccountRepository {
    private ConnectionManager cm;

    @Override
    public void createNewAccount(long account_number, long amount) {
        try (Connection connection = cm.openConnection()) {
            PreparedStatement stmt = connection.prepareStatement("insert into accounts(account_number, amount)values(?,?)");
            stmt.setLong(1, account_number);
            stmt.setLong(2, amount);
            int affectedRows = stmt.executeUpdate();
            System.out.println("Добавлено " + affectedRows + " акаунтов");
        } catch (SQLException exc) {
            System.out.println("Ошибка подключения к базе");
            exc.printStackTrace();
        }
    }

    @Override
    public void printAllAccounts() {
        try (Connection connection = cm.openConnection()) {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from accounts");
            while (rs.next()) {
                long clientId = rs.getLong("client_id");
                long accountNumber = rs.getLong("account_number");
                long amount = rs.getLong("amount");

                System.out.println(clientId + " " + accountNumber + " " + amount);
            }

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void printAllAccountsForClient() {
        try (Connection connection = cm.openConnection()) {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from accounts where client_id = 3");
            while (rs.next()) {
                long clientId = rs.getLong("client_id");
                long accountNumber = rs.getLong("account_number");
                long amount = rs.getLong("amount");

                System.out.println(clientId + " " + accountNumber + " " + amount);
            }

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void printAccountWithMaxAmount() {
        try (Connection connection = cm.openConnection()) {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from accounts\n" +
                    "order by amount desc\n" +
                    "limit 1;");

            while (rs.next()) {
                long clientId = rs.getLong("client_id");
                long accountNumber = rs.getLong("account_number");
                long maxAmount = rs.getLong("amount");

                System.out.println(clientId + " " + accountNumber + " " + maxAmount);
            }

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    public void printTotalAmount() {
        try (Connection connection = cm.openConnection()) {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select sum(amount) from accounts");

            while (rs.next()) {
                long totalAmount = rs.getLong("sum");
                System.out.println(totalAmount);
            }

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }
}
