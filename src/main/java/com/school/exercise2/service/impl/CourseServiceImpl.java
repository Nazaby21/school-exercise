package com.school.exercise2.service.impl;

import com.school.exercise2.dto.CourseRequest;
import com.school.exercise2.dto.CourseResponse;
import com.school.exercise2.model.Course;
import com.school.exercise2.model.Student;
import com.school.exercise2.repository.CourseRepository;
import com.school.exercise2.repository.StudentRepository;
import com.school.exercise2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    public CourseResponse findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .toResponse();
    }

    @Override
    public Page<CourseResponse> findAll(int page, int size) {
        return courseRepository.findAll(PageRequest.of(page, size))
                .map(Course::toResponse);
    }

    @Override
    public CourseResponse create(CourseRequest request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setStudent(student);
        Course savedCourse = courseRepository.save(course);
        return savedCourse.toResponse();
    }

    @Override
    public CourseResponse update(Long id, CourseRequest request) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setStudent(student);
        Course updatedCourse = courseRepository.save(course);
        return updatedCourse.toResponse();
    }

    @Override
    public void delete(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        courseRepository.delete(course);
    }
}
