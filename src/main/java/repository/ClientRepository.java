package repository;

import domain.AccountEntity;
import domain.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class ClientRepository {
    private final SessionFactory factory;

    public ClientEntity createClient(String firstName, String lastName, String middleName, LocalDate birthday){
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            ClientEntity newClient = new ClientEntity();
            newClient.setLastName("lastName");
            newClient.setFirstName("firstName");
            newClient.setMiddleName("middleName");
            newClient.setBirthday(birthday);

            session.save(newClient);
            tx.commit(); // фиксация изменений в рамках транзакции
            return newClient;

        }
    }
   /* public ClientEntity editClient(String firstName, String lastName, String middleName, LocalDate birthday){
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            ClientEntity newClient = new ClientEntity();
            newClient.setLastName("lastName");
            newClient.setFirstName("firstName");
            newClient.setMiddleName("middleName");
            newClient.setBirthday(birthday);

            session.save(newClient);
            tx.commit(); // фиксация изменений в рамках транзакции
            return newClient;
        }
    }*/

}
