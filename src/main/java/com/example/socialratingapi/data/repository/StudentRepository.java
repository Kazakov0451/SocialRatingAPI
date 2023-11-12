package com.example.socialratingapi.data.repository;

import com.example.socialratingapi.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
