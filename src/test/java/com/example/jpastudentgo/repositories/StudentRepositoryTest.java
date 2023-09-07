package com.example.jpastudentgo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest
{
     @Autowired
     StudentRepository studentRepository;
    @Test
    void findByName()
    {
    }
}