package acc.br.DesafioTRES.service;

import acc.br.DesafioTRES.controller.requests.StudentRegistrationRequest;
import acc.br.DesafioTRES.dto.StudentDto;
import acc.br.DesafioTRES.repository.entities.Student;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAllStudents();

    Student save(Student student);

    StudentDto createAndSave(StudentRegistrationRequest studentRegistrationRequest);

    StudentDto createAndSave(StudentDto studentDto);

    void deleteByName(String name);
}
