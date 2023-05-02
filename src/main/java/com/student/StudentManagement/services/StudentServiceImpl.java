package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestModuleFDto;
import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.dto.RespenseStudentDto;
import com.student.StudentManagement.enumurations.Diplomat;
import com.student.StudentManagement.model.*;
import com.student.StudentManagement.repository.CarriereRepository;
import com.student.StudentManagement.repository.FilierRepository;
import com.student.StudentManagement.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    private final CarriereRepository carriereRepository;

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
        List<Student> students = studentRepository.findAll();
        List<RespenseStudentDto> respenseStudentDtoList = new ArrayList<>();

        for (Student i : students) {
            RespenseStudentDto respense = RespenseStudentDto.builder().cin(i.getCin())
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
        return respenseStudentDtoList;
    }

//    @Override
//    public RequestStudentDto getStudentByApogee(Long apogee) {
//        RequestStudentDto dto = RequestStudentDto.builder().build();
//
//        Student std = studentRepository.getStudentByApogee(apogee);
//        Optional<Student> opt = studentRepository.findById(std.getId());
//        Student student;
//        if (opt.isPresent()) {
//            student = opt.get();
//        } else {
//            throw new RuntimeException("Student not found for apogee :: " + apogee);
//        }
//        BeanUtils.copyProperties(student, dto);
//        return dto;
//    }
    @Override
    public RequestStudentDto getStudentByApogee(Long apogee) {
        RequestStudentDto dto;
        if (apogee != null) {
            Student std = studentRepository.getStudentByApogee(apogee);
            dto = RequestStudentDto.builder()
                .cin(std.getCin())
                .apogee(std.getApogee())
                .nom(std.getNom())
                .prenom(std.getPrenom())
                .cne(std.getCne())
                .email(std.getEmail())
                .phone(std.getPhone())
                .dateNaissance(std.getDateNaissance())
                .lieuNaissance(std.getLieuNaissance())
                .adresse(std.getAdresse())
                .genre(std.getGenre())
                .filier(std.getFilier())
                .carrieres(std.getCarrieres())
                .build();

        } else {
            throw new NullPointerException("waqtaaaa rayeee7");
        }


        return dto;
    }

    @Override
    public RequestStudentDto updateStudent(Long id ,RequestStudentDto requestStudentDto) {
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("student not found !"));
        RequestStudentDto dto = RequestStudentDto.builder().build();
        BeanUtils.copyProperties(student,dto);
        if(requestStudentDto.getCin()!=null) dto.setCin(requestStudentDto.getCin());
        if(requestStudentDto.getApogee()!=null) dto.setApogee(requestStudentDto.getApogee());
        if(requestStudentDto.getNom()!=null) dto.setNom(requestStudentDto.getNom());
        if(requestStudentDto.getPrenom()!=null) dto.setPrenom(requestStudentDto.getPrenom());
        if(requestStudentDto.getCne()!=null) dto.setCne(requestStudentDto.getCne());
        if(requestStudentDto.getEmail()!=null) dto.setEmail(requestStudentDto.getEmail());
        if(requestStudentDto.getPhone()!=null) dto.setPhone(requestStudentDto.getPhone());
        if(requestStudentDto.getDateNaissance()!=null) dto.setDateNaissance(requestStudentDto.getDateNaissance());
        if(requestStudentDto.getLieuNaissance()!=null) dto.setLieuNaissance(requestStudentDto.getLieuNaissance());
        if(requestStudentDto.getAdresse()!=null) dto.setAdresse(requestStudentDto.getAdresse());
        if(requestStudentDto.getGenre()!=null) dto.setGenre(requestStudentDto.getGenre());
        if(requestStudentDto.getFilier()!=null) dto.setFilier(requestStudentDto.getFilier());

        BeanUtils.copyProperties(dto,student);
        Student newStudent = studentRepository.save(student);
        BeanUtils.copyProperties(newStudent,dto);
        return dto;

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

    @Override
    public Diplomat getCurrentDiplomat(Long apogee) {
        Student student= new Student();
        Carriere carriere= new Carriere(student.getApogee());
        Diplomat currentDiplomat =carriere.getDiplomat().getMaxEnumValue();
        System.out.println("carriere of student"+student.getId()+"is"+currentDiplomat);
        return currentDiplomat;
    }
}
