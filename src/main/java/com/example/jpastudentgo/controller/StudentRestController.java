package com.example.jpastudentgo.controller;


import java.util.List;
import java.util.Optional;

import com.example.jpastudentgo.model.Student;
import com.example.jpastudentgo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentRestController
{
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students(){
        var obj = studentRepository.findAll();
        return obj;
    }
    @GetMapping("/student/{id}")
    public Optional<Student> students(int id){
        var obj = studentRepository.findById(id);
        return obj;
    }
    @GetMapping("/student/{name}")
    public Optional<Student> students(String name){
        var obj = studentRepository.findByName(name);
        return obj;
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student  student) {
        System.out.println(student);
        return  studentRepository.save(student);
    }

   /* @PutMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student putStudent(@RequestBody Student student){
        System.out.println(student);
        return studentRepository.save(student);
    }*/
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student){
        Optional<Student> orgStudent = studentRepository.findById(id);
        if(orgStudent.isPresent())
        {
            studentRepository.save(student);
            return ResponseEntity.ok(student);

        } else{
          /*  Student notstudent = new Student();
            notstudent.setName("NotFound");
            return notstudent; */
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id)    {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if(orgStudent.isPresent())
        {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("student deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
        }
    }
}
