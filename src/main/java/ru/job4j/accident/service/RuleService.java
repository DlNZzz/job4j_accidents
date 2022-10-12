package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleMem;

import java.util.Collection;
import java.util.Set;

@Service
public class RuleService {

    private RuleMem ruleMem;

    public RuleService(RuleMem ruleMem) {
        this.ruleMem = ruleMem;
    }

    public Collection<Rule> findAll() {
        return ruleMem.findAll();
    }

    public Set<Rule> findByIds(String[] rIds) {
        return ruleMem.findByIds(rIds);
    }

    public Object findById(int id) {
        return ruleMem.findById(id);
    }
}
