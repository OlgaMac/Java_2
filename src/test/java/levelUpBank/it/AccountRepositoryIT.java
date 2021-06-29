package levelUpBank.it;

import domain.AccountEntity;
import domain.ClientEntity;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.AccountRepository;
import repository.ClientRepository;

import java.time.LocalDate;

public class AccountRepositoryIT {

    private static AccountRepository accountRepository;
    private static ClientRepository clientRepository;
    @BeforeAll
    public static void setupRepositories(){
        clientRepository = new ClientRepository(ITHibernateUtils.getFactory());
        accountRepository = new AccountRepository(ITHibernateUtils.getFactory());
    }

    @Test
    public void testCreateAccount_whenValidParams_thenCreateAccount(){
        //given
        ClientEntity client = clientRepository
            .createClient("Richard","King", null, LocalDate.of(1992,12,25));
        //when
        AccountEntity result = accountRepository.createAccount(client.getClientId());

        //then
        Session s = ITHibernateUtils.getFactory().openSession();
        AccountEntity account = s.get(AccountEntity.class, result.getAccountNumber());

        Assertions.assertEquals(account.getAccountNumber(), result.getAccountNumber());
        Assertions.assertEquals(account.getAmount(), result.getAmount());
        Assertions.assertEquals(account.getClient().getClientId(), result.getClient().getClientId());
    }
}
