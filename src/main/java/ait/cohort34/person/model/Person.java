package ait.cohort34.person.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table (name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    Integer id;
    @Setter
    String name;
    LocalDate birthDate;
    @Setter
//    @Embedded
    Address address;
}