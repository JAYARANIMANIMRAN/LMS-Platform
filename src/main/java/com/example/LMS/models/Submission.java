package com.example.LMS.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
        @Id @GeneratedValue
        private Long id;
        private String fileUrl;

        @ManyToOne
        private User student;

        @ManyToOne
        private Assignment assignment;

        private LocalDate submittedDate;


}
