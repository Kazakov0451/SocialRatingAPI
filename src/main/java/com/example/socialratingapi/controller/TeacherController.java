package com.example.socialratingapi.controller;

import com.example.socialratingapi.model.dto.point.PointDto;
import com.example.socialratingapi.model.dto.teacher.TeacherRequestDto;
import com.example.socialratingapi.model.dto.teacher.TeacherResponseDto;
import com.example.socialratingapi.service.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping()
    public List<TeacherResponseDto> findAllTeachers() {
        return teacherService.getAllTeacher();
    }

    @GetMapping(value = "/{teacherId}")
    public TeacherResponseDto findByIdTeacher(@PathVariable Long teacherId) {
        return teacherService.getByIdTeacher(teacherId);
    }

    @PostMapping(value = "/create")
    public TeacherResponseDto createTeacher(@RequestBody TeacherRequestDto teacherRequest) {
        return teacherService.createTeacher(teacherRequest);
    }

    @PatchMapping(value = "/update/{teacherId}")
    public TeacherResponseDto updateTeacher(@RequestBody TeacherRequestDto teacherRequestDto,
                                            @PathVariable Long teacherId) {
        return teacherService.updateTeacher(teacherRequestDto, teacherId);
    }

    @PatchMapping(value = "/give_points")
    public void givePointStudent(@RequestBody PointDto pointRequest) {
        teacherService.teacherGivePointsStudent(pointRequest);
    }

    @DeleteMapping(value = "/delete/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
}
