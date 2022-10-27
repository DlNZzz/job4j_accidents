package ru.job4j.accident.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authorities")
@Data
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String authority;
}