package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestFiliereDto;
import com.student.StudentManagement.model.Filiere;

import java.util.List;

public interface FiliereService {
    RequestFiliereDto createFiliere(RequestFiliereDto requestFiliereDto);

    List<Filiere> getAllFilieres();

    Filiere getFiliereById(int id);

    void updateFiliere(Filiere filier);

    void deleteFiliere(int id);
}

