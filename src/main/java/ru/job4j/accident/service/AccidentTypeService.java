package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentTypeMem;

import java.util.Collection;

@Service
@AllArgsConstructor
public class AccidentTypeService {

    private AccidentTypeMem accidentTypeMem;

    public Collection<AccidentType> findAll() {
        return accidentTypeMem.findAll();
    }

    public Object findById(int id) {
        return accidentTypeMem.findById(id);
    }
}
