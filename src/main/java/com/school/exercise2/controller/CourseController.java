package com.school.exercise2.controller;

import com.school.exercise2.dto.CourseRequest;
import com.school.exercise2.dto.CourseResponse;
import com.school.exercise2.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }
    @GetMapping
    public Page<CourseResponse> findAll(@RequestParam(defaultValue = "0") @Min(0) int page, @RequestParam(defaultValue = "10") int size) {
        return courseService.findAll(page, size);
    }
    @PostMapping
    public ResponseEntity<CourseResponse> create(@Valid @RequestBody CourseRequest request){
        return ResponseEntity.ok(courseService.create(request));
    }
    @PutMapping("/{id}")
    public CourseResponse update(@PathVariable Long id,@Valid @RequestBody CourseRequest request) {
        return courseService.update(id, request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
