package com.rajithk.micro.service;

import com.rajithk.micro.model.Student;

import java.util.Optional;

public interface StudentService  {

    Student save(Student student);

    Student fetchStudentById(int id);
}
