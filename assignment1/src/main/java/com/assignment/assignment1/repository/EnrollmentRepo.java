package com.assignment.assignment1.repository;

import com.assignment.assignment1.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
    boolean existsByUserIdAndCourseId(Long userId, Long courseId);
}

