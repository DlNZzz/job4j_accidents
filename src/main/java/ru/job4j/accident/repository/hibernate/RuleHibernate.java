package ru.job4j.accident.repository.hibernate;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@Repository
@AllArgsConstructor
public class RuleHibernate {

    private final SessionFactory sf;

    public Collection<Rule> findAll() {
        return tx(session -> session.createQuery("FROM Rule", Rule.class).list());
    }

    public Object findById(int id) {
        return tx(session -> session.createQuery("from Rule where id = :id")
                .setParameter("id",id)
                .uniqueResult()
        );
    }

    public Set<Rule> findByIds(String[] rIds) {
        Set<Rule> rules = new HashSet<>();
        for (String sId : rIds) {
            int id = Integer.parseInt(sId);
            Rule rule = (Rule) tx(session -> session.createQuery("from Rule where id = :id")
                    .setParameter("id", id)
                    .uniqueResult()
            );
            rules.add(rule);
        }
        return rules;
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
