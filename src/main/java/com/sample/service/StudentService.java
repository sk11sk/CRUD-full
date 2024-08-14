package com.sample.service;

import com.sample.payload.StudentDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentService {

   StudentDto saveStudent(StudentDto studentDto);

   List<StudentDto> getAllStudent();

   void deleteStudent(long id);

   StudentDto updateStudent(long id, StudentDto studentDto);

  // StudentDto patchStudent(long id, StudentDto studentDto);
//   StudentDto patchStudent(long id, Map<String, Object> partialUpdate);
}
