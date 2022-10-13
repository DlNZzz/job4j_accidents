package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.mem.AccidentMem;

import java.util.Collection;

@Service
@AllArgsConstructor
public class AccidentServiceJava {

    private AccidentMem accidentMem;

    public Collection<Accident> findAll() {
        return accidentMem.findAll();
    }

    public void create(Accident accident, String[] ids) {
        accidentMem.create(accident, ids);
    }

    public void edit(Accident accident) {
        accidentMem.edit(accident);
    }

    public Object findById(int id) {
        return accidentMem.findById(id);
    }
}
