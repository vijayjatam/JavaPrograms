package com.kali.kali.streams;

import com.kali.streams.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mpalavelli on 31-07-2018.
 */
public class StreamsOnEmp {
    public static void main(String[] args) {
        com.kali.streams.Employee[] arrayOfEmps = {
                new com.kali.streams.Employee(1, "Jeff Bezos", 100000.0),
                new com.kali.streams.Employee(2, "Bill Gates", 200000.0),
                new com.kali.streams.Employee(3, "Mark Zuckerberg", 300000.0)
        };

        Stream.Builder<com.kali.streams.Employee> employeeBuilder = Stream.builder();
        employeeBuilder.accept(arrayOfEmps[0]);
        employeeBuilder.accept(arrayOfEmps[1]);
        employeeBuilder.accept(arrayOfEmps[2]);
        Stream<com.kali.streams.Employee> empStream = employeeBuilder.build();
        empStream.forEach(e -> System.out.println(e.getSalary()));
        //empStream.forEach(e -> e.getSalary());
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        empList.stream().forEach(e -> e.updateSalary(12.0));
        empList.stream().forEach(e -> System.out.println(e.getSalary()));

        empList.toArray();
    }
}
