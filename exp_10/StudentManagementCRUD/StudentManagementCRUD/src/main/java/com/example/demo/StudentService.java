package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Add or Update
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    // Display all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Search by registration number
    public Optional<Student> getStudentByRegno(int regno) {
        return studentRepository.findById(regno);
    }

    // Delete
    public void deleteStudent(int regno) {
        studentRepository.deleteById(regno);
    }
}