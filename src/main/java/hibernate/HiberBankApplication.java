package hibernate;

import domain.ClientEntity;
import levelUpBank.Jbdc.JdbcClientRepository;
import levelUpBank.Jbdc.pool.ConnectionManager;
import levelUpBank.Jbdc.pool.PostgreSqlConnectionManager;
import org.hibernate.SessionFactory;
import repository.ClientRepository;

import java.time.LocalDate;
import java.util.Collection;

public class HiberBankApplication {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getFactory();
        ClientRepository clientRepository = new ClientRepository(factory);
        ClientEntity cleint1 = clientRepository.createClient("Ivanov", "Ivan", "Petrovich", LocalDate.of(1987,03,12));
        System.out.println(cleint1);
    }
}
