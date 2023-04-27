package com.student.StudentManagement.services;

import com.student.StudentManagement.model.Filiere;

import java.util.List;

public interface FiliereService {
    void createFiliere(Filiere filiere);

    List<Filiere> getAllFilieres();

    Filiere getFiliereById(int id);

    void updateFiliere(Filiere filier);

    void deleteFiliere(int id);
}

