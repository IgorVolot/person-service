package ait.cohort34.person.service;

import ait.cohort34.person.dto.AddressDto;
import ait.cohort34.person.dto.PersonDto;

import java.util.List;
import java.util.Map;

public interface PersonService {
    Boolean addPerson(PersonDto personDto);

    PersonDto findPersonById(Integer id);

    List<PersonDto> findPersonsByCity(String city);

    List<PersonDto> findPersonsByAge(Integer age);

    PersonDto updatePersonName(Integer id, String name);

    List<PersonDto> findPersonsByName(String name);

    List<Map<String, Long>> getCityPopulation(String city);

    PersonDto updateAddress(AddressDto addressDto);

    PersonDto deletePerson(Integer id);
}
