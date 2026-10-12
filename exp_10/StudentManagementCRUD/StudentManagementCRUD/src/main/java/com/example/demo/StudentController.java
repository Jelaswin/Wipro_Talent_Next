package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Show student form
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("editMode", false);
        return "student-form";
    }

    // Save / Update student
    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {

        studentService.saveStudent(student);

        return "redirect:/students";
    }

    // Display all students
    @GetMapping("/students")
    public String getStudents(Model model) {

        List<Student> students = studentService.getAllStudents();

        model.addAttribute("students", students);

        return "student-list";
    }

    // Search student
    @GetMapping("/search")
    public String searchStudent(
            @RequestParam int regno,
            Model model) {

        Optional<Student> student = studentService.getStudentByRegno(regno);

        if (student.isPresent()) {

            model.addAttribute("students",
                    List.of(student.get()));

        } else {

            model.addAttribute("students",
                    List.of());

            model.addAttribute("message",
                    "Student with Registration Number " + regno + " not found.");
        }

        return "student-list";
    }

    // Open edit form
    @GetMapping("/editStudent/{regno}")
    public String editStudent(
            @PathVariable int regno,
            Model model) {

        Optional<Student> student =
                studentService.getStudentByRegno(regno);

        if (student.isPresent()) {

            model.addAttribute("student", student.get());
            model.addAttribute("editMode", true);

            return "student-form";
        }

        return "redirect:/students";
    }

    // Delete student
    @GetMapping("/deleteStudent/{regno}")
    public String deleteStudent(
            @PathVariable int regno) {

        studentService.deleteStudent(regno);

        return "redirect:/students";
    }
}