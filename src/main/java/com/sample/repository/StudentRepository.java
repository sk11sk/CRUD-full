package com.sample.repository;

import com.sample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository< Student, Long>{


}
