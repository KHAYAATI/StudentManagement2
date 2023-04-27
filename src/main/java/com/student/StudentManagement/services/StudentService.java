package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.model.Student;

import java.util.List;

public interface StudentService {
    RequestStudentDto createStudent(RequestStudentDto student);

    List<Student> getAllStudents();
    Student getStudentByApogee(String apogee);

    void updateStudent(Student student);

    void deleteStudent(String cin);
}
