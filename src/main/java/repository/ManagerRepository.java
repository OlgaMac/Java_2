package repository;

import domain.ManagerEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public class ManagerRepository {
    private final SessionFactory factory;

    public ManagerEntity addManager(String firstName, String lastName){
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();

            ManagerEntity manager = new ManagerEntity();
            manager.setFirstName(firstName);
            manager.setLastName(lastName);

            session.persist(manager);

            tx.commit();
            return manager;
        }
    }
    //session.get(class, id)  and session.load(class, id)
    public  ManagerEntity getById(Long managerId){
        try(Session session = factory.openSession()){
            return session.get(ManagerEntity.class, managerId);
        }
    }
    public  ManagerEntity loadById(Long managerId){
        try(Session session = factory.openSession()){
            return session.load(ManagerEntity.class, managerId);
        }
    }
}
