package com.example.LMS.controllers;

import com.example.LMS.models.*;
import com.example.LMS.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/college")
    public String addCollege(@RequestBody College college) {
        return adminService.addCollege(college);
    }

    @PostMapping("/department/{collegeId}")
    public String addDepartment(@PathVariable Long collegeId, @RequestBody Department department) {
        return adminService.addDepartment(collegeId, department);
    }

    @PostMapping("/teacher/{departmentId}")
    public String addTeacher(@PathVariable Long departmentId, @RequestBody Teacher teacher) {
        return adminService.addTeacher(departmentId, teacher);
    }
}
