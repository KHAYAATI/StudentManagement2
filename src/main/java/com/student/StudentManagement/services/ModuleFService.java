package com.student.StudentManagement.services;

import com.student.StudentManagement.model.ModuleF;

import java.util.List;

public interface ModuleFService {
    void createModuleF(ModuleF moduleF);

    List<ModuleF> getAllModuleFs();

    ModuleF getModuleFById(int id );

    void updateModuleF(ModuleF moduleF);

    void deleteModuleF(int id);
}
