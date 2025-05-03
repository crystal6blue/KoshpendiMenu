package com.project.koshpendimenu1.Model;


import com.project.koshpendimenu1.Model.Enum.PaymentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private BigDecimal totalPrice;

    @Enumerated
    private PaymentType payment;
    private Long paymentStatus;
    private String status;

    private Long deliverId;
    private Long reservationId;
}
