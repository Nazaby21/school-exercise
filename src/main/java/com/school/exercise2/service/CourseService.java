package com.school.exercise2.service;

import com.school.exercise2.dto.CourseRequest;
import com.school.exercise2.dto.CourseResponse;
import org.springframework.data.domain.Page;

public interface CourseService {
    CourseResponse findById(Long id);
    Page<CourseResponse> findAll(int page, int size);
    CourseResponse create(CourseRequest request);
    CourseResponse update(Long id, CourseRequest request);
    void delete(Long id);
}
