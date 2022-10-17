package ru.job4j.accident.repository.mem;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.*;

@Repository
public class RuleMem {

    private HashMap<Integer, Rule> rules = new HashMap<>();

    public RuleMem() {
        rules.put(0, new Rule(0, "Статья. 1"));
        rules.put(1, new Rule(1, "Статья. 2"));
        rules.put(2, new Rule(2, "Статья. 3"));
    }

    public Collection<Rule> findAll() {
        return rules.values();
    }

    public Set<Rule> findByIds(String[] rIds) {
        Set<Rule> rules = new HashSet<>();
        for (String sId : rIds) {
            rules.add((Rule) findById(Integer.parseInt(sId)));
        }
        return rules;
    }

    public Object findById(int id) {
        return rules.get(id);
    }
}
