package com.ecommerce.OrderAandNotificationsManagement.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="order_entity")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date date;

    @Column
    private Time time;

    @Column(columnDefinition = "boolean default false")
    private boolean isShipped;

    @OneToMany(mappedBy = "order")
    @JsonManagedReference
    private List<OrderDetail> orderDetails;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    private Shipment shipment;


    @JsonIgnore
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    @JsonIgnore
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    @JsonIgnore

    public Customer getCustomer() {
        return customer;
    }
    @JsonIgnore

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
