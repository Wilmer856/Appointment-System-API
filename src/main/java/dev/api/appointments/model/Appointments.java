package dev.api.appointments.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Appointments {
    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
    private long appointmentId;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Businesses business;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services service;
    private LocalDateTime appointmentTime;
    private String status;

    public Appointments() {
    }

    public Appointments(long appointmentId, LocalDateTime appointmentTime, String status) {
        this.appointmentId = appointmentId;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "appointmentId=" + appointmentId +
                ", appointmentTime=" + appointmentTime +
                ", status='" + status + '\'' +
                '}';
    }
}

