package com.assignment.assignment1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enrollments",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "course_id"}))
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long courseId;
}

