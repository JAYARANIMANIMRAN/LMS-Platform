package com.example.LMS.services;


import com.example.LMS.models.Student;
import com.example.LMS.models.Teacher;
import com.example.LMS.models.User;
import com.example.LMS.repositories.AdminRepository;
import com.example.LMS.repositories.StudentRepository;
import com.example.LMS.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

        private final AdminRepository adminRepository;
        private final StudentRepository studentRepository;
        private final TeacherRepository teacherRepository;

        @Autowired
        public UserService(AdminRepository adminRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
            this.adminRepository = adminRepository;
            this.studentRepository = studentRepository;
            this.teacherRepository = teacherRepository;
        }

        // Admin creation
        public KafkaProperties.Admin createAdmin(KafkaProperties.Admin admin) {
            return adminRepository.save(admin);
        }

        // Student creation
        public Student createStudent(Student student) {
            return studentRepository.save(student);
        }

        // Teacher creation
        public Teacher createTeacher(Teacher teacher) {
            return teacherRepository.save(teacher);
        }

        // Fetch All Users (optional)
        public List<User> getAllUsers() {
            List<User> allUsers = new ArrayList<>();
            allUsers.addAll(adminRepository.findAll());
            allUsers.addAll(studentRepository.findAll());
            allUsers.addAll(teacherRepository.findAll());
            return allUsers;
        }
    }

}
