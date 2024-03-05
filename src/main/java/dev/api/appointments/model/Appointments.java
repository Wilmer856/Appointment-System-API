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
    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    public int customerId;
    public int userId;
    public int contactId;

    public Appointments() {
    }

    public Appointments(int appointmentID, String appointmentTitle, String appointmentDescription,
                        String appointmentLocation, String appointmentType, LocalDateTime start, LocalDateTime end, int customerID,
                        int userID, int contactID) {
        this.appointmentId = appointmentID;
        this.title = appointmentTitle;
        this.description = appointmentDescription;
        this.location = appointmentLocation;
        this.type = appointmentType;
        this.start = start;
        this.end = end;
        this.customerId = customerID;
        this.userId = userID;
        this.contactId = contactID;
    }

    /**
     *
     * @return appointmentID
     */
    public int getAppointmentID() {

        return appointmentId;
    }

    /**
     *
     * @return appointmentTitle
     */
    public String getAppointmentTitle() {

        return title;
    }

    /**
     *
     * @return appointmentDescription
     */
    public String getAppointmentDescription() {

        return description;
    }

    /**
     *
     * @return appointmentLocation
     */
    public String getAppointmentLocation() {

        return location;
    }

    /**
     *
     * @return appointmentType
     */
    public String getAppointmentType() {

        return type;
    }

    
    /**
     *
     * @return start
     */
    public LocalDateTime getStart() {
        return start;
    }



    /**
     *
     * @return end
     */
    public LocalDateTime getEnd() {

        return end;
    }

    /**
     *
     * @return customerID
     */
    public int getCustomerID () {

        return customerId;
    }

    /**
     *
     * @return userID
     */
    public int getUserID() {

        return userId;
    }

    /**
     *
     * @return contactID
     */
    public int getContactID() {

        return contactId;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "appointmentID=" + appointmentId +
                ", appointmentTitle='" + title + '\'' +
                ", appointmentDescription='" + description + '\'' +
                ", appointmentLocation='" + location + '\'' +
                ", appointmentType='" + type + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", customerID=" + customerId +
                ", userID=" + userId +
                ", contactID=" + contactId +
                '}';
    }
}

