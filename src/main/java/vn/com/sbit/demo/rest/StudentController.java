package vn.com.sbit.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.sbit.demo.entity.Student;
import vn.com.sbit.demo.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/list") //show list
    public String listStudent(Model model){
       List<Student>  students=studentService.getAllStudents();
        model.addAttribute("students",students);
        return "student/students";
    }
    @GetMapping("/create") // button add new
    public String create(Model model){
        Student student= new Student();
        model.addAttribute("student",student);
        return "student/students-form";
    }

    @PostMapping("/save") // save in students-form and redirect to list
    public String save(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/update")
    public String updateStudent(@RequestParam("id") int id,Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "student/students-form";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id,Model model){
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }


}
