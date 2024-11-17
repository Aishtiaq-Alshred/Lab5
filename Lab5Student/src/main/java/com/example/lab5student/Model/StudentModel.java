package com.example.lab5student.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentModel {

    private String ID;
    private String Name;
    private int Age;
    private String degree;
    private double GPA;

}
