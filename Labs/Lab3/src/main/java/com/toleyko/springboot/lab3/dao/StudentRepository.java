package com.toleyko.springboot.lab3.dao;

import com.toleyko.springboot.lab3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
