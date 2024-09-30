package br.com.uri.delivery.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DeliveryRequestDTO {

    private String status;
    private LocalDate deliveryDate;
    private String cep;
    private String customerName;
    private String logradouro;
    private String bairro;
    private String numberAddress;
}
