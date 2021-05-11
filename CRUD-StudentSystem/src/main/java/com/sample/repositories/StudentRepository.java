package com.sample.repositories;

import org.springframework.stereotype.Repository;

import com.sample.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
