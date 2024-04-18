package com.toleyko.springboot.lab3.service;

import com.toleyko.springboot.lab3.dao.StudentRepository;
import com.toleyko.springboot.lab3.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student = null;
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            student = optional.get();
        }
        return student;
    }

    @Override
        public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
