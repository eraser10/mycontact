package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = new Person();

        person.setName("john");
        person.setAge(10);
        person.setBloodType("A");
//        person.setBlock();

        personRepository.save(person);
//        System.out.println(personRepository.findAll());

        List<Person> result = personRepository.findByName("john");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("john");
        assertThat(result.get(0).getAge()).isEqualTo(10);
        assertThat(result.get(0).getBloodType()).isEqualTo("A");
    }

//    @Test
//    void hashCodeAndEquals() {
//        Person person1 = new Person("martin", 10, "A");
//        Person person2 = new Person("martin", 10, "A");
//
//        System.out.println(person1.equals(person2));
//        System.out.println(person1.hashCode());
//        System.out.println(person2.hashCode());
//
//
//        Map<Person, Integer> map = new HashMap<>();
//        map.put(person1, person1.getAge());
//
//        System.out.println(map);
//        System.out.println(map.get(person2));
//    }
//

    @Test
    void findByBloodType() {

        List<Person> result = personRepository.findByBloodType("A");

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(1).getName()).isEqualTo("benny");

//        System.out.println(result);
//        result.forEach(System.out::println);
    }

    @Test
    void findByBirthdayBetween() {

        List<Person> result = personRepository.findByMonthOfBirthday(8);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(1).getName()).isEqualTo("sophia");
//        result.forEach(System.out::println);

    }

//    private void givenPerson(String name, int age, String bloodType) {
//        givenPerson(name, age, bloodType, null);
//    }
//
//    private void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
//
//        Person person = new Person(name, age, bloodType);
//        person.setBirthday(new Birthday(birthday));
//
//        personRepository.save(person);
//    }
}