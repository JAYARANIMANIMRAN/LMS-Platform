package com.example.LMS.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
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
        private ClassRoom classRoom;

        @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
        private List<Submission> submissions;
}
