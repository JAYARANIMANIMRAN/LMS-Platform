package com.example.LMS.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Admin {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<College> colleges;
}
