package hibernate;

import domain.AccountEntity;
import domain.ManagerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.AccountRepository;
import repository.ManagerRepository;

import java.util.Collection;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getFactory();
        AccountRepository accountRepository = new AccountRepository(factory);
        //AccountEntity account = accountRepository.createAccount(1);
        //System.out.println(account.toString());
        Collection<AccountEntity> accounts = accountRepository.loadClientAccounts(3);
        for(AccountEntity account : accounts){
            System.out.println(account.toString());
        }
        factory.close();
        /*ManagerRepository managerRepository = new ManagerRepository(factory);
        ManagerEntity manager1 = managerRepository.addManager("Hello", "world");
        ManagerEntity manager2 = managerRepository.addManager("Ivan", "Petrov");

        ManagerEntity get = managerRepository.getById(manager1.getId());
        ManagerEntity load = managerRepository.loadById(manager2.getId());

        System.out.println(get);
        Session s = factory.openSession();
        s.refresh(get); // s.merge(get)
        System.out.println(get.getFilials());
        s.close();
        //System.out.println(load);

        factory.close();*/
    }
}
