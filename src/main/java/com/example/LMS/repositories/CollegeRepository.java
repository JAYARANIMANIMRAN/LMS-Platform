package com.example.LMS.repositories;

import com.example.LMS.models.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeRepository extends JpaRepository<College, Long> {
    List<College> findByAdminId(Long adminId);
}
