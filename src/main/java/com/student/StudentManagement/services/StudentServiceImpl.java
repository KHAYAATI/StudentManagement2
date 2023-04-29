package com.student.StudentManagement.services;

import com.student.StudentManagement.dto.RequestStudentDto;
import com.student.StudentManagement.model.Filiere;
import com.student.StudentManagement.model.ModuleF;
import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.model.StudentPojo;
import com.student.StudentManagement.repository.FilierRepository;
import com.student.StudentManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final FilierRepository filierRepository;

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
    public RequestStudentDto createStudent(RequestStudentDto student) {
        RequestStudentDto dto = RequestStudentDto.builder().build();
        Student student1 = new Student();
        BeanUtils.copyProperties(student, student1);
        Student storedStudent = studentRepository.save(student1);
        BeanUtils.copyProperties(storedStudent, dto);
        return dto;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByApogee(Long apogee) {
        Optional<Student> opt = Optional.ofNullable(studentRepository.getStudentByApogee(apogee));
        Student student;
        if (opt.isPresent()) {
            student = opt.get();
        } else {
            throw new RuntimeException("Student not found for apogee :: " + apogee);
        }

        return student;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(Long apogee) {

        Long id = studentRepository.getStudentByApogee(apogee).getId();
        studentRepository.deleteById(id);
    }
}
