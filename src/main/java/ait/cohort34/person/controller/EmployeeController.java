package ait.cohort34.person.controller;

import ait.cohort34.person.dto.EmployeeDto;
import ait.cohort34.person.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class EmployeeController {

    final EmployeeService employeeService;

    @PostMapping
    public Boolean addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @GetMapping("/salary/{min}/{max}")
    public Iterable<EmployeeDto> findEmployeesBySalary(@PathVariable Double min, @PathVariable Double max) {
        return employeeService.findEmployeesBySalary(min, max);
    }
}
