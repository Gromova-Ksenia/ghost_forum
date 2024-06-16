package org.project.ghost_forum.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.project.ghost_forum.annotations.Encrypt;
import org.project.ghost_forum.dto.UserDto;
import org.project.ghost_forum.entity.Role;
import org.project.ghost_forum.entity.User;
import org.project.ghost_forum.mapper.UserMapper;
import org.project.ghost_forum.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final UserRepository repository;
    private final RoleService roleService;
    @PersistenceContext
    private EntityManager entityManager;

    @Encrypt //Добавляем нового юзера
    public UserDto addUser(UserDto userDto) {
        List<UUID> roleIds = userDto.getRoles().stream().map(Role::getId).collect(Collectors.toList());

        Set<Role> roles = roleService.getRoles(roleIds);

        User entity = mapper.toEntity(userDto);
        entity.setRoles(roles);

        User savedEntity = repository.save(entity);

        UserDto dto = mapper.toDto(savedEntity);

        return dto;
    }

    //Я ничё не понял
    public UserDto getCurrent() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();

            return repository.findByUsername(username)
                    .map(mapper::toDto)
                    .orElseThrow(() -> new UsernameNotFoundException("Пользователь с указанным username не найден"));
        }

        return null;
    }

    public Boolean banUser(UUID id) {
        return repository.findById(id)
                .map(user -> {
                    user.setIsBanned(true);
                    repository.save(user);
                    return Boolean.TRUE;
                })
                .orElse(Boolean.FALSE);
    }

    public User getUserById(UUID id){
        return repository.findById(id).orElseThrow();
    }
}
