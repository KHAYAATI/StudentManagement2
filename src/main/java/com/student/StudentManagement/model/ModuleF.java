package com.student.StudentManagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "module")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuleF {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String name ;
    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;
    //ok confirmed

}
