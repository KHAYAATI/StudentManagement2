package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestModuleFDto;
import com.student.StudentManagement.model.Filiere;
import com.student.StudentManagement.model.ModuleF;
import com.student.StudentManagement.model.ModulePojo;
import com.student.StudentManagement.repository.FilierRepository;
import com.student.StudentManagement.repository.ModuleFRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModuleFServiceImpl implements ModuleFService {

    private final ModuleFRepository moduleFRepository;
    private final FilierRepository filierRepository;

    @Override
    public RequestModuleFDto createModuleF(RequestModuleFDto requestModuleFDto) {

        RequestModuleFDto dto = RequestModuleFDto.builder().build();
        ModuleF moduleF1 = new ModuleF();
        BeanUtils.copyProperties(requestModuleFDto, moduleF1);
        Filiere filiere = new Filiere();

        ModuleF storedModuleF = moduleFRepository.save(moduleF1);
        BeanUtils.copyProperties(storedModuleF, dto);
        return dto;
    }

    @Override
    public void saveModule(ModulePojo dataPojo) {
        Filiere filiere = filierRepository.findById(dataPojo.getIdFiliere())
                .orElseThrow(() -> new RuntimeException("Filiere Not Found"));

        ModuleF moduleF = new ModuleF();

        BeanUtils.copyProperties(dataPojo, moduleF);

        moduleF.setFiliere(filiere);

        filierRepository.save(filiere);

        moduleFRepository.save(moduleF);
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
