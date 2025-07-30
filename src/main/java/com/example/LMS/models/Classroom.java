package com.example.LMS.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
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
