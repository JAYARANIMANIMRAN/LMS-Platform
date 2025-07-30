package com.example.LMS.models;

import jakarta.persistence.*;

@Entity
public class Submission {
        @Id @GeneratedValue
        private Long id;

        private String submittedFileUrl;
        private Integer marks;

        @ManyToOne
        @JoinColumn(name = "student_id")
        private Student student;

        @ManyToOne
        @JoinColumn(name = "assignment_id")
        private Assignment assignment;
}
