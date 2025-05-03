package com.project.koshpendimenu1.Model;


import com.project.koshpendimenu1.Enum.PaymentType;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPayment(PaymentType payment) {
        this.payment = payment;
    }

    public void setPaymentStatus(Long paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
