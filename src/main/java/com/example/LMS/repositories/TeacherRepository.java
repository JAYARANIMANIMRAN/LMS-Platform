package com.example.LMS.repositories;

import com.example.LMS.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByDepartmentId(Long departmentId);
    Teacher findByEmail(String email);
}
