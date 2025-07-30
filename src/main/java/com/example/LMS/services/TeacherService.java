package com.example.LMS.services;

import com.example.LMS.models.*;
import com.example.LMS.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired private ClassRoomRepository classRoomRepo;
    @Autowired private StudentRepository studentRepo;
    @Autowired private MaterialRepository materialRepo;
    @Autowired private AssignmentRepository assignmentRepo;
    @Autowired private TeacherRepository teacherRepo;

    public String createClass(ClassRoom classRoom) {
        classRoomRepo.save(classRoom);
        return "Class created successfully!";
    }

    public String addStudent(Long classId, Student student) {
        ClassRoom classRoom = classRoomRepo.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        student.setClassRoom(classRoom);
        studentRepo.save(student);
        return "Student added to class!";
    }

    public String postMaterial(Long classId, Material material) {
        ClassRoom classRoom = classRoomRepo.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        material.setClassRoom(classRoom);
        materialRepo.save(material);
        return "Material posted!";
    }

    public String postAssignment(Long classId, Assignment assignment) {
        ClassRoom classRoom = classRoomRepo.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        assignment.setClassRoom(classRoom);
        assignmentRepo.save(assignment);
        return "Assignment posted!";
    }
}
