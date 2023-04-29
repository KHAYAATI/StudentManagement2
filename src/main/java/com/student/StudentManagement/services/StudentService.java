package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.model.ModulePojo;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.model.StudentPojo;

import java.util.List;

public interface StudentService {

    public void saveStudent(StudentPojo dataPojo);

    RequestStudentDto createStudent(RequestStudentDto student);

    List<Student> getAllStudents();
    Student getStudentByApogee(Long apogee);

    void updateStudent(Student student);

    void deleteStudent(Long apogee);
}
