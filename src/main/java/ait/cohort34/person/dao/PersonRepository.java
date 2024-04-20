package ait.cohort34.person.dao;

import ait.cohort34.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Stream<Person> findAllByAddressCity(String city);
    Stream<Person> findAllByNameIgnoreCase(String name);
}
