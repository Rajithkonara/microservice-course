package com.rajithk.rentcloud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
@Getter @Setter
public class Vehicle {

    @Id
    @GeneratedValue
    private int id;

    private String make;
    private String model;
    private String type;
    private int year;

}
