package com.customer.pr.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cust_cont")
public class CustomerContactInformation {

    @Id
    private Long id;  // No Auto-increment as per request

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "value", nullable = false, length = 255)
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String toString() {
        return "CustomerContact{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", type=" + type +
                ", value='" + value + '\'' +
                ", effectiveDate=" + effectiveDate +
                '}';
    }
}
