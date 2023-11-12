package com.example.socialratingapi.controller;

import com.example.socialratingapi.model.dto.point.PointDto;
import com.example.socialratingapi.model.dto.student.StudentRequestDto;
import com.example.socialratingapi.model.dto.student.StudentResponseDto;
import com.example.socialratingapi.service.students.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public List<StudentResponseDto> findAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/{studentId}")
    public StudentResponseDto findByIdStudents(@PathVariable Long studentId) {
        return studentService.getByIdStudent(studentId);
    }

    @PostMapping(value = "/create")
    public StudentResponseDto createStudents(@RequestBody StudentRequestDto studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @PatchMapping(value = "/update/{studentId}")
    public StudentResponseDto updateStudent(@RequestBody StudentRequestDto studentRequestDto,
                                            @PathVariable Long studentId) {
        return studentService.updateStudent(studentRequestDto, studentId);
    }

    @PatchMapping(value = "/give_points")
    public void givePointTeacher(@RequestBody PointDto pointRequest) {
        studentService.studentGivePointsTeacher(pointRequest);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
