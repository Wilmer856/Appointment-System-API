package dev.api.appointments.repository;

import dev.api.appointments.model.Businesses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Businesses, Long> {

}
