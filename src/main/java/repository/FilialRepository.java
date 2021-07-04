package repository;

import domain.FilialEntity;
import domain.ManagerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FilialRepository extends AbstractRepository{
    public FilialRepository(SessionFactory factory){
        super(factory);
    }

    public FilialEntity addFilial(String bankCode, String adress){
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();

            FilialEntity filial = new FilialEntity();
            filial.setBankCode(bankCode);
            filial.setAdress(adress);

            session.persist(filial);

            tx.commit();
            return filial;
        }
    }
    public  FilialEntity getById(Long filialId){

        return supplyWithoutTransaction(s -> s.get(FilialEntity.class, filialId));
    }
    public  FilialEntity loadById(Long filialId){
        return supplyWithoutTransaction(s-> s.load(FilialEntity.class, filialId));
    }
}
