package br.com.uri.delivery.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DeliveryResponseDTO {

    private Long id;
    private String addressDelivery;
    private String status;
    private LocalDate deliveryDate;
    private String customerName;
}
