# hawkstack_assignment1

---

# Course Learning System – Spring Boot Project

A simple **Spring Boot learning management system (LMS)** where users can:

✔ Enroll in courses (only once — idempotent)
✔ View lessons (only if enrolled)
✔ Mark lessons as completed (idempotent)
✔ Check course progress
✔ View all users, courses, and lessons

This project is designed for **beginners** to understand REST APIs, Spring Boot basics, and idempotent operations.

---

# Features

### User Enrollment

* A user can enroll in a course only once.
* API remains **idempotent** (multiple calls → same result).

### Lesson Completion

* A lesson can be marked completed only once per user.
* API is **idempotent**.

### Access Control

* Only enrolled users can view lessons.
* Others receive **403 Forbidden**.

### Progress Tracking

* Shows how many lessons a user completed in a course.

---

# Project Structure

```
src/main/java/com/example/course
 ├── controller
 │    ├── CourseController.java
 │    └── UserController.java
 │
 ├── service
 │    ├── EnrollmentService.java
 │    ├── LessonService.java
 │    ├── CourseService.java
 │    └── UserService.java
 │
 ├── repository
 │    ├── UserRepo.java
 │    ├── CourseRepo.java
 │    ├── LessonRepo.java
 │    ├── EnrollmentRepo.java
 │    └── LessonCompletionRepo.java
 │
 ├── entity
 │    ├── User.java
 │    ├── Course.java
 │    ├── Lesson.java
 │    ├── Enrollment.java
 │    └── LessonCompletion.java
 │
 └── CourseLearningSystemApplication.java
```

---

# Database Tables

This project uses **5 tables**:

| Table                | Purpose                                    |
| -------------------- | ------------------------------------------ |
| `user`               | Stores system users                        |
| `course`             | Stores course list                         |
| `lesson`             | Stores lessons under each course           |
| `enrollments`        | Stores which user enrolled in which course |
| `lesson_completions` | Stores completed lessons per user          |

`uniqueConstraints` ensure idempotency for:

* (userId, courseId) → enrollment
* (userId, lessonId) → lesson completion

---

# Technology Stack

* **Java 17+**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **MySQL**
* **Hibernate**
* **REST API**

---

# Setup Instructions

1. Install:

   * Java 17+
   * Maven
   * MySQL

2. Create database:

   ```sql
   CREATE DATABASE courses_db;
   ```

3. Update `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/courses_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. Run the Spring Boot application.

---

# 📌 API Endpoints

## 1. Enroll User (Idempotent)

```
POST /courses/{courseId}/enroll?userId=1
```

### Response:

* `"Enrollment successful"`
* `"User already enrolled (idempotent)"`

---

## 2. Complete Lesson (Idempotent)

```
POST /courses/{courseId}/lessons/{lessonId}/complete?userId=1
```

### Response:

* `"Lesson completed successfully"`
* `"Lesson already completed (idempotent)"`

---

## 3. Get Lessons (Access Controlled)

```
GET /courses/{courseId}/lessons?userId=1
```

### If not enrolled:

```
403 Forbidden — "You must enroll in this course to access lessons."
```

---

## 4. Get Course Progress

```
GET /courses/users/{userId}/courses/{courseId}/progress
```

### Example Response:

```json
{
  "completed": 2,
  "total": 5,
  "progress": "40%"
}
```

---

## 5. List All Courses

```
GET /courses
```

## 6. List All Users

```
GET /users
```

---

# Sample Data (data.sql)

```sql
INSERT INTO user (id, name) VALUES (1, 'Sabari'), (2, 'Arun');

INSERT INTO course (id, title) VALUES 
(1, 'Java Basics'),
(2, 'Spring Boot Beginners');

INSERT INTO lesson (id, course_id, title) VALUES
(1, 1, 'Intro to Java'),
(2, 1, 'Variables'),
(3, 1, 'Loops'),
(4, 2, 'Intro to Spring'),
(5, 2, 'Controllers'),
(6, 2, 'Services');
```

---

# Learning Concepts Covered

* REST API design
* Idempotent operations
* Spring Boot layers (Controller → Service → Repository)
* JPA + Hibernate
* Database relations
* Using MySQL with Spring Boot

---

# Author

**Sabari**
