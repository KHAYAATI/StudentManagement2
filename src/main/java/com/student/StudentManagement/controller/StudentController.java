package com.student.StudentManagement.controller;

import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.dto.RespenseStudentDto;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public RespenseStudentDto createStudent(@RequestBody Student student){
        RespenseStudentDto adResp = RespenseStudentDto.builder().build();
        RequestStudentDto dto = RequestStudentDto.builder().build();
        BeanUtils.copyProperties(student, dto);
        RequestStudentDto dto1 = studentService.createStudent(dto);
        BeanUtils.copyProperties(dto1, adResp);
        System.out.println("hhhhhhhhhhhhhhhhhhh");

        return adResp;
    }
}
