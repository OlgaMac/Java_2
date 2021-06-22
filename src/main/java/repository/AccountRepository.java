package repository;

import domain.AccountEntity;
import domain.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public class AccountRepository {
    private final SessionFactory factory;

    public AccountEntity createAccount(long clientId){
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            AccountEntity account = new AccountEntity();
            account.setClient(session.load(ClientEntity.class,clientId));
            account.setAmount(0.0d);
            account.setAccountNumber(UUID.randomUUID().toString().substring(0,16));//генерация UUID

            session.save(account);
            tx.commit(); // фиксация изменений в рамках транзакции
            return account;
        }
    }

    public Collection<AccountEntity> loadClientAccounts(long clientId){
        try(Session session = factory.openSession()){
          return  session.createQuery("from AccountEntity where clientId = :clientId", AccountEntity.class )
                    .setParameter("clientId", clientId)
                    .getResultList();
        }
    }
}
