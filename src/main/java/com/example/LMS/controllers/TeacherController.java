package com.example.LMS.controllers;

import com.example.LMS.models.*;
import com.example.LMS.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/class")
    public String createClass(@RequestBody ClassRoom classRoom) {
        return teacherService.createClass(classRoom);
    }

    @PostMapping("/class/{classId}/student")
    public String addStudent(@PathVariable Long classId, @RequestBody Student student) {
        return teacherService.addStudent(classId, student);
    }

    @PostMapping("/class/{classId}/material")
    public String postMaterial(@PathVariable Long classId, @RequestBody Material material) {
        return teacherService.postMaterial(classId, material);
    }

    @PostMapping("/class/{classId}/assignment")
    public String postAssignment(@PathVariable Long classId, @RequestBody Assignment assignment) {
        return teacherService.postAssignment(classId, assignment);
    }
}
