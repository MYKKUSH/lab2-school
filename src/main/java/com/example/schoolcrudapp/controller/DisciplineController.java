package com.example.schoolcrudapp.controller;

import com.example.schoolcrudapp.service.DisciplineService;
import com.example.schoolcrudapp.model.Discipline;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("disciplines", disciplineService.findAll());
        return "disciplines/discipline-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("discipline", new Discipline());
        return "disciplines/discipline-form";
    }

    @PostMapping
    public String save(@ModelAttribute Discipline discipline) {
        disciplineService.save(discipline);
        return "redirect:/disciplines";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("discipline", disciplineService.findById(id));
        return "disciplines/discipline-form";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        disciplineService.deleteById(id);
        return "redirect:/disciplines";
    }
}