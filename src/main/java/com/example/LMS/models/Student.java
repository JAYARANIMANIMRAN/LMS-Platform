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
public class Student extends User{
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classRoom;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Submission> submissions;
}
