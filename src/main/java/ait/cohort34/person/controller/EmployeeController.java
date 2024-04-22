package ait.cohort34.person.controller;

import ait.cohort34.person.dto.EmployeeDto;
import ait.cohort34.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class EmployeeController {
    final PersonService personService;

    @GetMapping("/salary/{min}/{max}")
    public EmployeeDto[] findEmployeesBySalary(@PathVariable Double min, @PathVariable Double max) {
        return personService.findEmployeesBySalary(min, max);
    }
}
