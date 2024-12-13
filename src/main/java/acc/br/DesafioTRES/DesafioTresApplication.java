package acc.br.DesafioTRES;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioTresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTresApplication.class, args);
	}

}
