package org.project.ghost_forum.service;

import lombok.RequiredArgsConstructor;
import org.project.ghost_forum.entity.Comment;
import org.project.ghost_forum.mapper.CommentMapper;
import org.project.ghost_forum.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    CommentRepository repository;
    CommentMapper mapper;

    public Set<Comment> getComments(List<UUID> commentIds){
        return commentIds.stream()
                .map(repository::findById)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
