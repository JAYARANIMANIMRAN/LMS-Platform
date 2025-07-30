package com.example.LMS.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ClassRoom {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<Material> materials;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<Assignment> assignments;
}
