package com.example.LMS.repositories;

import com.example.LMS.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByClassRoomId(Long classRoomId);
}
