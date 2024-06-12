package org.project.ghost_forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.ghost_forum.entity.Role;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationDto {
    private UUID id;
    private String login;
    private String password;
    private String email;
    private String username;
    private LocalDate registrationDate;
    //private Set<Role> roles;
}
