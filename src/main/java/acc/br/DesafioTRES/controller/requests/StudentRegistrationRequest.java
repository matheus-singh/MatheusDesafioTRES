package acc.br.DesafioTRES.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRegistrationRequest {
    private String name;
    private LocalDate birthDate;
    private String cep;
    private String course;
}
