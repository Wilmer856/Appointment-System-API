package dev.api.appointments.model;

import jakarta.persistence.*;

@Entity
@Table
public class Businesses {

    @Id
    @SequenceGenerator(
            name = "business_sequence",
            sequenceName = "business_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "business_sequence"
    )
    private long businessId;
    private String name;
    private String ownerName;
    private String description;
    private String address;
    private String phoneNumber;
    private String email;


    public Businesses() {
    }

    public Businesses(String name, String ownerName, String description, String address, String phoneNumber, String email) {
        this.name = name;
        this.ownerName = ownerName;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Businesses(long businessId, String name, String ownerName, String description, String address, String phoneNumber, String email) {
        this.businessId = businessId;
        this.name = name;
        this.ownerName = ownerName;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
