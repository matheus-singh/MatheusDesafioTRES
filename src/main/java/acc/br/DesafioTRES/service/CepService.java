package acc.br.DesafioTRES.service;

import acc.br.DesafioTRES.repository.entities.Adress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {

    @GetMapping("{cep}/json")
    Adress findAdressByCep(@PathVariable("cep") String cep);
}