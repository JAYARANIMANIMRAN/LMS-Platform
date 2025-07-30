package com.example.LMS.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Teacher> teachers;
}
