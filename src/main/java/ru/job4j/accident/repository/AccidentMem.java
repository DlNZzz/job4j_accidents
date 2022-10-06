package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class AccidentMem {
    private HashMap<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.put(1, new Accident(1,"123", "qwe", "qwe"));
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public void edit(Accident accident) {
        Accident accMap = accidents.get(accident.getId());
        accMap.setText(accident.getText());
        accidents.put(accident.getId(), accMap);
    }

    public Object findById(int id) {
        return accidents.get(id);
    }
}
