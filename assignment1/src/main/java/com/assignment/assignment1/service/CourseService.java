package com.assignment.assignment1.service;

import com.assignment.assignment1.entity.Course;
import com.assignment.assignment1.entity.Lesson;
import com.assignment.assignment1.repository.CourseRepo;
import com.assignment.assignment1.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private LessonRepo lessonRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public List<Lesson> getLessons(Long courseId) {
        return lessonRepo.findByCourseId(courseId);
    }
}

