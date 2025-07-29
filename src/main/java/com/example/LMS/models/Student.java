package com.example.LMS.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @ManyToMany(mappedBy = "students")
    private List<Classroom> classrooms;

    @OneToMany(mappedBy = "student")
    private List<Submission> submissions;

}
