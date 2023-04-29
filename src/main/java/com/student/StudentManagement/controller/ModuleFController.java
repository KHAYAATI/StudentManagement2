package com.student.StudentManagement.controller;

import com.student.StudentManagement.model.Filiere;
import com.student.StudentManagement.model.ModuleF;
import com.student.StudentManagement.model.ModulePojo;
import com.student.StudentManagement.services.ModuleFService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/viewModules")
    public List<ModuleF> viewModules() {
        return moduleFService.getAllModuleFs();

    }

    @GetMapping("/viewModule/{id}")
    public ModuleF viewModule(@PathVariable(value = "id") Long id) {
        return moduleFService.getModuleFById(id);

    }


    @GetMapping("/deleteModule/{id}")
    public void deleteModule(@PathVariable(value = "id") Long id) {
        moduleFService.deleteModuleF(id);
    }


}
