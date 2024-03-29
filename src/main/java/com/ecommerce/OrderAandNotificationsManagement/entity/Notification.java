package com.ecommerce.OrderAandNotificationsManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notification")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String subject;
    @Column
    private String message;

    @Column(columnDefinition = "boolean default false")
    private boolean isSent;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

}
