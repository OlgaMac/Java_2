package repository;

import domain.OperationEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class OperationRepository  extends AbstractRepository{

    public OperationRepository(SessionFactory factory){
        super(factory);
    }

    public OperationEntity createOperation(String fromAccount, String toAccount, double amount){
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            OperationEntity operation = new OperationEntity();
            operation.setFromAccount(fromAccount);
            operation.setToAccount(toAccount);
            operation.setAmount(amount);

            session.persist(operation);

            tx.commit();
            return operation;
        }
    }
    public OperationEntity getById(Long operationId){
        return supplyWithoutTransaction(s -> s.get(OperationEntity.class, operationId));
    }
    public OperationEntity cancelOperation(String toAccount, String fromAccount, double amount) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            OperationEntity operation = new OperationEntity();
            operation.setToAccount(toAccount);
            operation.setFromAccount(fromAccount);
            operation.setAmount(amount);

            session.persist(operation);

            tx.commit();
            return operation;

        }
    }
}
