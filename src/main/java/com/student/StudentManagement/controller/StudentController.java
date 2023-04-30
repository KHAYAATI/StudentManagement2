package com.student.StudentManagement.controller;

import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.dto.RespenseStudentDto;
import com.student.StudentManagement.model.*;
import com.student.StudentManagement.services.CarriereService;
import com.student.StudentManagement.services.StudentService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final CarriereService carriereService;

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
    public RequestStudentDto viewStudent(@PathVariable(value = "apogee") Long apogee) {
        return studentService.getStudentByApogee(apogee);

    }
    //hello world ...


    @GetMapping("/deleteStudent/{apogee}")
    public void deleteStudent(@PathVariable(value = "apogee") Long apogee) {
        studentService.deleteStudent(apogee);
    }

    @GetMapping("/carrieres/{id}")
    public List<Carriere> getCarrieresByStudent(@PathVariable(name="id") Long id){
        return studentService.getCarrieresByStudentId(id);
    }
}
