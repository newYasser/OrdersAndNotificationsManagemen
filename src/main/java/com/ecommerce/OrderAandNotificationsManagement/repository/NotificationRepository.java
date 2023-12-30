package com.ecommerce.OrderAandNotificationsManagement.repository;

import com.ecommerce.OrderAandNotificationsManagement.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {
    List<Notification> findByIsSentFalse();
    List<Notification>findByIsSentTrue();

}
