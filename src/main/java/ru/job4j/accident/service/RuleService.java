package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.hibernate.RuleHibernate;
import ru.job4j.accident.repository.mem.RuleMem;

import java.util.Collection;
import java.util.Set;

@Service
@AllArgsConstructor
public class RuleService {

    private RuleHibernate ruleHibernate;

    public Collection<Rule> findAll() {
        return ruleHibernate.findAll();
    }

    public Set<Rule> findByIds(String[] rIds) {
        return ruleHibernate.findByIds(rIds);
    }

    public Object findById(int id) {
        return ruleHibernate.findById(id);
    }
}
