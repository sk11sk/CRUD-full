package com.sample.service.Impl;

import com.sample.entity.Student;
import com.sample.payload.StudentDto;
import com.sample.repository.StudentRepository;
import com.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public StudentDto saveStudent(StudentDto studentDto) {

        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        Student savedStudent = studentRepository.save(student);

        StudentDto dto  = new StudentDto();
        dto.setSid(savedStudent.getSid());
        dto.setFirstName(savedStudent.getFirstName());
        dto.setLastName(savedStudent.getLastName());

        return dto;

    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> dtos = studentRepository.findAll();
        List<StudentDto> students = dtos.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        return students;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    StudentDto mapToDto(Student student ){

        StudentDto dto  =  new StudentDto();
        dto.setSid(student.getSid());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        return dto;

    }

    @Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).get();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        Student savedstudent = studentRepository.save(student);


        StudentDto dto  = new StudentDto();
        dto.setSid(savedstudent.getSid());
        dto.setFirstName(savedstudent.getFirstName());
        dto.setLastName(savedstudent.getLastName());
        return dto;

     }




    @Override
    public StudentDto patchStudent(long id, Map<String, Object> partialUpdate) {
        Student student = studentRepository.findById(id).get();

// another way
//        for (Map.Entry<String, Object> entry : partialUpdate.entrySet()) {
//            String key = entry.getKey();
//            if (key.equals("firstName")){
//               String  FirstName = entry.getValue().toString();
//
//                student.setFirstName(FirstName);
//            }
//            if (key.equals("lastName")){
//                String  lastName = entry.getValue().toString();
//
//                student.setLastName(lastName);
//            }
//
//
//        }




        for (String key : partialUpdate.keySet()) {

            if (key.equals("firstName")){
              String  firstName = partialUpdate.get(key).toString();
                student.setFirstName(firstName);

            }

            if (key.equals("lastName")){
                String  lastName = partialUpdate.get(key).toString();
                student.setLastName(lastName);

            }


        }



        Student savedstudent = studentRepository.save(student);


        StudentDto dto  = new StudentDto();
        dto.setSid(savedstudent.getSid());
        dto.setFirstName(savedstudent.getFirstName());
        dto.setLastName(savedstudent.getLastName());
        return dto;
    }
}
