package com.example.LMS.services;

import com.example.LMS.models.*;
import com.example.LMS.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired private CollegeRepository collegeRepo;
    @Autowired private DepartmentRepository departmentRepo;
    @Autowired private TeacherRepository teacherRepo;
    @Autowired private AdminRepository adminRepo;

    // ----------- COLLEGE CRUD -----------

    public String addCollege(College college) {
        collegeRepo.save(college);
        return "College added successfully!";
    }

    public List<College> getAllColleges() {
        return collegeRepo.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("College not found"));
    }

    public String updateCollege(Long id, College updatedCollege) {
        College college = collegeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("College not found"));

        college.setName(updatedCollege.getName());
        college.setAdmin(updatedCollege.getAdmin());
        collegeRepo.save(college);
        return "College updated successfully!";
    }

    public String deleteCollege(Long id) {
        collegeRepo.deleteById(id);
        return "College deleted successfully!";
    }

    // ----------- DEPARTMENT CRUD -----------

    public String addDepartment(Long collegeId, Department department) {
        College college = collegeRepo.findById(collegeId)
                .orElseThrow(() -> new RuntimeException("College not found"));
        department.setCollege(college);
        departmentRepo.save(department);
        return "Department added successfully!";
    }

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public String updateDepartment(Long id, Department updatedDept) {
        Department dept = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        dept.setName(updatedDept.getName());
        dept.setHod(updatedDept.getHod());
        departmentRepo.save(dept);
        return "Department updated successfully!";
    }

    public String deleteDepartment(Long id) {
        departmentRepo.deleteById(id);
        return "Department deleted successfully!";
    }

    // ----------- TEACHER CRUD -----------

    public String addTeacher(Long departmentId, Teacher teacher) {
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        teacher.setDepartment(department);
        teacherRepo.save(teacher);
        return "Teacher added successfully!";
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public String updateTeacher(Long id, Teacher updatedTeacher) {
        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        teacher.setName(updatedTeacher.getName());
        teacher.setEmail(updatedTeacher.getEmail());
        teacher.setDepartment(updatedTeacher.getDepartment());
        teacherRepo.save(teacher);
        return "Teacher updated successfully!";
    }

    public String deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
        return "Teacher deleted successfully!";
    }
}
