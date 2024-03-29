package com.ecommerce.OrderAandNotificationsManagement.service.notification;

import com.ecommerce.OrderAandNotificationsManagement.entity.Customer;
import com.ecommerce.OrderAandNotificationsManagement.entity.Notification;
import com.ecommerce.OrderAandNotificationsManagement.entity.OrderDetail;
import com.ecommerce.OrderAandNotificationsManagement.entity.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public class SendSMSNotificationService extends SendNotificationService{
    @Override
    public Notification notifyOrderPlacement(OrderEntity order) {
        String subject = "Order Placment Successfully(SMS)";
        Customer customer = order.getCustomer();
        String content = "Dear" + customer.getName() + " , your booking of the ";
        for(OrderDetail orderDetail: order.getOrderDetails()){
            content += orderDetail.getProduct().getName() + " ";
        }
        content += "is confirmed. thanks for using our store :) ";
        Notification notification = new Notification();
        notification.setMessage(content);
        notification.setSubject(subject);
        notification.setCustomer(customer);
        notificationRepository.save(notification);
        return notification;
    }

    @Override
    public Notification notifyOrderShipping(OrderEntity order) {
        String subject = "Order Started Shipping(SMS)";
        Customer customer = order.getCustomer();
        String content = "Dear" + customer.getName() + " , your order started to ship. ";
        Notification notification = new Notification();
        notification.setMessage(content);
        notification.setSubject(subject);
        notification.setCustomer(customer);
        notificationRepository.save(notification);
        return notification;
    }
}
