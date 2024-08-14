package com.sample.service;



import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.sample.entity.Student;
import com.sample.payload.StudentDto;
import com.sample.repository.StudentRepository;
import com.sample.service.Impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveStudent() {
        Student student = new Student(1L, "John", "Doe");
        StudentDto studentDto = new StudentDto(1L, "John", "Doe");

        when(studentRepository.save(any(Student.class))).thenReturn(student);

        StudentDto savedStudent = studentService.saveStudent(studentDto);

        assertNotNull(savedStudent);
        assertEquals("John", savedStudent.getFirstName());
    }

    @Test
    void testGetAllStudents() {
        List<Student> students = Arrays.asList(new Student(1L, "John", "Doe"), new Student(2L, "Jane", "Smith"));
        when(studentRepository.findAll()).thenReturn(students);

        List<StudentDto> allStudents = studentService.getAllStudent();

        assertEquals(2, allStudents.size());
    }

    @Test
    void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(1L);
        studentService.deleteStudent(1L);
        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateStudent() {
        Student student = new Student(1L, "John", "Doe");
        StudentDto studentDto = new StudentDto(1L, "Johnny", "Doe");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        StudentDto updatedStudent = studentService.updateStudent(1L, studentDto);

        assertEquals("Johnny", updatedStudent.getFirstName());
    }
}
