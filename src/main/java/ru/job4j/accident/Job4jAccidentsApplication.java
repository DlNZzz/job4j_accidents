package ru.job4j.accident;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Job4jAccidentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Job4jAccidentsApplication.class, args);
        System.out.println("Go to http://localhost:8080");
    }

}
