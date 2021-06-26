package hibernate;

import domain.ClientEntity;
import levelUpBank.Jbdc.JdbcClientRepository;
import levelUpBank.Jbdc.pool.ConnectionManager;
import levelUpBank.Jbdc.pool.PostgreSqlConnectionManager;
import org.hibernate.SessionFactory;
import repository.ClientRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class HiberBankApplication {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getFactory();
        ClientRepository clientRepository = new ClientRepository(factory);
        //ClientEntity client1 = clientRepository.createClient("Ivanov", "Ivan", "Petrovich", LocalDate.of(1945,05,12));
        //clientRepository.editClient(1025l);
        //clientRepository.deleteClient(1035l);
        Collection<ClientEntity> clients = clientRepository.printAllClients();
        for(ClientEntity client : clients){
            System.out.println(client.toString());
        }
        factory.close();
    }
}
