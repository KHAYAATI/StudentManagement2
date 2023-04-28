package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestFiliereDto;
import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.model.Filiere;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.repository.FilierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FiliereServiceImpl implements FiliereService{
    private final FilierRepository filierRepository;
    @Override
    public RequestFiliereDto createFiliere(RequestFiliereDto requestFiliereDto) {
        RequestFiliereDto dto = RequestFiliereDto.builder().build();
        Filiere filiere1= new Filiere();
        BeanUtils.copyProperties(requestFiliereDto, filiere1);
        Filiere storedFiliere  = filierRepository.save(filiere1);
        BeanUtils.copyProperties(storedFiliere, dto);
        return dto;
    }

    @Override
    public List<Filiere> getAllFilieres() {
        return null;
    }

    @Override
    public Filiere getFiliereById(int id) {
        return null;
    }

    @Override
    public void updateFiliere(Filiere filier) {

    }

    @Override
    public void deleteFiliere(int id) {

    }
}
