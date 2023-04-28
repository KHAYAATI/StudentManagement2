package com.student.StudentManagement.model;

import com.student.StudentManagement.enumurations.Diplomat;
import com.student.StudentManagement.enumurations.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(unique=true)

    private String cin ;
    @Column(unique=true)
    private long apogee;
    private String nom ;
    private String prenom ;
    @Column(unique=true)
    private String cne ;
    @Column(unique=true)
    private String email ;
    private String phone;
    private Date dateNaissance ;
    private String lieuNaissance ;
    private String adresse ;
    private Gender genre ;
    @Enumerated(EnumType.STRING)
    private Diplomat diplomat ;
    @OneToOne
    private Filiere filiere;
//    @ManyToMany
//    private List<Carriere> carrieres;
}
