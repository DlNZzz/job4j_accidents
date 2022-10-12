package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class AccidentTypeMem {

    private final HashMap<Integer, AccidentType> types = new HashMap<>();

    public AccidentTypeMem() {
        types.put(0, new AccidentType(0, "Две машины"));
        types.put(1, new AccidentType(1, "Машина и человек"));
        types.put(2, new AccidentType(2, "Машина и велосипед"));
    }

    public Collection<AccidentType> findAll() {
        return types.values();
    }

    public Object findById(int id) {
        return types.get(id);
    }
}
