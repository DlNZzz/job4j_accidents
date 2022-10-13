package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.hibernate.AccidentHibernate;

import java.util.List;

@Service
@AllArgsConstructor
public class AccidentService {
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
}