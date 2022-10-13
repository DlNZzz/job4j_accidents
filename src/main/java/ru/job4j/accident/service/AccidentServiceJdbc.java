package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.jdbc.AccidentJdbcTemplate;

import java.util.Collection;

@Service
@AllArgsConstructor
public class AccidentServiceJdbc {
    private final AccidentJdbcTemplate accidentsRepository;

    public void create(Accident accident, String[] s) {
        accidentsRepository.save(accident, s);
    }

    public Collection<Accident> findAll() {
        return accidentsRepository.getAll();
    }

    public void edit(Accident accident) {
    }

    public Object findById(int id) {
        return accidentsRepository.findBy(id);
    }
}