package br.com.uri.delivery.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "DELIVERY")
@Getter
@Setter
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ADDRESS_DELIVERY")
    private String addressDelivery;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DELIVERY_DATE")
    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(name = "DRIVER_ID")
    private DriverEntity driver;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;


}
