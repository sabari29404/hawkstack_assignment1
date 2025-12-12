package com.assignment.assignment1.repository;

import com.assignment.assignment1.entity.LessonCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonCompletionRepo extends JpaRepository<LessonCompletion, Long> {
    boolean existsByUserIdAndLessonId(Long userId, Long lessonId);
    int countByUserIdAndCourseId(Long userId, Long courseId);
}

