package com.horstmann.corejava.arrayList;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args){
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 11));
        staff.add(new Employee("Harry Hacker", 80000, 1987, 12, 16));
        staff.add(new Employee("Tony Tester", 40000, 1989, 11, 11));

        for(Employee e: staff)
            e.raiseSalary(5);

        for(Employee e: staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireday=" + e.getHireDay());

    }
}
