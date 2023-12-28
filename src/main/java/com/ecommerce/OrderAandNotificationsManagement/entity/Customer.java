package com.ecommerce.OrderAandNotificationsManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.AnnotationConfigUtils;

import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account_id")
    private Account account;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<OrderEntity> orders;

}
