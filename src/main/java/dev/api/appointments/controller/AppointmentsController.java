package dev.api.appointments.controller;

import dev.api.appointments.model.Appointments;
import dev.api.appointments.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/appointments")
public class AppointmentsController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentsController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointments> getAppointments(){
        return appointmentService.getAppointments();
    }
}
