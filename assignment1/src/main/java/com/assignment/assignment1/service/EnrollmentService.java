package com.assignment.assignment1.service;

import com.assignment.assignment1.entity.Enrollment;
import com.assignment.assignment1.repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepo repo;

    public String enroll(Long userId, Long courseId) {

        if (repo.existsByUserIdAndCourseId(userId, courseId)) {
            return "User already enrolled (idempotent)";
        }

        Enrollment e = new Enrollment();
        e.setUserId(userId);
        e.setCourseId(courseId);
        repo.save(e);

        return "Enrollment successful";
    }
}

