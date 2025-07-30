package com.example.LMS.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {
        @Id @GeneratedValue
        private Long id;

        private String title;
        private String description;
        private String fileUrl;

        @Temporal(TemporalType.DATE)
        private Date dueDate;

        @ManyToOne
        @JoinColumn(name = "classroom_id")
        private Classroom classRoom;

        @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
        private List<Submission> submissions;
}
