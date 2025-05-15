package com.example.schoolcrudapp.controller;

import com.example.schoolcrudapp.model.Enrollment;
import com.example.schoolcrudapp.service.EnrollmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/add")
    public String addEnrollment(@RequestParam Long studentId, @RequestParam Long disciplineId) {
        enrollmentService.enrollStudentToDiscipline(studentId, disciplineId);
        return "redirect:/students/" + studentId;
    }
    @GetMapping
    public String list(Model model) {
        List<Enrollment> enrollments = enrollmentService.findAll();
        model.addAttribute("enrollments", enrollments);
        return "enrollments/discipline-with-students";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        enrollmentService.deleteById(id);
        return "redirect:/enrollments";
    }
}
