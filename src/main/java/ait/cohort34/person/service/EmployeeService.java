package ait.cohort34.person.service;

import ait.cohort34.person.dto.EmployeeDto;

public interface EmployeeService {
    Boolean addEmployee(EmployeeDto employeeDto);

    Iterable<EmployeeDto> findEmployeesBySalary(Double min, Double max);
}
