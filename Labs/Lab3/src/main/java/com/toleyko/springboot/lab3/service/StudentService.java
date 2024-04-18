package com.toleyko.springboot.lab3.service;

import com.toleyko.springboot.lab3.entity.Student;
import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student getStudentById(Integer id);
    public void deleteStudentById(Integer id);
    public void saveStudent(Student student);
}
