package com.student.StudentManagement.dto;

import com.student.StudentManagement.model.Filiere;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class RespenseModuleFDto {
    private String name ;

}
