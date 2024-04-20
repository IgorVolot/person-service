package ait.cohort34.person.controller;

import ait.cohort34.person.dto.AddressDto;
import ait.cohort34.person.dto.PersonDto;
import ait.cohort34.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    final PersonService personService;

    @PostMapping
    public Boolean addPerson(@RequestBody PersonDto personDto) {
        return personService.addPerson(personDto);
    }

    @GetMapping("/{id}")
    public PersonDto findPersonById(@PathVariable Integer id) {
        return personService.findPersonById(id);
    }

    @GetMapping("/city/{city}")
    public List<PersonDto> findPersonsByCity(@PathVariable String city) {
        return personService.findPersonsByCity(city);
    }
    @GetMapping("/ages/{age}")
    public List<PersonDto> findPersonsByAge(@PathVariable int age) {
        return personService.findPersonsByAge(age);
    }

    @PutMapping("/{id}/name/{name}")
    public PersonDto updatePersonName(@PathVariable Integer id, @PathVariable String name) {
        return personService.updatePersonName(id, name);
    }

    @GetMapping("/name/{name}")
    public List<PersonDto> findPersonsByName(@RequestParam String name) {
        return personService.findPersonsByName(name);
    }

    @GetMapping("/population/city")
    public List<Map<String, Long>> getCityPopulation(@PathVariable String city, @RequestBody Long population) {
        return personService.getCityPopulation(city);
    }

    @PutMapping("/{id}/address")
    public PersonDto updateAddress(@RequestBody AddressDto addressDto, @PathVariable Integer id) {
        return personService.updateAddress(addressDto);
    }

    @DeleteMapping("/{id}")
    public PersonDto deletePerson(@PathVariable Integer id) {
        return personService.deletePerson(id);
    }
}
