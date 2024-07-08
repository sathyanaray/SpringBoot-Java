package com.sathya.springdatajpaex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.springdatajpaex.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
