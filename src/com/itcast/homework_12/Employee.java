package com.itcast.homework_12;

public class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee(){
        super();
    }

    public Employee(String name, String id, double salary){
        super();
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
