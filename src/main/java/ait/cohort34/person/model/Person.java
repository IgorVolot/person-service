package ait.cohort34.person.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Person {
    @Id
    Integer id;
    @Setter
    String name;
    LocalDate birthDate;
    @Setter
    @Embedded
    Address address;

    private Integer age;

    public int getAge() {
        if ( birthDate != null ) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else
            throw new IllegalStateException("Check birthDate settings");
    }

}