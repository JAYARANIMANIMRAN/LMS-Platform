package com.example.LMS.repositories;

import com.example.LMS.models.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<ClassRoom, Long> {
    List<ClassRoom> findByTeacherId(Long teacherId);
}
