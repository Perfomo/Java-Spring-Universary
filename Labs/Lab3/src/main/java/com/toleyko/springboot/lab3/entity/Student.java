package com.toleyko.springboot.lab3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "department")
    private String department;

    @Column(name = "enrollment")
    private String date;

    @Column(name = "uni_group")
    private String group;
}
