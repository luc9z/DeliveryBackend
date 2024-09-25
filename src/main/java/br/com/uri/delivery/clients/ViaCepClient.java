package br.com.uri.delivery.clients;

import br.com.uri.delivery.dto.AddressCepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCep", url = "https://viacep.com.br/ws", configuration = ViaCepClientConfig.class)
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    public AddressCepDTO getAddress(@PathVariable("cep") String cep);
}
