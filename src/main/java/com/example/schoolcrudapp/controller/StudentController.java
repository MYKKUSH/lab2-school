package com.example.schoolcrudapp.controller;

import com.example.schoolcrudapp.model.Student;
import com.example.schoolcrudapp.repository.DisciplineRepository;
import com.example.schoolcrudapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("disciplines", disciplineRepository.findAll());
        return "students/form";
    }

    @GetMapping("/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id).orElseThrow();
        model.addAttribute("student", student);
        model.addAttribute("disciplines", disciplineRepository.findAll());
        return "students/form";
    }

    @PostMapping
    public String save(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "error";
    }
}
