package com.example.LMS.services;

import com.example.LMS.models.*;
import com.example.LMS.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired private CollegeRepository collegeRepo;
    @Autowired private DepartmentRepository departmentRepo;
    @Autowired private TeacherRepository teacherRepo;
    @Autowired private AdminRepository adminRepo;

    public String addCollege(College college) {
        collegeRepo.save(college);
        return "College added successfully!";
    }

    public String addDepartment(Long collegeId, Department department) {
        College college = collegeRepo.findById(collegeId)
                .orElseThrow(() -> new RuntimeException("College not found"));
        department.setCollege(college);
        departmentRepo.save(department);
        return "Department added successfully!";
    }

    public String addTeacher(Long departmentId, Teacher teacher) {
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        teacher.setDepartment(department);
        teacherRepo.save(teacher);
        return "Teacher added successfully!";
    }
}
