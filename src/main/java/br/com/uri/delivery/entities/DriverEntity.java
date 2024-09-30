package br.com.uri.delivery.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "DRIVER")
@Getter
@Setter
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DRIVER_NAME")
    private String driverName;

    @Column(name = "LICENCE_NUMBER")
    private String licenseNumber;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<DeliveryEntity> deliveries;
}
