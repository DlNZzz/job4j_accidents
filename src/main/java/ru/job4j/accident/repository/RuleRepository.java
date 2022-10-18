package ru.job4j.accident.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.HashSet;
import java.util.Set;

@Repository
public interface RuleRepository extends CrudRepository<Rule, Integer> {

    default Set<Rule> findByIds(String[] rIds) {
        Set<Rule> rules = new HashSet<>();
        for (String sId : rIds) {
            int id = Integer.parseInt(sId);
            Rule rule = findById(id).get();
            rules.add(rule);
        }
        return rules;
    }
}
