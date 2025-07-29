package com.example.LMS.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String description;
        private LocalDateTime deadline;

        @ManyToOne
        private Classroom classroom;

        @ManyToOne
        private Admin createdBy;

        @ManyToOne
        @JoinColumn(name = "course_id")
        private Course course;

}
