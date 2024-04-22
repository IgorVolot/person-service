package ait.cohort34.person.dao;

import ait.cohort34.person.dto.CityPopulationDto;
import ait.cohort34.person.model.Child;
import ait.cohort34.person.model.Employee;
import ait.cohort34.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface PersonRepository extends JpaRepository<Person, Integer> {
//    @Query("select p from Person p where p.address.city=:cityName")
    Stream<Person> findByAddressCityIgnoreCase(@Param("cityName") String city);

//    @Query("select p from Person p where p.name=?1")
    Stream<Person> findByNameIgnoreCase(String name);

    Stream<Person> findByBirthDateBetween(LocalDate from, LocalDate to);

    @Query("select new ait.cohort34.person.dto.CityPopulationDto(p.address.city, count (p)) from Person p group by p.address.city order by count (p) desc ")
    List<CityPopulationDto> getCityPopulation();

    @Query("")
    Stream<Child> findAllChildren();

    @Query("")
    Stream<Employee> findEmployeesBySalary(Double min, Double max);
}
