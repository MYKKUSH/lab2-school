package com.example.schoolcrudapp.service;
import com.example.schoolcrudapp.model.Discipline;
import com.example.schoolcrudapp.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DisciplineService {
    private final DisciplineRepository repository;

    public DisciplineService(DisciplineRepository repository) {
        this.repository = repository;
    }

    public List<Discipline> findAll() {
        return repository.findAll();
    }

    public Discipline findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Discipline save(Discipline discipline) {
        return repository.save(discipline);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
