package com.school.exercise2.service;

import com.school.exercise2.dto.StudentRequest;
import com.school.exercise2.dto.StudentResponse;
import org.springframework.data.domain.Page;

public interface StudentService {
    StudentResponse findById(Long id);
    Page<StudentResponse> findAll(int page, int size);
    StudentResponse create(StudentRequest request);
    StudentResponse update(Long id, StudentRequest request);
    void delete(Long id);
}
