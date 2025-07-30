package com.example.LMS.models;

import jakarta.persistence.*;

@Entity
public class Material {
        @Id @GeneratedValue
        private Long id;

        private String title;
        private String description;
        private String fileUrl;

        @ManyToOne
        @JoinColumn(name = "classroom_id")
        private ClassRoom classRoom;
}
