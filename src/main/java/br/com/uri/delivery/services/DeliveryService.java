package br.com.uri.delivery.services;

import br.com.uri.delivery.dto.DeliveryRequestDTO;
import br.com.uri.delivery.dto.DeliveryResponseDTO;

public interface DeliveryService {

    DeliveryResponseDTO saveDelivery(DeliveryRequestDTO deliveryRequestDTO);
}
