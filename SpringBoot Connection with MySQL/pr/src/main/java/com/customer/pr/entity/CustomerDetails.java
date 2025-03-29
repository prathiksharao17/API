package com.customer.pr.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUST_DET")
public class CustomerDetails {

    @Id
    @Column(name = "id", nullable = false)
    private Long id; // No auto-increment as per requirement

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "mobile_no", length = 15, nullable = false, unique = true)
    private String mobileNo;

    @Column(name = "email_id", length = 100, nullable = false, unique = true)
    private String emailId;

    @Column(name = "country_origin", length = 50, nullable = false)
    private String countryOrigin;

    @Column(name = "effective_date", nullable = false)
    private LocalDateTime effectiveDate;

    // Default constructor
    public CustomerDetails() {
    }

    // Constructor with all fields
    public CustomerDetails(Long id, String type, String fullName, LocalDate dateOfBirth, 
                           String status, String mobileNo, String emailId, 
                           String countryOrigin, LocalDateTime effectiveDate) {
        this.id = id;
        this.type = type;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.countryOrigin = countryOrigin;
        this.effectiveDate = effectiveDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", status='" + status + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailId='" + emailId + '\'' +
                ", countryOrigin='" + countryOrigin + '\'' +
                ", effectiveDate=" + effectiveDate +
                '}';
    }
}
