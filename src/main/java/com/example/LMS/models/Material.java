package com.example.LMS.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String description;
        private String fileUrl;

        @ManyToOne
        private Classroom classroom;

        @ManyToOne
        private Admin uploadedBy;

        @ManyToOne
        @JoinColumn(name = "course_id")
        private Course course;

}
