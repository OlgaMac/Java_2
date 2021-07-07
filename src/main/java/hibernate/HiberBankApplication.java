package hibernate;

import domain.AccountEntity;
import domain.ClientEntity;
import levelUpBank.Jbdc.JdbcClientRepository;
import levelUpBank.Jbdc.pool.ConnectionManager;
import levelUpBank.Jbdc.pool.PostgreSqlConnectionManager;
import org.hibernate.SessionFactory;
import repository.ClientRepository;
import repository.OperationRepository;
//import repository.OperationRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class HiberBankApplication {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getFactory();
        //ClientRepository clientRepository = new ClientRepository(factory);
        //ClientEntity client1 = clientRepository.createClient("Ivanov", "Ivan", "Petrovich", LocalDate.of(1945,05,12));
        //clientRepository.editClient(1000l, "Petr", "Sir", "Ivanovich", LocalDate.of(1985, 12,01));
        //clientRepository.deleteClient(1015l);
        //Collection<ClientEntity> clients = clientRepository.printAllClients();
        //for(ClientEntity client : clients){
        //   System.out.println(client.toString());
        //}
        OperationRepository operation = new OperationRepository(factory);
        operation.createOperation("4512254856", "5652155452", 256 );
        factory.close();
    }
}
