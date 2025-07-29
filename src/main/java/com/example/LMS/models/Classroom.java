package com.example.LMS.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String className;

        @ManyToOne
        private Admin createdBy;

        @ManyToMany
        private List<Student> students = new ArrayList<>();
}
