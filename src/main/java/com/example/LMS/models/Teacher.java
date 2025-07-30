package com.example.LMS.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Teacher {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<ClassRoom> classes;
}
