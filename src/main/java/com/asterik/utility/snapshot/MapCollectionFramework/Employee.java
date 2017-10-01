package com.asterik.utility.snapshot.MapCollectionFramework;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    String empName;
    int empId;
    Department department;

}
