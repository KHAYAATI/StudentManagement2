package com.student.StudentManagement.controller;

import com.student.StudentManagement.model.ModulePojo;
import com.student.StudentManagement.services.ModuleFService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void saveModule(@RequestBody ModulePojo dataPojo) {
        moduleFService.saveModule(dataPojo);
    }


}
