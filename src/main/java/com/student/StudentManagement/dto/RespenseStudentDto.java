package com.student.StudentManagement.dto;

import com.student.StudentManagement.enumurations.Diplomat;
import com.student.StudentManagement.enumurations.Gender;
import com.student.StudentManagement.model.Carriere;
import com.student.StudentManagement.model.Filiere;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class RespenseStudentDto {
    private long id ;
    private String cin ;
    private long apogee;
    private String nom ;
    private String prenom ;
    private String cne ;
    private String email ;
    private String phone;
    private Date dateNaissance ;
    private String lieuNaissance ;
    private String adresse ;
    private Gender genre ;
    private Filiere filiere;
    private List<Carriere> carriere;
}
