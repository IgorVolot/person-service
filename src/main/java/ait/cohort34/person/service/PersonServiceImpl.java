package ait.cohort34.person.service;

import ait.cohort34.person.dao.PersonRepository;
import ait.cohort34.person.dto.AddressDto;
import ait.cohort34.person.dto.PersonDto;
import ait.cohort34.person.dto.exceptions.PersonNotFoundException;
import ait.cohort34.person.model.Address;
import ait.cohort34.person.model.Person;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false) // to have ability to save changed items in SQL table
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;
    final ModelMapper modelMapper;

    @Override
    public Boolean addPerson(PersonDto personDto) {
        if ( personRepository.existsById(personDto.getId()) ) {
            return false;
        }
        personRepository.save(modelMapper.map(personDto, Person.class));
        return true;
    }

    @Override
    public PersonDto findPersonById(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public Iterable<PersonDto> findPersonsByCity(String city) {
        if ( city == null || city.isEmpty() ) {
            return Collections.emptyList();
        }
        return personRepository.findAllByAddressCity(city)
                .map(person -> modelMapper.map(person, PersonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<PersonDto> findPersonsByAges(Integer age1, Integer age2) {
        if ( age1 == null || age2 == null ) {
            return Collections.emptyList();
        } else {
            return personRepository.findAll().stream()
                    .filter(person -> person.getAge() >= age1 && person.getAge() < age2)
                    .map(person -> modelMapper.map(person, PersonDto.class))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public PersonDto updatePersonName(Integer id, String name) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        person.setName(name);
        personRepository.save(person);
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public Iterable<PersonDto> findPersonsByName(String name) {
        if ( name == null || name.isEmpty() ) {
            return Collections.emptyList();
        }
        return personRepository.findAllByNameIgnoreCase(name)
                .map(person -> modelMapper.map(person, PersonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Map<String, Long>> getCityPopulation(String city) {
        //TODO
        return List.of();
    }

    @Override
    public PersonDto updateAddress(Integer id, AddressDto addressDto) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        person.setAddress(modelMapper.map(addressDto, Address.class));
        personRepository.save(person);
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public PersonDto deletePerson(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        personRepository.delete(person);
        return modelMapper.map(person, PersonDto.class);
    }


}
