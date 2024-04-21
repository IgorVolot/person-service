package ait.cohort34.person.service;

import ait.cohort34.person.dto.AddressDto;
import ait.cohort34.person.dto.CityPopulationDto;
import ait.cohort34.person.dto.PersonDto;

import java.util.Map;

public interface PersonService {
    Boolean addPerson(PersonDto personDto);

    PersonDto findPersonById(Integer id);

    Iterable<PersonDto> findPersonsByCity(String city);

    Iterable<PersonDto> findPersonsByAges(Integer age1, Integer age2);

    PersonDto updatePersonName(Integer id, String name);

    Iterable<PersonDto> findPersonsByName(String name);

    CityPopulationDto getCityPopulation(String city);

    PersonDto updateAddress(Integer id, AddressDto addressDto);

    PersonDto deletePerson(Integer id);
}
