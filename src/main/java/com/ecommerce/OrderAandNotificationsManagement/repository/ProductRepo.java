package com.ecommerce.OrderAandNotificationsManagement.repository;

import com.ecommerce.OrderAandNotificationsManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}
