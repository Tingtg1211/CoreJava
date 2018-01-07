package com.itcast.homework_15;

public class Person extends Object{
    private String name;
    private int  age;
    public Person(){}
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int  getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }else if(this == obj){
            return true;
        }else if(obj instanceof Person){
            Person p = (Person)obj;
            return p.age == this.age;
        }else {
            return false;
        }
    }

}
