package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestFiliereDto;
import com.student.StudentManagement.model.Filiere;

import java.util.List;
import java.util.Optional;

public interface FiliereService {
    RequestFiliereDto createFiliere(RequestFiliereDto requestFiliereDto);

    List<Filiere> getAllFilieres();

    Filiere getFiliereById(Long id);


    void updateFiliere(Filiere filier);

    void deleteFiliere(Long id);
}

