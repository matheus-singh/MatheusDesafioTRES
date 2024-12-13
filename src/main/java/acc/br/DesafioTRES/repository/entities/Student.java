package acc.br.DesafioTRES.repository.entities;

import acc.br.DesafioTRES.controller.requests.StudentRegistrationRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birthDate;

    @Embedded
    private Adress adress;

    private String course;
}

