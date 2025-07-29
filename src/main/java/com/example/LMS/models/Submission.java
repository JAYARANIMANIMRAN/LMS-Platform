package com.example.LMS.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String fileUrl;
        private LocalDateTime submittedAt;

        @ManyToOne
        private Assignment assignment;

        @ManyToOne
        private Student submittedBy;

        @ManyToOne
        @JoinColumn(name = "student_id")
        private Student student;

}
