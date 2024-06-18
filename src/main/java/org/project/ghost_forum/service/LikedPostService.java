package org.project.ghost_forum.service;

import lombok.RequiredArgsConstructor;
import org.project.ghost_forum.dto.UserDto;
import org.project.ghost_forum.entity.LikedPost;
import org.project.ghost_forum.mapper.LikedPostMapper;
import org.project.ghost_forum.repository.LikedPostRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LikedPostService {
    private final LikedPostRepository repository;
    private final LikedPostMapper mapper;
    private final UserService userService;

    public char getPostRateForCurrentUser(UUID postId){
        UserDto user = userService.getCurrent();
        UUID userId = user.getId();

        return repository.findByUserIdAndPostId(userId, postId)
                .map(LikedPost::getRate).orElse('0');

    }
}
