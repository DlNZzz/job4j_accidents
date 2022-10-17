package ru.job4j.accident.repository.hibernate;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;
import java.util.function.Function;

@Repository
@AllArgsConstructor
public class AccidentTypeHibernate {

    private final SessionFactory sf;

    public Collection<AccidentType> findAll() {
        return tx(
                session -> session.createQuery("from AccidentType", AccidentType.class).list()
        );
    }

    public Object findById(int id) {
        return tx(session -> session.createQuery("from AccidentType where id = :id")
                .setParameter("id",id)
                .uniqueResult()
        );
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
