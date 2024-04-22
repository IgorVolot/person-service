package ait.cohort34.person.controller;

import ait.cohort34.person.dto.ChildDto;
import ait.cohort34.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class ChildController {

    final PersonService personService;

    @GetMapping("/children")
    public ChildDto[] findAllChildren() {
        return personService.findAllChildren();
    }
}
