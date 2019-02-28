package com.kali.streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

/**
 * Created by mpalavelli on 01-08-2018.
 */
public class SteramsOnPerson {
    public static void main(String[] args) {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };

        /*javaProgrammers.stream().forEach(p -> System.out.printf("%s %s; \n",p.getFirstName(),p.getLastName()));
        System.out.println();
        phpProgrammers.stream().forEach(p -> System.out.printf("%s %s; \n",p.getFirstName(),p.getLastName()));*/

        Consumer<Person> consumerPerson = p -> p.setSalary((p.getSalary()*5)/100 + p.getSalary());
        //javaProgrammers.stream().forEach(p-> System.out.println(p.getSalary()));
        System.out.println("----------------------------");
        javaProgrammers.forEach(consumerPerson);
        phpProgrammers.forEach(consumerPerson);
        //javaProgrammers.stream().forEach(p-> System.out.println(p.getSalary()));
        System.out.println("----------------------------");
        javaProgrammers.stream().filter(p ->  p.getSalary()<2000).forEach(p-> System.out.println(p.getSalary()));



        System.out.println("Show female PHP programmers that earn more than $1,400 and are older than 24 years:");
        // Define some filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        System.out.println("\n");

        Set<String> setPersons = javaProgrammers.stream().map(Person::getFirstName).collect(toSet());
        TreeSet<String> treeMapPersons = javaProgrammers.stream().map(Person::getFirstName).collect(toCollection(TreeSet::new));
        System.out.println(javaProgrammers.stream().mapToInt(p -> p.getSalary()).sum());

    }
}
