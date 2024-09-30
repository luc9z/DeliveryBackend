package br.com.uri.delivery.services;

import br.com.uri.delivery.clients.ViaCepClientProxy;
import br.com.uri.delivery.dto.AddressCepDTO;
import br.com.uri.delivery.dto.DeliveryRequestDTO;
import br.com.uri.delivery.dto.DeliveryResponseDTO;
import br.com.uri.delivery.entities.DeliveryEntity;
import br.com.uri.delivery.repositories.DeliveryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ViaCepClientProxy viaCepClientProxy;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, ViaCepClientProxy viaCepClientProxy){
        this.deliveryRepository = deliveryRepository;
        this.viaCepClientProxy= viaCepClientProxy;
    }

    @Override
    @Transactional
    public DeliveryResponseDTO saveDelivery(DeliveryRequestDTO deliveryRequestDTO) {
        AddressCepDTO addressCepDTO = viaCepClientProxy.
                getAddress(deliveryRequestDTO.getCep());

        //Criou uma entidade
        DeliveryEntity deliveryEntity = new DeliveryEntity();

        deliveryEntity.setDeliveryDate(deliveryRequestDTO.
                getDeliveryDate());
        deliveryEntity.setStatus(deliveryRequestDTO.getStatus());

        String logradouro;
        String bairro;

        //logica de cep para cidade com unico cep
        if((addressCepDTO.getLogradouro()
                == null && addressCepDTO.getBairro() == null) ||
                (!addressCepDTO.getLogradouro().isBlank() &&
                        !addressCepDTO.getBairro().isBlank())) {
            logradouro = addressCepDTO.getLogradouro();
            bairro = addressCepDTO.getBairro();
        } else {
            logradouro = deliveryRequestDTO.getLogradouro();
            bairro = deliveryRequestDTO.getBairro();
        }

        deliveryEntity.setAddressDelivery(String.format(
                "%s, %s, %s, %s, %s",
                logradouro,
                deliveryRequestDTO.getNumberAddress(),
                bairro,
                addressCepDTO.getLocalidade(),
                addressCepDTO.getUf()));

        deliveryEntity.setCep(deliveryRequestDTO.getCep());
        deliveryEntity.setCustomerName(deliveryRequestDTO.getCustomerName());

        //salvei no banco dados
        DeliveryEntity entity = deliveryRepository.save(deliveryEntity);

        //transforma e entidade em um responseDTO
        DeliveryResponseDTO deliveryResponseDTO =
                new DeliveryResponseDTO();
        deliveryResponseDTO.setId(entity.getId());
        deliveryResponseDTO.setDeliveryDate(entity.getDeliveryDate());
        deliveryResponseDTO.setAddressDelivery(entity.getAddressDelivery());
        deliveryResponseDTO.setCustomerName(entity.getCustomerName());
        deliveryResponseDTO.setStatus(entity.getStatus());

        return deliveryResponseDTO;

    }
}
