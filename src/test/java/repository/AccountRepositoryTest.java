package repository;

import domain.AccountEntity;
import domain.ClientEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountRepositoryTest {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    private AccountRepository accountRepository;

    @BeforeEach // будет вызываться перед каждым тестом
    public void setupBehaviour() {
        factory = mock(SessionFactory.class);
        session = mock(Session.class);
        transaction = mock(Transaction.class);

        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        accountRepository = new AccountRepository(factory);

    }

    @Test
    public void testCreateAccount_whenValidParams_thenCreateAnAccount() {
        //given
        long clientId = 1L;
        //when
        AccountEntity result = accountRepository.createAccount(1L);

        //then
        assertEquals(0, result.getAmount());
        assertEquals(16, result.getAccountNumber().length());
    }

    @Test
    public void testCreateAccount_whenValidParams_thenCheckAccountClient() {
        //given
        long clientId = 1L;
        ClientEntity client = new ClientEntity();
        client.setClientId(clientId);

        when(session.load(ClientEntity.class, clientId)).thenReturn(client);
        //when
        AccountEntity result = accountRepository.createAccount(1L);

        //then
        assertNotNull(result.getClient());
        assertSame(client, result.getClient()); //сравнения по ссылкам
        //assertEquals(clientId, result.getClient().getClientId());
    }
    @Test
    public void testCreateAccount_whenValidParams_thenVerifyMethodCalls(){
        //given
        long clientId = 1L;

        //when
        AccountEntity result = accountRepository.createAccount(1L);

        //then
        verify(session).save(ArgumentMatchers.any(AccountEntity.class));
        verify(transaction).commit();
        verify(session, times(1)).close();

    }
    @Test
    public void  testLoadClientAccount_whenAccountExist_thenReturnAccountList(){
        //given
        long clientId = 1L;
        Query query = mock(Query.class);

        //when()/verify()
        // все параметры переопределяемого метода должны быть
        // либо раельными объектами
        // либо объектами ArgumentMatches

        when(session.createQuery(ArgumentMatchers.anyString(), ArgumentMatchers.eq(AccountEntity.class)))
                .thenReturn(query);
        when(query.setParameter("clientId", clientId))
                .thenReturn(query);

        List<AccountEntity> expectResult = new ArrayList<>();
        expectResult.add(new AccountEntity());
        expectResult.add(new AccountEntity());

        when(query.getResultList()).thenReturn(expectResult);

        //when
        Collection<AccountEntity> accounts = accountRepository.loadClientAccounts(clientId);

        //then
        assertSame(expectResult, accounts);
        verify(session).close();
    }

}