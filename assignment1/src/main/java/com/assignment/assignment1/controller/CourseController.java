package com.assignment.assignment1.controller;

import com.assignment.assignment1.entity.Course;
import com.assignment.assignment1.entity.Lesson;
import com.assignment.assignment1.service.CourseService;
import com.assignment.assignment1.service.EnrollmentService;
import com.assignment.assignment1.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private CourseService courseService;

    @PostMapping("/{courseId}/enroll")
    public String enroll(
            @PathVariable Long courseId,
            @RequestParam Long userId) {

        return enrollmentService.enroll(userId, courseId);
    }

    @PostMapping("/{courseId}/lessons/{lessonId}/complete")
    public String completeLesson(
            @PathVariable Long courseId,
            @PathVariable Long lessonId,
            @RequestParam Long userId) {

        return lessonService.completeLesson(userId, courseId, lessonId);
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}/lessons")
    public List<Lesson> getLessons(@PathVariable Long courseId) {
        return courseService.getLessons(courseId);
    }

    @GetMapping("/users/{userId}/courses/{courseId}/progress")
    public Map<String, Object> getProgress(
            @PathVariable Long userId,
            @PathVariable Long courseId) {

        int completed = lessonService.getCompletedCount(userId, courseId);
        int total = courseService.getLessons(courseId).size();

        Map<String, Object> res = new HashMap<>();
        res.put("completed", completed);
        res.put("total", total);
        res.put("progress", (completed * 100) / total + "%");

        return res;
    }
}
