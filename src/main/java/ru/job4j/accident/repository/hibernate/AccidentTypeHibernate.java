package ru.job4j.accident.repository.hibernate;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;

@Repository
@AllArgsConstructor
public class AccidentTypeHibernate {

    private final SessionFactory sf;

    public Collection<AccidentType> findAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType", AccidentType.class)
                    .list();
        }
    }

    public Object findById(int id) {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType where id = :id")
                    .setParameter("id",id)
                    .uniqueResult();
        }
    }
}
