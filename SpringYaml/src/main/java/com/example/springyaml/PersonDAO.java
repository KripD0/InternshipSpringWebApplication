package com.example.springyaml;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO Спросить как вызывать этот медот, пытался создать Bean в main, вылезала ошибка. Spring Boot запускается и пишет какой то Hikari Datasource, в файле конфигурации нужно конкретно его указывать или необязательно.

//    @PostConstruct
//    public void selectAllPerson() {
//        jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class))
//                .stream()
//                .map(Person::getFullName)
//                .forEach(System.out::println);
//    }
}
