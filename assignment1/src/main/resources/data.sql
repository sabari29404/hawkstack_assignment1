INSERT INTO user (id, name) VALUES (1, 'yyy'), (2, 'xxx');

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
