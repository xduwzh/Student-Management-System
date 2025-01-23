package com.example.demo.service;


import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> findAllStudents() {
        return repo.findAll();
    }

    public void saveStudent(Student student) {
        repo.save(student);
    }

    public Student findStudentById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteStudentById(Integer id) {
        repo.deleteById(id);
    }
}
