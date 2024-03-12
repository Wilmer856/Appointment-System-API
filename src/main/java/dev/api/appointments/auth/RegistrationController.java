package dev.api.appointments.auth;

import dev.api.appointments.DTO.AuthenticateRequest;
import dev.api.appointments.DTO.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(registrationService.registerUser(registrationRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody AuthenticateRequest authenticateRequest) {
        return ResponseEntity.ok(registrationService.authenticateUser(authenticateRequest));
    }
}
