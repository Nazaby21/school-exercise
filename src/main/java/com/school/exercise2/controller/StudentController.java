package com.school.exercise2.controller;


import com.school.exercise2.dto.StudentRequest;
import com.school.exercise2.dto.StudentResponse;
import com.school.exercise2.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }
    @GetMapping
    public Page<StudentResponse> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return studentService.findAll(page, size);
    }
    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest studentRequest){
        return ResponseEntity.ok(studentService.create(studentRequest));
    }
    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable Long id,@Valid @RequestBody StudentRequest request) {
        return studentService.update(id, request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
