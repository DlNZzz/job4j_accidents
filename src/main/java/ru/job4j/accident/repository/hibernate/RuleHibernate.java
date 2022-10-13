package ru.job4j.accident.repository.hibernate;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Repository
@AllArgsConstructor
public class RuleHibernate {

    private final SessionFactory sf;

    public Collection<Rule> findAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Rule", Rule.class)
                    .list();
        }
    }

    public Object findById(int id) {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Rule where id = :id")
                    .setParameter("id",id)
                    .uniqueResult();
        }
    }

    public Set<Rule> findByIds(String[] rIds) {
        Set<Rule> rules = new HashSet<>();
        try (Session session = sf.openSession()) {
            for (String sId : rIds) {
                int id = Integer.parseInt(sId);
                Rule rule = (Rule) session.createQuery("from Rule where id = :id")
                        .setParameter("id", id)
                        .uniqueResult();
                rules.add(rule);
            }
            return rules;
        }
    }
}
