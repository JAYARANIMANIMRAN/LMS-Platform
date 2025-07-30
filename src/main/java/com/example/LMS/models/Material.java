package com.example.LMS.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material {
        @Id @GeneratedValue
        private Long id;

        private String title;
        private String description;
        private String fileUrl;

        @ManyToOne
        @JoinColumn(name = "classroom_id")
        private Classroom classRoom;





}
