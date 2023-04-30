package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.dto.RespenseStudentDto;
import com.student.StudentManagement.model.*;
import com.student.StudentManagement.repository.CarriereRepository;
import com.student.StudentManagement.repository.FilierRepository;
import com.student.StudentManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.annotations.ListBinder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final FilierRepository filierRepository;
    private final CarriereService carriereService;


    @Override
    public void saveStudent(StudentPojo dataPojo) {
        Filiere filiere = filierRepository.findById(dataPojo.getIdFiliere())
                .orElseThrow(() -> new RuntimeException(" This Filiere is not exist in database"));

        Student student = new Student();

        BeanUtils.copyProperties(dataPojo, student);

        student.setFilier(filiere);

        filierRepository.save(filiere);

        studentRepository.save(student);
        System.out.println("created with success !");

    }

    @Override
    public List<RespenseStudentDto> getAllStudents() {
      List<Student> students =studentRepository.findAll();
      List<RespenseStudentDto> respenseStudentDtoList=new ArrayList<>();

        for (Student i: students) {
            RespenseStudentDto respense=RespenseStudentDto.builder().cin(i.getCin())
                    .nom(i.getNom())
                    .prenom(i.getPrenom())
                    .cne(i.getCne())
                    .apogee(i.getApogee())
                    .email(i.getEmail())
                    .genre(i.getGenre())
                    .carriere(i.getCarrieres())
                    .filiere(i.getFilier())
                    .build();
            respenseStudentDtoList.add(respense);


        }
        System.out.println("Retuner la list des réponse ..............");
        return respenseStudentDtoList ;
    }

    @Override
    public RequestStudentDto getStudentByApogee(Long apogee) {
        RequestStudentDto dto = RequestStudentDto.builder().build();
        Student std = studentRepository.getStudentByApogee(apogee);
        Student std1 = studentRepository.findById(std.getId()).get();

        BeanUtils.copyProperties(std1, dto);
        return dto;

        // Optional<Student> opt = Optional.ofNullable(studentRepository.getStudentByApogee(apogee));
//        Student student;
//        if (opt.isPresent()) {
//            student = opt.get();
//        } else {
//            throw new RuntimeException("Student not found for apogee :: " + apogee);
//        }
//
//        return student;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(Long apogee) {

        Long id = studentRepository.getStudentByApogee(apogee).getId();
        studentRepository.deleteById(id);
    }

    @Override
    public List<Carriere> getCarrieresByStudentId(Long StudentId) {
        Student student = studentRepository.findById(StudentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        return student.getCarrieres();
    }
}
