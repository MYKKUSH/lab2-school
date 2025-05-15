package com.example.schoolcrudapp.service;
import com.example.schoolcrudapp.model.Student;
import com.example.schoolcrudapp.model.Discipline;
import com.example.schoolcrudapp.model.Enrollment;
import com.example.schoolcrudapp.repository.EnrollmentRepository;
import com.example.schoolcrudapp.repository.DisciplineRepository;
import com.example.schoolcrudapp.repository.StudentRepository;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final DisciplineRepository disciplineRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             StudentRepository studentRepository,
                             DisciplineRepository disciplineRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public void enrollStudentToDiscipline(Long studentId, Long disciplineId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Discipline discipline = disciplineRepository.findById(disciplineId).orElseThrow();

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setDiscipline(discipline);

        enrollmentRepository.save(enrollment);
    }
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }
    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
