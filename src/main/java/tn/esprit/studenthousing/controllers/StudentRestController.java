package tn.esprit.studenthousing.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studenthousing.entities.Student;
import tn.esprit.studenthousing.services.IStudentService;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentRestController {
    private final IStudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping
    public Page<Student> getAllStudents(@RequestParam int pageNbr, @RequestParam int pageSize){
        return studentService.getAllStudents(pageNbr,pageSize);
    }

    @GetMapping("{inc}")
    public Student getByInc(@PathVariable int inc){
        return studentService.findByINC(inc);
    }
    
}
