package com.assignment.assignment1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lesson_completions",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "lesson_id"}))
@Data
public class LessonCompletion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long courseId;
    private Long lessonId;
}

