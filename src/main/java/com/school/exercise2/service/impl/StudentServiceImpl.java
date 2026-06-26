package com.school.exercise2.service.impl;

import com.school.exercise2.dto.StudentRequest;
import com.school.exercise2.dto.StudentResponse;
import com.school.exercise2.model.Student;
import com.school.exercise2.repository.StudentRepository;
import com.school.exercise2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public StudentResponse findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .toResponse();
    }

    @Override
    public Page<StudentResponse> findAll(int page, int size) {
        return studentRepository.findAll(PageRequest.of(page,size))
                .map(Student::toResponse);
    }

    @Override
    public StudentResponse create(StudentRequest request) {
        Student student = new Student(request.getName(), request.getEmail(), request.getGender());
        Student savedStudent = studentRepository.save(student);
        return savedStudent.toResponse();
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setGender(request.getGender());

        Student updatedStudent = studentRepository.save(student);

        return updatedStudent.toResponse();
    }

    @Override
    public void delete(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        studentRepository.delete(student);
    }
}
