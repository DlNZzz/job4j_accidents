package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.service.AccidentTypeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private AccidentTypeService accidentTypeService;

    private HashMap<Integer, Accident> accidents = new HashMap<>();

    private AtomicInteger count = new AtomicInteger(0);

    public AccidentMem(AccidentTypeService accidentTypeService) {
        this.accidentTypeService = accidentTypeService;
        accidents.put(0, new Accident(0,"123", "qwe", "qwe", (AccidentType) accidentTypeService.findById(1)));
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        accident.setId(count.incrementAndGet());
        accident.setType((AccidentType) accidentTypeService.findById(accident.getType().getId()));
        accidents.put(accident.getId(), accident);
    }

    public void edit(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }

    public Object findById(int id) {
        return accidents.get(id);
    }
}
