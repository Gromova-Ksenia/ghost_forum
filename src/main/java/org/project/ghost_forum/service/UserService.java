package org.project.ghost_forum.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.project.ghost_forum.mapper.UserMapper;
import org.project.ghost_forum.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

//@Service
//@RequiredArgsConstructor
//public class UserService implements UserDetailsService {
//    private final UserMapper mapper;
//    private final UserRepository repository;
//    private final RoleService roleService;
//
//    //@Encrypt
//
//}
