package com.example.LMS.controllers;

import com.example.LMS.models.*;
import com.example.LMS.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // --------------------- COLLEGE ---------------------
    @PostMapping("/college")
    public String addCollege(@RequestBody College college) {
        return adminService.addCollege(college);
    }

    @GetMapping("/college")
    public List<College> getAllColleges() {
        return adminService.getAllColleges();
    }

    @GetMapping("/college/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return adminService.getCollegeById(id);
    }

    @PutMapping("/college/{id}")
    public String updateCollege(@PathVariable Long id, @RequestBody College updatedCollege) {
        return adminService.updateCollege(id, updatedCollege);
    }

    @DeleteMapping("/college/{id}")
    public String deleteCollege(@PathVariable Long id) {
        return adminService.deleteCollege(id);
    }

    // --------------------- DEPARTMENT ---------------------
    @PostMapping("/department/{collegeId}")
    public String addDepartment(@PathVariable Long collegeId, @RequestBody Department department) {
        return adminService.addDepartment(collegeId, department);
    }

    @GetMapping("/department")
    public List<Department> getAllDepartments() {
        return adminService.getAllDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return adminService.getDepartmentById(id);
    }

    @PutMapping("/department/{id}")
    public String updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        return adminService.updateDepartment(id, updatedDepartment);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        return adminService.deleteDepartment(id);
    }

    // --------------------- TEACHER ---------------------
    @PostMapping("/teacher/{departmentId}")
    public String addTeacher(@PathVariable Long departmentId, @RequestBody Teacher teacher) {
        return adminService.addTeacher(departmentId, teacher);
    }

    @GetMapping("/teacher")
    public List<Teacher> getAllTeachers() {
        return adminService.getAllTeachers();
    }

    @GetMapping("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return adminService.getTeacherById(id);
    }

    @PutMapping("/teacher/{id}")
    public String updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
        return adminService.updateTeacher(id, updatedTeacher);
    }

    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        return adminService.deleteTeacher(id);
    }
}
