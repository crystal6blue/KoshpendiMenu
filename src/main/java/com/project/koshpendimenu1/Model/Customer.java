package com.project.koshpendimenu1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NonNull
    private String surname;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private String role;
    private String address;

    public Customer(String surname) {
        this.surname = surname;
    }

    public Customer(Long id, String name, @NonNull String surname, LocalDate birthDate, String email, String phoneNumber, String role, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.address = address;
    }

    public Customer() {

    }
}