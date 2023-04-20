package com.student.StudentManagement.model;

import com.student.StudentManagement.enumurations.Diplomat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "carrier")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carriere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @Enumerated(EnumType.STRING)
    private Diplomat diplomat;


}
