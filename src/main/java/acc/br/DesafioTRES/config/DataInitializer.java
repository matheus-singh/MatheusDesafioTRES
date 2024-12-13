package acc.br.DesafioTRES.config;

import acc.br.DesafioTRES.beans.DataLoader;
import acc.br.DesafioTRES.repository.StudentRepository;
import acc.br.DesafioTRES.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final StudentRepository studentRepository;
    private CepService cepService;

    @Autowired
    public DataInitializer(StudentRepository studentRepository, CepService cepService) {
        this.studentRepository = studentRepository;
        this.cepService = cepService;
    }

    @Bean(initMethod = "initDatabase")
    public DataLoader dataLoader() {
        return new DataLoader(studentRepository, cepService);
    }


}
