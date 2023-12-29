package com.ecommerce.OrderAandNotificationsManagement.repository;


import com.ecommerce.OrderAandNotificationsManagement.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment,Integer> {
}
