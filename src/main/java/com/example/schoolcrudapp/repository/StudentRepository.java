package com.example.schoolcrudapp.repository;

import com.example.schoolcrudapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
