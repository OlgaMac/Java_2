package levelUpBank.Jbdc;



import domain.ClientEntity;
import levelUpBank.Jbdc.pool.ConnectionManager;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import util.DateUtils;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor // public JdbcClientRepository(

public class JdbcClientRepository implements ClientRepository {
    private ConnectionManager cm;

    @Override
    public void createNewClient(String firstName, String lastName, String middleName, LocalDate birthday) {
        try (Connection connection = cm.openConnection()) {
            PreparedStatement stmt = connection.prepareStatement("insert into clients(first_name, last_name, middle_name, birthday)values(?,?,?,now())");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, middleName);
            int affectedRows = stmt.executeUpdate();
            System.out.println("Добавлено " + affectedRows + " клиентов");
        } catch (SQLException exc) {
            System.out.println("Ошибка подключения к базе");
            exc.printStackTrace();
        }
    }

    @Override
    public void printAllClients() {
        try (Connection connection = cm.openConnection()) {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from clients");
            while (rs.next()) {
                long clientId = rs.getLong(1);
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String middleName = rs.getString("middle_name");

                System.out.println(clientId + " " + firstName + " " + lastName + " " + middleName);
            }

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }
    @Override
    @SneakyThrows // позволяет не писать try-catch для checked исключений
    public Collection<ClientEntity> findClientsWhenBirthdayBetween(LocalDate begin, LocalDate end) {
        String sql = "select * from clients where birthday between ? and ?";
        try (Connection connection = cm.openConnection()) {

            Date beginDate = DateUtils.ofLocalDate(begin);
            Date endDate = DateUtils.ofLocalDate(end);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, beginDate);
            statement.setDate(2, endDate);

            ResultSet rs = statement.executeQuery();
            return retrieveClientsFromResultSet(rs);
        }
    }

    private Collection<ClientEntity> retrieveClientsFromResultSet(ResultSet rs) throws SQLException {
        Collection<ClientEntity> clients = new ArrayList<>();
        while (rs.next()) {
            ClientEntity client = new ClientEntity(
                    rs.getLong("clientId"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("middle_name"),
                    DateUtils.ofDate(rs.getDate("birthday"))
            );

            clients.add(client);
        }

        return clients;
    }
}

