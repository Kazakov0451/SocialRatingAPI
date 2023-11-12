package com.example.socialratingapi.data.repository;

import com.example.socialratingapi.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
