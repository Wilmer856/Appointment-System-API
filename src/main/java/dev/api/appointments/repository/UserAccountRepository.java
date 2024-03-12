package dev.api.appointments.repository;

import dev.api.appointments.model.UserAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccounts, Long> {
    Optional<UserAccounts> findByUsername(String username);
}
