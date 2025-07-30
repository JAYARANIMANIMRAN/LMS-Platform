package com.example.LMS.services;

import com.example.LMS.models.Course;
import com.example.LMS.models.Teacher;
import com.example.LMS.models.Classroom;
import com.example.LMS.repositories.CourseRepository;
import com.example.LMS.repositories.TeacherRepository;
import com.example.LMS.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    public Course createCourse(Course course) {
        // Ensure teacher and classroom exist and are attached properly
        Teacher teacher = teacherRepository.findById(course.getTeacher().getId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Classroom classroom = classroomRepository.findById(course.getClassroom().getId())
                .orElseThrow(() -> new RuntimeException("Classroom not found"));

        course.setTeacher(teacher);
        course.setClassroom(classroom);

        // Set course reference in materials and assignments
        if (course.getMaterials() != null) {
            course.getMaterials().forEach(m -> m.setCourse(course));
        }

        if (course.getAssignments() != null) {
            course.getAssignments().forEach(a -> a.setCourse(course));
        }

        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
