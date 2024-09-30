package br.com.uri.delivery.repositories;

import br.com.uri.delivery.entities.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {

    @Query(value = "SELECT d FROM DELIVERY d WHERE d.STATUS = :status", nativeQuery = true)
    List<DeliveryEntity> findByDeliveryStatus(@Param("status") String status);
}
