package br.com.uri.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressCepDTO {

    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
