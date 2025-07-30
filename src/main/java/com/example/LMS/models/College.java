package com.example.LMS.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class College {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Department> departments;
}
