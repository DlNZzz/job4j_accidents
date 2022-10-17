package ru.job4j.accident.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "accidents_rules",
            joinColumns = @JoinColumn(name = "accidents_id"),
            inverseJoinColumns = @JoinColumn(name = "rules_id")
    )
    private Set<Rule> rules;
}