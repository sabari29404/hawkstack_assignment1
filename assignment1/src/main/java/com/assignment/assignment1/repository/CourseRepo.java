package com.assignment.assignment1.repository;

import com.assignment.assignment1.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {}

