package com.example.LMS.repositories;

import com.example.LMS.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long>  {
}
