package com.student.StudentManagement.controller;

import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.dto.RespenseStudentDto;
import com.student.StudentManagement.model.Filiere;
import com.student.StudentManagement.model.ModuleF;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.model.StudentPojo;
import com.student.StudentManagement.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

//    @PostMapping
//    public RespenseStudentDto createStudent(@RequestBody Student student){
//        RespenseStudentDto adResp = RespenseStudentDto.builder().build();
//        RequestStudentDto dto = RequestStudentDto.builder().build();
//        BeanUtils.copyProperties(student, dto);
//        RequestStudentDto dto1 = studentService.createStudent(dto);
//        BeanUtils.copyProperties(dto1, adResp);
//        System.out.println("hhhhhhhhhhhhhhhhhhh");
//
//        return adResp;
//    }

    @PostMapping
    public void SaveStudent(@RequestBody StudentPojo data){
        studentService.saveStudent(data);
    }
    @GetMapping("/viewStudents")
    public List<Student> viewStudents() {
        return studentService.getAllStudents();

    }


    @GetMapping("/viewStudent/{apogee}")
    public Student viewStudent(@PathVariable(value = "apogee") Long apogee) {
        return studentService.getStudentByApogee(apogee);

    }


    @GetMapping("/deleteStudent/{apogee}")
    public void deleteStudent(@PathVariable(value = "apogee") Long apogee) {
        studentService.deleteStudent(apogee);
    }

}
