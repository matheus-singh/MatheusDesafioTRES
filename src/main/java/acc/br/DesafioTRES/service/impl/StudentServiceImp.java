package acc.br.DesafioTRES.service.impl;

import acc.br.DesafioTRES.controller.requests.StudentRegistrationRequest;
import acc.br.DesafioTRES.dto.StudentDto;
import acc.br.DesafioTRES.repository.StudentRepository;
import acc.br.DesafioTRES.repository.entities.Adress;
import acc.br.DesafioTRES.repository.entities.Student;
import acc.br.DesafioTRES.service.CepService;
import acc.br.DesafioTRES.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CepService cepService;

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::mapToStudentDto).collect(Collectors.toList());
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentDto createAndSave(StudentRegistrationRequest studentRegistrationRequest) {
        Adress adress = cepService.findAdressByCep(studentRegistrationRequest.getCep());

        return StudentDto.builder()
                .name(studentRegistrationRequest.getName())
                .birthDate(studentRegistrationRequest.getBirthDate())
                .uf(adress.getUf())
                .city(adress.getLocalidade())
                .street(adress.getLogradouro())
                .cep(adress.getCep())
                .course(studentRegistrationRequest.getCourse())
                .build();
    }

    @Override
    public StudentDto createAndSave(StudentDto studentDto) {
        studentRepository.save(mapToStudent(studentDto));
        return studentDto;
    }

    @Override
    public void deleteByName(String name) {
        Student student = studentRepository.findByName(name);
        studentRepository.delete(student);
    }

    private Student mapToStudent(StudentDto studentDto) {
        System.out.println(studentDto.getCep());
        return Student.builder()
                .name(studentDto.getName())
                .birthDate(studentDto.getBirthDate())
                .adress(cepService.findAdressByCep(studentDto.getCep()))
                .course(studentDto.getCourse())
                .build();
    }

    private StudentDto mapToStudentDto(Student student){
        return StudentDto.builder()
                .name(student.getName())
                .birthDate(student.getBirthDate())
                .uf(student.getAdress().getUf())
                .city(student.getAdress().getLocalidade())
                .street(student.getAdress().getLogradouro())
                .cep(student.getAdress().getCep())
                .course(student.getCourse())
                .build();
    }
}
