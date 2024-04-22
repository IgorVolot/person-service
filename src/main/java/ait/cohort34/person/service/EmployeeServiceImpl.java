package ait.cohort34.person.service;

import ait.cohort34.person.dao.PersonRepository;
import ait.cohort34.person.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    final PersonRepository personRepository;
    final ModelMapper modelMapper;

    @Override
    public Boolean addEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public Iterable<EmployeeDto> findEmployeesBySalary(Double min, Double max) {
        return null;
    }
}
