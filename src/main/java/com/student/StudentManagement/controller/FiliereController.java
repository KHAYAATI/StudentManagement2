package com.student.StudentManagement.controller;

import com.student.StudentManagement.dto.RequestFiliereDto;
import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.dto.RespenseFiliereDto;
import com.student.StudentManagement.dto.RespenseStudentDto;
import com.student.StudentManagement.model.Filiere;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.services.FiliereService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/filieres")
@RequiredArgsConstructor
public class FiliereController {
    private final FiliereService filiereService;
    @PostMapping
    public RespenseFiliereDto createFiliere(@RequestBody Filiere filiere){
        RespenseFiliereDto adResp = RespenseFiliereDto.builder().build();
        RequestFiliereDto dto = RequestFiliereDto.builder().build();
        BeanUtils.copyProperties(filiere, dto);
        RequestFiliereDto dto1 = filiereService.createFiliere(dto);
        BeanUtils.copyProperties(dto1, adResp);
        System.out.println(" sir 3ellah");

        return adResp;
    }
}
