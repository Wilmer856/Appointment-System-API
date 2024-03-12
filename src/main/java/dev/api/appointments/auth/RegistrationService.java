package dev.api.appointments.auth;

import dev.api.appointments.DTO.AuthenticateRequest;
import dev.api.appointments.DTO.RegistrationRequest;
import dev.api.appointments.config.JWTService;
import dev.api.appointments.model.Businesses;
import dev.api.appointments.model.Customers;
import dev.api.appointments.model.Role;
import dev.api.appointments.model.UserAccounts;
import dev.api.appointments.repository.BusinessRepository;
import dev.api.appointments.repository.CustomersRepository;
import dev.api.appointments.repository.UserAccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    @Autowired
    private UserAccountRepository userAccountsRepository;

    @Autowired
    private BusinessRepository businessesRepository;

    @Autowired
    private CustomersRepository customersRepository;

    private final PasswordEncoder passwordEncoder;

    private final JWTService jwtService;

    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthenticationResponse registerUser(RegistrationRequest registrationRequest) {
        String username = registrationRequest.getUsername();
        String password = registrationRequest.getPassword();
        Role role = registrationRequest.getRole();

        UserAccounts userAccounts = new UserAccounts(username, passwordEncoder.encode(password), role);

        if (role.equals(Role.BUSINESS)) {
            Businesses business = new Businesses(
                    registrationRequest.getBusinessName(),
                    registrationRequest.getOwnerName(),
                    registrationRequest.getDescription(),
                    registrationRequest.getAddress(),
                    registrationRequest.getPhoneNumber(),
                    registrationRequest.getEmail()
            );
            userAccounts.setBusiness(business);
            businessesRepository.save(business);
        } else if (role.equals(Role.CUSTOMER)) {
            Customers customer = new Customers(
                    registrationRequest.getFirstName(),
                    registrationRequest.getLastName(),
                    registrationRequest.getEmail(),
                    registrationRequest.getPhoneNumber()
            );
            userAccounts.setCustomer(customer);
            customersRepository.save(customer);
        }

        var user = User.builder().username(username).password(passwordEncoder.encode(password)).roles(String.valueOf(role));

        userAccountsRepository.save(userAccounts);
        var jwtToken = jwtService.generateToken(userAccounts);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticateUser(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticateRequest.getEmail(), authenticateRequest.getPassword())
        );

        var user = userAccountsRepository.findByUsername(authenticateRequest.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
