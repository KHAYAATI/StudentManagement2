package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestFiliereDto;
import com.student.StudentManagement.dto.RespenseFiliereDto;
import com.student.StudentManagement.model.Filiere;
import com.student.StudentManagement.repository.FilierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FiliereServiceImpl implements FiliereService {
    private final FilierRepository filierRepository;

    @Override
    public RequestFiliereDto createFiliere(RequestFiliereDto requestFiliereDto) {
        RequestFiliereDto dto = RequestFiliereDto.builder().build();
        Filiere filiere1 = new Filiere();
        BeanUtils.copyProperties(requestFiliereDto, filiere1);
        Filiere storedFiliere = filierRepository.save(filiere1);
        BeanUtils.copyProperties(storedFiliere, dto);
        return dto;
    }

    @Override
    public List<RespenseFiliereDto> getAllFilieres() {
        List<Filiere> filieres = filierRepository.findAll();
        List<RespenseFiliereDto> respenseFiliereDtos = new ArrayList<>();
        for (Filiere i : filieres) {
            RespenseFiliereDto response = RespenseFiliereDto.builder().name(i.getName())
                    .modules(i.getModules())
                    .build();
            respenseFiliereDtos.add(response);
        }
        return respenseFiliereDtos;
    }

    @Override
    public RespenseFiliereDto getFiliereById(Long id) {
        RespenseFiliereDto dto = RespenseFiliereDto.builder().build();

        Optional<Filiere> opt = filierRepository.findById(id);
        Filiere filiere ;
        if (opt.isPresent()) {
            filiere = opt.get();
        } else {
            throw new RuntimeException("Filiere not found for id :: " + id);
        }

        BeanUtils.copyProperties(filiere, dto);
        return dto;

//        Optional<Filiere> opt = filierRepository.findById(id);
//        Filiere filiere ;
//        if (opt.isPresent()) {
//            filiere = opt.get();
//        } else {
//            throw new RuntimeException("Filiere not found for id :: " + id);
//        }
    }

    @Override
    public void updateFiliere(Filiere filiere) {

    }


    @Override
    public void deleteFiliere(Long id) {
        filierRepository.deleteById(id);
    }
}
