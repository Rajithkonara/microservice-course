package com.rajithk.rentcloud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter @Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String firstName;
    private String lastName;
    private String dlNumber;
    private String zipCode;

}
