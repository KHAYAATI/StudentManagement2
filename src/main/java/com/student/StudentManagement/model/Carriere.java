package com.student.StudentManagement.model;

import com.student.StudentManagement.enumurations.Diplomat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "carriere")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carriere {
    @Id
    private Long id;
   // @ManyToOne
    //private Student student;
    @Enumerated(EnumType.STRING)
    private Diplomat diplomat;


}
