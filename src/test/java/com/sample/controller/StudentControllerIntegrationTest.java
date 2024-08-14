//package com.sample.controller;
//
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
//
//import com.sample.payload.StudentDto;
//import com.sample.service.StudentService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//
//@WebMvcTest(StudentController.class)
//
//public class StudentControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private StudentService studentService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void testSaveStudent() throws Exception {
//        StudentDto studentDto = new StudentDto(1L, "John", "Doe");
//
//        Mockito.when(studentService.saveStudent(Mockito.any(StudentDto.class))).thenReturn(studentDto);
//
//        mockMvc.perform(post("/api/student/save")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(studentDto)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.firstName", is("John")));
//    }
//
//    @Test
//    void testGetAllStudents() throws Exception {
//        StudentDto student1 = new StudentDto(1L, "John", "Doe");
//        StudentDto student2 = new StudentDto(2L, "Jane", "Smith");
//
//        Mockito.when(studentService.getAllStudent()).thenReturn(Arrays.asList(student1, student2));
//
//        mockMvc.perform(get("/api/student/gellAllStudents"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].firstName", is("John")));
//    }
//
//    @Test
//    void testDeleteStudent() throws Exception {
//        Mockito.doNothing().when(studentService).deleteStudent(1L);
//
//        mockMvc.perform(delete("/api/student/delete/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("student with  deleted  with the id 1"));
//    }
//
//    @Test
//    void testUpdateStudent() throws Exception {
//        StudentDto updatedStudent = new StudentDto(1L, "Johnny", "Doe");
//
//        Mockito.when(studentService.updateStudent(Mockito.eq(1L), Mockito.any(StudentDto.class))).thenReturn(updatedStudent);
//
//        mockMvc.perform(put("/api/student/update/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updatedStudent)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName", is("Johnny")));
//    }
//}
