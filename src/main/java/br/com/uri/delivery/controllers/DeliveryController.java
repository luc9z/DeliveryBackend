package br.com.uri.delivery.controllers;

import br.com.uri.delivery.dto.DeliveryRequestDTO;
import br.com.uri.delivery.dto.DeliveryResponseDTO;
import br.com.uri.delivery.services.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    private DeliveryService deliveryService;

    public DeliveryController (DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @PostMapping("/deliveries/create")
    public ResponseEntity<DeliveryResponseDTO>
        saveDelivery(@RequestBody DeliveryRequestDTO deliveryRequestDTO){

        DeliveryResponseDTO response = deliveryService
                .saveDelivery(deliveryRequestDTO);

        return ResponseEntity.status
                (HttpStatus.CREATED).body(response);

    }
}
