package org.project.ghost_forum.dto;

import lombok.*;
import org.project.ghost_forum.entity.Role;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private UUID id;
    private String login;
    private String username;
    private String description;
    private LocalDate registrationDate;
    private Set<Role> roles;
}
