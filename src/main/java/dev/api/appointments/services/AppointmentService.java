package dev.api.appointments.services;

import dev.api.appointments.model.Appointments;
import dev.api.appointments.repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentsRepository appointmentsRepository;

    @Autowired
    public AppointmentService(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    public List<Appointments> getAppointments() {
        return appointmentsRepository.findAll();
    }
}
