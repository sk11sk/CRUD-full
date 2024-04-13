package com.sample.controller;

import com.sample.payload.StudentDto;
import com.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // http://localhost:8080/api/student/save
    @PostMapping("/save")
    public ResponseEntity <StudentDto>  SaveStudent (@RequestBody StudentDto studentDto){


        StudentDto  dto = studentService.saveStudent(studentDto);


        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    // http://localhost:8080/api/student/gellAllStudents
    @GetMapping("/gellAllStudents")
    public ResponseEntity<List<StudentDto>> getAllStudent(){

        List<StudentDto> allStudent = studentService.getAllStudent();

        return new ResponseEntity<>(allStudent,HttpStatus.OK);
    }

    //http://localhost:8080/api/student/delete/3

    @DeleteMapping ("/delete/{Id}")
    public ResponseEntity<String > deleteStudent(@PathVariable  long  Id){
        studentService.deleteStudent(Id);
     return new ResponseEntity<>("student with  deleted  with the id "+Id,HttpStatus.OK);
    }

    //http://localhost:8080/api/student/update/8
    @PutMapping("/update/{Id}")
    public  ResponseEntity<StudentDto> updateStudent(@PathVariable long  Id,@RequestBody StudentDto studentDto){

        StudentDto studentdto = studentService.updateStudent(Id, studentDto);

       return new ResponseEntity<>(studentdto,HttpStatus.OK);

    }

   //http://localhost:8080/api/student/patch/8
//    @PatchMapping("/patch/{Id}")
//    public  ResponseEntity<StudentDto> patchStudent(@PathVariable long  Id,  @RequestBody StudentDto studentDto){
//
//        StudentDto studentdto = studentService.patchStudent(Id, studentDto);
//
//        return new ResponseEntity<>(studentdto,HttpStatus.OK);
//
//
//    }

    @PatchMapping("/patch/{Id}")
    public  ResponseEntity<StudentDto> patchStudent(@PathVariable long  Id,  @RequestBody Map<String, Object>  partialUpdate){

        StudentDto studentdto = studentService.patchStudent(Id, partialUpdate);

        return new ResponseEntity<>(studentdto,HttpStatus.OK);


    }


  //  Map<String, Object>

}
