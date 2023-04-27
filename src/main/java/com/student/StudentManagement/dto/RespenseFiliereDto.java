package com.student.StudentManagement.dto;

import com.student.StudentManagement.model.ModuleF;
import com.student.StudentManagement.model.Student;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class RespenseFiliereDto {
    private long  id ;
    private String name ;
    private List<Student> students ;
    private List<ModuleF> modules;
}
