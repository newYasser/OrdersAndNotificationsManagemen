package com.ecommerce.OrderAandNotificationsManagement.service.order;


import com.ecommerce.OrderAandNotificationsManagement.entity.OrderDetail;
import com.ecommerce.OrderAandNotificationsManagement.entity.OrderEntity;
import com.ecommerce.OrderAandNotificationsManagement.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class CompoundOrderService extends OrderService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    public CompoundOrderService(@Qualifier("shippingPaymentCompoundOrderStrategy") ShippingPaymentStrategy shippingPaymentStrategy) {
        super(shippingPaymentStrategy);
    }

    @Override
    public long calculateShippingCost() {
       return shippingPaymentStrategy.calaculateShippingFees();
    }

    public void addOrder(List<OrderEntity> orderEntities) {
        int order_id = orderRepository.save(orderEntities.get(0)).getId();
        for(OrderEntity order : orderEntities){
            order.setId(order_id);
        }
        orderRepository.saveAll(orderEntities);
    }

    public List<OrderEntity>getCompoundOrderById(Integer id){

        return null;
    }

    public void payOrdersCompoundOrder(List<OrderEntity>orders) {
        for(OrderEntity order : orders){
            payOrderById(order.getId());
        }
    }

}
