package levelUpBank;

import domain.Client;

import java.time.LocalDate;
import java.util.Collection;

public class BankApplication {
    public static void main(String[] args) {


        ConnectionManager cm = new PostgreSqlConnectionManager();
        ClientRepository clientRepository = new JdbcClientRepository(cm);
        //clientRepository.createNewClient("Im","Kim", null, null);
        //clientRepository.printAllClients();
        /*Collection<Client> clients = clientRepository.findClientsWhenBirthdayBetween(
                LocalDate.of(1950, 1, 1),
                LocalDate.of(1980, 12, 31)
        );

        for (Client client : clients) {
            System.out.println(client.getClientId() + " " + client.getLastName() + " " + client.getBirthday());
        }*/

        AccountRepository accountRepository = new JdbcAccountRepositoryImpl(cm);
        //accountRepository.createNewAccount(456254154, 45268);
        //accountRepository.printAllAccounts();
        //accountRepository.printAllAccountsForClient();
        //accountRepository.printAccountWithMaxAmount();
        accountRepository.printTotalAmount();
    }
}


