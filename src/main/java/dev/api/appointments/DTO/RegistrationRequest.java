package dev.api.appointments.DTO;

import dev.api.appointments.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    private String username;
    private String password;
    private Role role;
    private String businessName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String ownerName;
    private String description;
    private String address;

}
