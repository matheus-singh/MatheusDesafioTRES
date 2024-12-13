# Desafio 3 do curso de Spring MVC da Accenture.



## Desafio 3 - Site da Universidade
Aluno: **Matheus Singh Cardoso**

### Passos para executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/matheus-singh/MatheusDesafioTRES
   ```
2. Importe o projeto em sua IDE de preferência (recomendado: IntelliJ IDEA ou Eclipse).
3. Configure o ambiente e execute a aplicação.

### Endpoints Principais

#### Listar Estudantes
- **URL:** `/students`
- **Descrição:** Exibe a lista de estudantes cadastrados.
- **Implementação:**
  ```java
  @GetMapping("/students")
  public ModelAndView listStudents() {
      List<StudentDto> students = studentService.findAllStudents();
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("studentsList");
      modelAndView.addObject("students", students);
      return modelAndView;
  }
  ```

#### Formulário de Cadastro de Estudantes
- **URL:** `/students/register`
- **Descrição:** Exibe um formulário para o cadastro de novos estudantes.
- **Implementação:**
  ```java
  @GetMapping("/students/register")
  public ModelAndView RegisterStudent() {
      StudentRegistrationRequest studentRegistrationRequest = new StudentRegistrationRequest();
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("studentsRegistration");
      modelAndView.addObject("studentRegistrationRequest", studentRegistrationRequest);
      return modelAndView;
  }
  ```

### Tecnologias Utilizadas
- Java
- Spring MVC
- Thymeleaf
- Spring Boot

### Requisitos
- JDK 17
- Maven
- IDE para Java

---
Feito com dedicação durante o curso de Spring MVC da Accenture.

