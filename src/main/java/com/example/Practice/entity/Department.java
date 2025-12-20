package com.example.Practice.entity;

import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String deparment_Name;

    @ManyToOne
    @JoinColumn(name = "company_Id")
    private Company company;
}
