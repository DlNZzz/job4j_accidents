package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.hibernate.AccidentTypeHibernate;

import java.util.Collection;

@Service
@AllArgsConstructor
public class AccidentTypeService {

    private AccidentTypeHibernate accidentTypeHibernate;

    public Collection<AccidentType> findAll() {
        return accidentTypeHibernate.findAll();
    }

    public Object findById(int id) {
        return accidentTypeHibernate.findById(id);
    }
}
