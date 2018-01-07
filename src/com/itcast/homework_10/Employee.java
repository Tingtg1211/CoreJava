package com.itcast.homework_10;

public class Employee {
    String name;
    String id;
    double salary;
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public double getSalary(){
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }

    public void work(){
        System.out.print("name:" + name +"\t"+ "id:" + id + "\t"+ "salary:" + salary + "\t");
    }

}
