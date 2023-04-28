package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestModuleFDto;
import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.model.ModuleF;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.repository.ModuleFRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModuleFServiceImpl implements ModuleFService{

    private final ModuleFRepository moduleFRepository;
    @Override
    public RequestModuleFDto createModuleF( RequestModuleFDto requestModuleFDto) {

        RequestModuleFDto  dto = RequestModuleFDto .builder().build();
        ModuleF moduleF1= new ModuleF();
        BeanUtils.copyProperties(requestModuleFDto, moduleF1);
        ModuleF storedModuleF  = moduleFRepository.save(moduleF1);
        BeanUtils.copyProperties(storedModuleF, dto);
        return dto;
    }

    @Override
    public List<ModuleF> getAllModuleFs() {
        return null;
    }

    @Override
    public ModuleF getModuleFById(int id) {
        return null;
    }

    @Override
    public void updateModuleF(ModuleF moduleF) {

    }

    @Override
    public void deleteModuleF(int id) {

    }
}
