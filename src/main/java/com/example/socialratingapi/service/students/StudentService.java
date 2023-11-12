package com.example.socialratingapi.service.students;

import com.example.socialratingapi.model.dto.point.PointDto;
import com.example.socialratingapi.model.dto.student.StudentRequestDto;
import com.example.socialratingapi.model.dto.student.StudentResponseDto;

import java.util.List;

public interface StudentService {
    List<StudentResponseDto> getAllStudent();
    StudentResponseDto getByIdStudent(Long id);
    StudentResponseDto createStudent(StudentRequestDto userDto);
    void studentGivePointsTeacher(PointDto pointDto);
    StudentResponseDto updateStudent(StudentRequestDto userDto, Long studentId);
    void deleteStudent(Long id);

}
