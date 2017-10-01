package com.asterik.utility.snapshot.MapCollectionFramework;

import java.util.*;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {

        Department d1 = new Department("Science", 1);
        Department d2 = new Department("math", 2);
        Department d3 = new Department("eco", 3);

        Employee employee1 = new Employee("Shilpa", 1, d1);
        Employee employee2 = new Employee("Seth", 2, d2);
        Employee employee3 = new Employee("Shi", 3, d2);

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
        List<Department> departments = Arrays.asList(d1, d2, d3);


        Map<Department, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));


        Map<Department,Boolean> mapList = new HashMap<>();


        List<Employee> emp = new ArrayList<>();
        for (Employee employee : employees) {

            for (Department department : departments) {
                mapList.put(department,emp.add(employee));
            }


        }

        System.out.println(emp.get(0));
        System.out.println(emp.get(1));
        System.out.println(emp.get(5));

        System.out.println(mapList.get(d2));


//        System.out.println(byDept.get(d2));



        Map<Department, Integer> mapSalary = employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getEmpId)));

        System.out.println(mapSalary.get(d2));



    }

}
