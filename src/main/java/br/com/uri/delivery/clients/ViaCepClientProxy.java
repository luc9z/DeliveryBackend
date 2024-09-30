package br.com.uri.delivery.clients;


import br.com.uri.delivery.dto.AddressCepDTO;
import org.springframework.stereotype.Service;

@Service
public class ViaCepClientProxy {

    private final ViaCepClient viaCepClient;

    public ViaCepClientProxy(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public AddressCepDTO getAddress(String cep) {
        long startTime = System.currentTimeMillis();
        AddressCepDTO addressCepDTO = viaCepClient.getAddress(cep);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Tempo de resposta da API ViaCEP para" +
                " o CEP" + cep + ": " + elapsedTime +" ms");
        return addressCepDTO;
    }
}
