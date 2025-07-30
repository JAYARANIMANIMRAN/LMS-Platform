package com.example.LMS.controllers;

import com.example.LMS.models.*;
import com.example.LMS.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/class/{classId}/materials")
    public List<Material> viewMaterials(@PathVariable Long classId) {
        return studentService.viewMaterials(classId);
    }

    @GetMapping("/class/{classId}/assignments")
    public List<Assignment> viewAssignments(@PathVariable Long classId) {
        return studentService.viewAssignments(classId);
    }

    @PostMapping("/assignment/{assignmentId}/submit")
    public String submitAssignment(@PathVariable Long assignmentId, @RequestBody Submission submission) {
        return studentService.submitAssignment(assignmentId, submission);
    }
}
