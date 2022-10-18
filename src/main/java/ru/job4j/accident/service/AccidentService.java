package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.hibernate.AccidentHibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccidentService {

    private final AccidentRepository accidentsRepository;

    public void create(Accident accident) {
        accidentsRepository.save(accident);
    }

    public List<Accident> findAll() {
        var result = new ArrayList<Accident>();
        for (var accident : accidentsRepository.findAll()) {
            result.add(accident);
        }
        return result;
    }

    public void edit(Accident accident) {
        accidentsRepository.save(accident);
    }

    public Optional<Accident> findById(int id) {
        return accidentsRepository.findById(id);
    }

        /*
    private final AccidentHibernate accidentHibernate;

    public void create(Accident accident) {
        accidentHibernate.save(accident);
    }

    public List<Accident> findAll() {
        return accidentHibernate.findAll();
    }

    public void edit(Accident accident) {
    }

    public Object findById(int id) {
        return null;
    }

     */
}