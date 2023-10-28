package com.umesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.umesh.entity.Student;
@Service
public interface StudentRepository extends JpaRepository<Student,Long> {

	
}
