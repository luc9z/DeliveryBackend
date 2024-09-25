package br.com.uri.delivery.controllers;

import br.com.uri.delivery.clients.ViaCepClientProxy;
import br.com.uri.delivery.dto.AddressCepDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final ViaCepClientProxy viaCepClientProxy;

    public HelloWorldController(ViaCepClientProxy viaCepClientProxy){
        this.viaCepClientProxy = viaCepClientProxy;
    }

    @GetMapping("/hello-world")
    public ResponseEntity<String> helloWord() {
        return ResponseEntity.ok("Hello World!!");
    }

    @GetMapping("/get-cep/{cep}")
    public ResponseEntity<AddressCepDTO> getAddress
            (@PathVariable("cep") String cep) {
        AddressCepDTO response =
                viaCepClientProxy.getAddress(cep);
        return ResponseEntity.ok(response);
    }
}
