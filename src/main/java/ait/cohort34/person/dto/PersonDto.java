package ait.cohort34.person.dto;

import lombok.Getter;
import java.time.LocalDate;
import java.time.Period;

@Getter
public class PersonDto {
    Integer id;
    String name;
    LocalDate birthDate;
    AddressDto address;
}
