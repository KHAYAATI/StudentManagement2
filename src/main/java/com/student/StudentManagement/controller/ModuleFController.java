package com.student.StudentManagement.controller;

import com.student.StudentManagement.dto.RequestModuleFDto;
import com.student.StudentManagement.dto.RespenseModuleFDto;
import com.student.StudentManagement.model.ModuleF;
import com.student.StudentManagement.model.ModulePojo;
import com.student.StudentManagement.services.ModuleFService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/moduleFs")
@RequiredArgsConstructor
public class ModuleFController {
    private final ModuleFService moduleFService;

//    @PostMapping
//    public RespenseModuleFDto createModuleF(@RequestBody ModuleF requestModuleFDto) {
//        RespenseModuleFDto adResp = RespenseModuleFDto.builder().build();
//        RequestModuleFDto dto = RequestModuleFDto.builder().build();
//        BeanUtils.copyProperties(requestModuleFDto, dto);
//        RequestModuleFDto dto1 = moduleFService.createModuleF(dto);
//        BeanUtils.copyProperties(dto1, adResp);
//        System.out.println("daz bkhair");
//
//        return adResp;
//    }


    @PostMapping
    public void saveModule(HttpServletRequest request,
                           Model model, @RequestBody ModulePojo dataPojo) {
        moduleFService.saveModule(dataPojo);
    }


}
