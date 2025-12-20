package com.example.Practice.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company_name;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Department> departments;
}
