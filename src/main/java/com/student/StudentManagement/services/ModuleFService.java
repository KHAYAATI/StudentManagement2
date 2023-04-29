package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestModuleFDto;
import com.student.StudentManagement.model.ModuleF;
import com.student.StudentManagement.model.ModulePojo;

import java.util.List;

public interface ModuleFService {
    RequestModuleFDto createModuleF(RequestModuleFDto requestModuleFDto);

    public void saveModule(ModulePojo dataPojo);

    List<ModuleF> getAllModuleFs();

    ModuleF getModuleFById(Long id );

    void updateModuleF(ModuleF moduleF);

    void deleteModuleF(Long id);
}
