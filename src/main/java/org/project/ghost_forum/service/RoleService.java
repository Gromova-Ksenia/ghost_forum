package org.project.ghost_forum.service;

import lombok.RequiredArgsConstructor;
import org.project.ghost_forum.dto.RoleDto;
import org.project.ghost_forum.entity.Role;
import org.project.ghost_forum.enums.RoleType;
import org.project.ghost_forum.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    public void addRole(RoleDto role){
        repository.save(Role.builder().roleType(RoleType.fromString(role.getRole())).build());
    }

    public List<Role> findAll(){
        return repository.findAll();
    }
}
