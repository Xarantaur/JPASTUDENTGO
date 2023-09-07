package com.example.jpastudentgo.config;

import com.example.jpastudentgo.model.Student;
import com.example.jpastudentgo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class initData implements CommandLineRunner
{
    @Autowired
    StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception
    {
        Student s1 = new Student();
        s1.setName("Tim");
        s1.setBornDate(LocalDate.of(2010,11,12));
        s1.setBornTime(LocalTime.of(10,11,12));
        studentRepository.save(s1);

        Student s2 = new Student();
        s2.setName("Luna");
        s2.setBornDate(LocalDate.of(2023,03,19));
        s2.setBornTime(LocalTime.of(9,10,11));

        studentRepository.save(s2);

    }
}
