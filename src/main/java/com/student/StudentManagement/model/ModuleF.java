package com.student.StudentManagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "module")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuleF {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String name ;

}
