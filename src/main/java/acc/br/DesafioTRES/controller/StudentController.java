package acc.br.DesafioTRES.controller;

import acc.br.DesafioTRES.controller.requests.StudentRegistrationRequest;
import acc.br.DesafioTRES.dto.StudentDto;
import acc.br.DesafioTRES.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Lista os estudantes cadastrados
    @GetMapping("/students")
    public ModelAndView listStudents(){
        List<StudentDto> students = studentService.findAllStudents();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentsList");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    // Exibe o formulário de cadastro
    @GetMapping("/students/register")
    public ModelAndView RegisterStudent(){
        StudentRegistrationRequest studentRegistrationRequest = new StudentRegistrationRequest();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentsRegistration");
        modelAndView.addObject("studentRegistrationRequest", studentRegistrationRequest);
        return modelAndView;
    }

    // Recebe os dados do formulário e processa a confirmação
    @PostMapping("/students/register")
    public ModelAndView registerStudent(@ModelAttribute("studentRegistrationRequest") StudentRegistrationRequest studentRegistrationRequest) {

        // Com os dados recebidos retorna um DTO para confirmacao
        StudentDto student = studentService.createAndSave(studentRegistrationRequest);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentsConfirmation"); // tela de confirmacao
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    // cancelamento
    @GetMapping("/cancel")
    public String cancelRegistration() {
        return "redirect:/students";  // página inicial de estudantes
    }

    // confirma
    @PostMapping("/students/register/confirm")
    public String confirmStudentRegistration(@ModelAttribute("student") StudentDto studentDto){
        // Com o DTO cria e salva o estudante
        studentService.createAndSave(studentDto);
        return "redirect:/students";
    }
}
