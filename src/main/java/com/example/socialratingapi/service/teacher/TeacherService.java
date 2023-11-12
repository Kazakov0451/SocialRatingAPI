package com.example.socialratingapi.service.teacher;

import com.example.socialratingapi.model.dto.point.PointDto;
import com.example.socialratingapi.model.dto.teacher.TeacherRequestDto;
import com.example.socialratingapi.model.dto.teacher.TeacherResponseDto;

import java.util.List;

public interface TeacherService {
    List<TeacherResponseDto> getAllTeacher();
    TeacherResponseDto getByIdTeacher(Long id);
    TeacherResponseDto createTeacher(TeacherRequestDto teacherDto);
    void teacherGivePointsStudent(PointDto pointDto);
    TeacherResponseDto updateTeacher(TeacherRequestDto teacherDto, Long teacherId);
    void deleteTeacher(Long id);
}
