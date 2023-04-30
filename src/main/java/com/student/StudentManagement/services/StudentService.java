package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.dto.RespenseStudentDto;
import com.student.StudentManagement.model.Carriere;
import com.student.StudentManagement.model.ModulePojo;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.model.StudentPojo;

import java.util.List;

public interface StudentService {
    public void saveStudent(StudentPojo dataPojo);
    List<RespenseStudentDto> getAllStudents();
    RequestStudentDto getStudentByApogee(Long apogee);
    void updateStudent(Student student);
    void deleteStudent(Long apogee);
    List<Carriere> getCarrieresByStudentId(Long StudentId);

}
