package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentTypeRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccidentTypeService {

    private AccidentTypeRepository accidentTypeRepository;

    public Collection<AccidentType> findAll() {
        var result = new ArrayList<AccidentType>();
        for (var accidentType : accidentTypeRepository.findAll()) {
            result.add(accidentType);
        }
        return result;
    }

    public Optional<AccidentType> findById(int id) {
        return accidentTypeRepository.findById(id);
    }
}
