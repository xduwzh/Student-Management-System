package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student_form";
    }

    @PostMapping("/student/save")
    public String saveStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable("id")Integer id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "student_form";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id")Integer id, Model model) {
        studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
