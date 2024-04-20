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
    public Iterable<PersonDto> findPersonsByCity(@PathVariable String city) {
        return personService.findPersonsByCity(city);
    }

    @GetMapping("/ages/{age1}/{age2}")
    public Iterable<PersonDto> findPersonsByAges(@PathVariable int age1, @PathVariable int age2) {
        return personService.findPersonsByAges(age1, age2);
    }

    @PutMapping("/{id}/name/{name}")
    public PersonDto updatePersonName(@PathVariable Integer id, @PathVariable String name) {
        return personService.updatePersonName(id, name);
    }

    @GetMapping("/name/{name}")
    public Iterable<PersonDto> findPersonsByName(@PathVariable String name) {
        return personService.findPersonsByName(name);
    }

    @GetMapping("/population/city")
    public Iterable<Map<String, Long>> getCityPopulation(@PathVariable String city) {
        return personService.getCityPopulation(city);
    }

    @PutMapping("/{id}/address")
    public PersonDto updateAddress(@RequestBody AddressDto addressDto, @PathVariable Integer id) {
        return personService.updateAddress(id, addressDto);
    }

    @DeleteMapping("/{id}")
    public PersonDto deletePerson(@PathVariable Integer id) {
        return personService.deletePerson(id);
    }
}
