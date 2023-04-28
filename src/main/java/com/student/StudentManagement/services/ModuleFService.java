package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestModuleFDto;
import com.student.StudentManagement.model.ModuleF;

import java.util.List;

public interface ModuleFService {
    RequestModuleFDto createModuleF(RequestModuleFDto requestModuleFDto);

    List<ModuleF> getAllModuleFs();

    ModuleF getModuleFById(int id );

    void updateModuleF(ModuleF moduleF);

    void deleteModuleF(int id);
}
