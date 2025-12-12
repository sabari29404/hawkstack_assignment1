package com.assignment.assignment1.service;

import com.assignment.assignment1.entity.LessonCompletion;
import com.assignment.assignment1.repository.LessonCompletionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    @Autowired
    private LessonCompletionRepo repo;

    public String completeLesson(Long userId, Long courseId, Long lessonId) {

        if (repo.existsByUserIdAndLessonId(userId, lessonId)) {
            return "Lesson already completed (idempotent)";
        }

        LessonCompletion lc = new LessonCompletion();
        lc.setUserId(userId);
        lc.setCourseId(courseId);
        lc.setLessonId(lessonId);
        repo.save(lc);

        return "Lesson completed successfully";
    }

    public int getCompletedCount(Long userId, Long courseId) {
        return repo.countByUserIdAndCourseId(userId, courseId);
    }

}

