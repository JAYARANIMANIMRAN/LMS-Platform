package com.example.LMS.repositories;

import com.example.LMS.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByClassRoomId(Long classRoomId);
}
