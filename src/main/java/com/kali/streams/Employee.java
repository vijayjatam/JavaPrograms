package com.kali.streams;

/**
 * Created by mpalavelli on 31-07-2018.
 */
public class Employee {
    private int empId;
    private String empName;
    private double salary;
    public Employee(int id, String name, double sal){
        this.empId = id;
        this.empName = name;
        this.salary = sal;
    }

    public  boolean updateSalary(double sal){
        this.salary = this.salary + sal;
        return true;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
