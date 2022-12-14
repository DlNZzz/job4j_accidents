package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class RuleService {

    private RuleRepository ruleRepository;

    public Collection<Rule> findAll() {
        var result = new ArrayList<Rule>();
        for (var rule : ruleRepository.findAll()) {
            result.add(rule);
        }
        return result;
    }

    public Set<Rule> findByIds(String[] rIds) {
        Set<Rule> rules = new HashSet<>();
        for (String sId : rIds) {
            int id = Integer.parseInt(sId);
            Rule rule = findById(id).get();
            rules.add(rule);
        }
        return rules;
    }

    public Optional<Rule> findById(int id) {
        return ruleRepository.findById(id);
    }
}
