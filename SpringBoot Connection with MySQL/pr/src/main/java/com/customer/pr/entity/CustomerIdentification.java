package com.customer.pr.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cust_identi")
public class CustomerIdentification {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "item", nullable = false, length = 255)
    private String item;

    @Column(name = "effective_date", nullable = false)
    private LocalDateTime effectiveDate;

    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String toString() {
        return "CustIdenti{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", type=" + type +
                ", item='" + item + '\'' +
                ", effectiveDate=" + effectiveDate +
                '}';
    }
}
