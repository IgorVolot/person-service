package ait.cohort34.person.dto;

import lombok.Getter;

@Getter
public class EmployeeDto extends PersonDto {
    String company;
    Double salary;
    String type;
}
