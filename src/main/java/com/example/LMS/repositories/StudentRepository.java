package com.example.LMS.repositories;

import com.example.LMS.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClassRoomId(Long classRoomId);
    Student findByEmail(String email);
}
