package ru.job4j.accident.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rule {
    @EqualsAndHashCode.Include
    private int id;

    private String name;
}