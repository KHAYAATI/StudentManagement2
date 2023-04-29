package com.student.StudentManagement.services;

import com.student.StudentManagement.model.Carriere;
import com.student.StudentManagement.model.CarrierePojo;
import com.student.StudentManagement.model.Filiere;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.repository.CarriereRepository;
import com.student.StudentManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarriereServiceImpl implements CarriereService {
    private final CarriereRepository carriereRepository;
    private final StudentRepository studentRepository;

    @Override
    public void saveCarriere(CarrierePojo carrierePojo) {
        Student student = studentRepository.findById(carrierePojo.getStudentId())
                .orElseThrow(() -> new RuntimeException(" This Student is not exist in database"));

        Carriere carriere = new Carriere();

        BeanUtils.copyProperties(carrierePojo, carriere);

        carriere.setStudent(student);
        studentRepository.save(student);
        carriereRepository.save(carriere);

        System.out.println("created with success !");

    }


    @Override
    public void updateCarriere(Carriere carriere) {

    }
}
