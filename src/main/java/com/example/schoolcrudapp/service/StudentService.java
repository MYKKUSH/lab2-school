package com.example.schoolcrudapp.service;

import com.example.schoolcrudapp.model.Student;
import com.example.schoolcrudapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() { return studentRepository.findAll(); }
    public Optional<Student> findById(Long id) { return studentRepository.findById(id); }
    public Student save(Student student) { return studentRepository.save(student); }
    public void deleteById(Long id) { studentRepository.deleteById(id); }
}
