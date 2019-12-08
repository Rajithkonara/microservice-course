package com.rajithk.micro.controller;

import com.rajithk.micro.model.Student;
import com.rajithk.micro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting() {
        return "Greeting";
    }

    @PostMapping(value = "/student")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping(value = "/student")
    public ResponseEntity<Student> fetchStudent(@RequestParam int id) {

        Student student = studentService.fetchStudentById(id);
        if (student == null) {
           return ResponseEntity.notFound().build();
        } else  {
            return ResponseEntity.ok().body(student);
        }
    }
}
