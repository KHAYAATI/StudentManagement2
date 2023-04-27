package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository ;
    @Override
    public RequestStudentDto createStudent(RequestStudentDto student) {
        RequestStudentDto dto = RequestStudentDto.builder().build();
        Student student1= new Student();
        BeanUtils.copyProperties(student, student1);
        Student storedStudent  = studentRepository.save(student1);
        BeanUtils.copyProperties(storedStudent, dto);
        return dto;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudentByApogee(String apogee) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(String cin) {

    }
}
