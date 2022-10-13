package ru.job4j.accident.repository.mem;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.service.AccidentTypeService;
import ru.job4j.accident.service.RuleService;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private final AccidentTypeService accidentTypeService;
    private final RuleService ruleService;

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    private final AtomicInteger count = new AtomicInteger(0);

    public AccidentMem(AccidentTypeService accidentTypeService, RuleService ruleService) {
        this.accidentTypeService = accidentTypeService;
        this.ruleService = ruleService;
        accidents.put(0, new Accident(0, "123", "qwe", "qwe",
                (AccidentType) accidentTypeService.findById(1),
                ruleService.findByIds(new String[] {"1"})));
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }

    public void create(Accident accident, String[] ids) {
        accident.setId(count.incrementAndGet());
        accident.setType((AccidentType) accidentTypeService.findById(accident.getType().getId()));
        accident.setRules(ruleService.findByIds(ids));
        accidents.put(accident.getId(), accident);
    }

    public void edit(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }

    public Object findById(int id) {
        return accidents.get(id);
    }
}
