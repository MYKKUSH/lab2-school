package com.example.schoolcrudapp.repository;

import com.example.schoolcrudapp.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {}