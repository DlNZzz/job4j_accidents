package ru.job4j.accident.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "accidents")
public class Accident {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String text;

    private String address;

    @ManyToOne
    @JoinColumn(name = "types_id")
    private AccidentType type;

    @ManyToMany
    @JoinTable(
            name = "accidents_rules",
            joinColumns = @JoinColumn(name = "accidents_id"),
            inverseJoinColumns = @JoinColumn(name = "rules_id")
    )
    private Set<Rule> rules;
}