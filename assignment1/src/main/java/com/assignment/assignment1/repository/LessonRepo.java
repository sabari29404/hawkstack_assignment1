package com.assignment.assignment1.repository;

import com.assignment.assignment1.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepo extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourseId(Long courseId);
}

