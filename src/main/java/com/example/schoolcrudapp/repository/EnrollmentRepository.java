package com.example.schoolcrudapp.repository;

import com.example.schoolcrudapp.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {}
