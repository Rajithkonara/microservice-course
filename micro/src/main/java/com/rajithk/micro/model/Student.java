package com.rajithk.micro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity(name = "student")
public class Student {

    @Id
    private int id;
    private String firstName;
    private String lastName;

}
