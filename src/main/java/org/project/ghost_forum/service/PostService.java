package org.project.ghost_forum.service;

import lombok.RequiredArgsConstructor;
import org.project.ghost_forum.dto.PostDto;
import org.project.ghost_forum.entity.Post;
import org.project.ghost_forum.entity.Tag;
import org.project.ghost_forum.entity.User;
import org.project.ghost_forum.mapper.PostMapper;
import org.project.ghost_forum.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final PostMapper mapper;
    private final UserService userService;

    public List<PostDto> getAll(){
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

//    @Transactional
//    public PostDto createPost(PostDto dto){
//        User author = userService.getUserById(dto.getAuthorId());
//
//        Set<Tag> tags = tag
//
//        Post post = mapper.toEntity(dto).builder()
//                .author(author)
//                .title(dto.getTitle())
//                .body(dto.getBody())
//                .creationTime(LocalDate.now())
//                .rating(0)
//                .tags(Set<Tag>);
//
//    }

    // СДЕЛАЙ TagService СДЕЛАЙ TagService СДЕЛАЙ TagService СДЕЛАЙ TagService
}
