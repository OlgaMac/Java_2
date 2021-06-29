package repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.function.Function;

@RequiredArgsConstructor
public abstract class AbstractRepository {
    protected final SessionFactory factory;

    public <T> T supplyWithoutTransaction(Function<Session, T> sessionTFunction){
        try(Session session = factory.openSession()){
            return sessionTFunction.apply(session);
        }
    }
}
