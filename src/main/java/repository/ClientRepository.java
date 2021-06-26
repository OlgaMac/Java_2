package repository;

import domain.AccountEntity;
import domain.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ClientRepository {
    private final SessionFactory factory;

    public ClientEntity createClient(String firstName, String lastName, String middleName, LocalDate birthday) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            ClientEntity newClient = new ClientEntity();
            newClient.setLastName(firstName);
            newClient.setFirstName(lastName);
            newClient.setMiddleName(middleName);
            newClient.setBirthday(birthday);

            session.save(newClient);
            tx.commit(); // фиксация изменений в рамках транзакции
            return newClient;

        }
    }

    public void editClient(Long clientId) {
        String firstName = "Nikolay";
        String lastName = "Sidorov";
        String middleName = "Ivanovich";
        LocalDate birthday = LocalDate.of(1985, 05, 12);
        try (Session session = factory.openSession()) {
            String HQL = "update ClientEntity set firstName = : firstName, lastName = : lastName," +
                    "middleName = : middleName, birthday = : birthday where clientId = :clientId";
            Query query = session.createQuery(HQL);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            query.setParameter("middleName", middleName);
            query.setParameter("birthday", birthday);
            query.setParameter("clientId", clientId);

            Transaction tx = session.beginTransaction();
            int executeUpdate = query.executeUpdate();
            tx.commit(); // фиксация изменений в рамках транзакции
            if (executeUpdate > 0) {
                System.out.println("Name and birthday were updated");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(Long clientId) {
        try (Session session = factory.openSession()) {
            String HQL = "delete from ClientEntity where clientId = :clientId";
            Query query = session.createQuery(HQL);
            query.setParameter("clientId", clientId);

            Transaction tx = session.beginTransaction();
            int executeUpdate = query.executeUpdate();
            tx.commit(); // фиксация изменений в рамках транзакции
            if (executeUpdate > 0) {
                System.out.println("Client was deleted");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Collection<ClientEntity> printAllClients() {
        try (Session session = factory.openSession()) {
            Query<ClientEntity> query = session.createQuery("from ClientEntity ", ClientEntity.class);
            return query.getResultList();
        }
    }
}

