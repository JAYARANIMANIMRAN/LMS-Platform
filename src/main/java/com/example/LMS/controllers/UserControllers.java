package com.example.LMS.controllers;


import com.example.LMS.models.Admin;
import com.example.LMS.models.Student;
import com.example.LMS.models.Teacher;
import com.example.LMS.models.User;
import com.example.LMS.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserControllers {


        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping("/admin")
        public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
            return ResponseEntity.ok(userService.createAdmin(admin));
        }

        @PostMapping("/student")
        public ResponseEntity<Student> createStudent(@RequestBody Student student) {
            return ResponseEntity.ok(userService.createStudent(student));
        }

        @PostMapping("/teacher")
        public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
            return ResponseEntity.ok(userService.createTeacher(teacher));
        }

        @GetMapping("/all")
        public ResponseEntity<List<User>> getAllUsers() {
            return ResponseEntity.ok(userService.getAllUsers());
        }

}
