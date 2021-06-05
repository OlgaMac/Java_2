package levelUpBank;

import domain.Client;

import java.time.LocalDate;
import java.util.Collection;

//Controller /bank/new/client -> createNewClient from Client
// Service
// DAO/Repository   DAO -DAta Access Object
// CRUD - CreateReadUpdateDelete
public interface ClientRepository {
    void createNewClient(String firstName, String lastName, String middleName, LocalDate birthday);
    void printAllClients();
    Collection<Client> findClientsWhenBirthdayBetween(LocalDate begin, LocalDate end);
}
