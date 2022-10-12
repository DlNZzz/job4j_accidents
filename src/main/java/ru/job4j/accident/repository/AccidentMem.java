package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private HashMap<Integer, Accident> accidents = new HashMap<>();
    private AtomicInteger count = new AtomicInteger();

    public AccidentMem() {
        accidents.put(0, new Accident(0,"123", "qwe", "qwe", new AccidentType()));
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        int id = count.addAndGet(1);
        System.out.println(id);
        accident.setId(id);
        accidents.put(accident.getId(), accident);
    }

    public void edit(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }

    public Object findById(int id) {
        return accidents.get(id);
    }
}
