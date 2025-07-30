package com.example.LMS.services;

import com.example.LMS.models.*;
import com.example.LMS.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired private MaterialRepository materialRepo;
    @Autowired private AssignmentRepository assignmentRepo;
    @Autowired private SubmissionRepository submissionRepo;
    @Autowired private StudentRepository studentRepo;
    @Autowired private AssignmentRepository assignRepo;

    public List<Material> viewMaterials(Long classId) {
        return materialRepo.findByClassRoomId(classId);
    }

    public List<Assignment> viewAssignments(Long classId) {
        return assignmentRepo.findByClassRoomId(classId);
    }

    public String submitAssignment(Long assignmentId, Submission submission) {
        Assignment assignment = assignRepo.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        Student student = studentRepo.findById(submission.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        submission.setAssignment(assignment);
        submission.setStudent(student);

        submissionRepo.save(submission);
        return "Assignment submitted successfully!";
    }
}
