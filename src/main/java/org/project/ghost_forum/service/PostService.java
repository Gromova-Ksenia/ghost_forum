package org.project.ghost_forum.service;

import lombok.RequiredArgsConstructor;
import org.project.ghost_forum.dto.CommentDto;
import org.project.ghost_forum.dto.PostDto;
import org.project.ghost_forum.dto.TagDto;
import org.project.ghost_forum.entity.Comment;
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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final PostMapper mapper;
    private final UserService userService;
    private final TagService tagService;
    private final CommentService commentService;

    public List<PostDto> getAll(){
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Transactional
    public PostDto createPost(PostDto postDto){
        User author = userService.getUserById(postDto.getAuthorId());

        List<UUID> tagIds = postDto.getTags().stream().map(TagDto::getId).collect(Collectors.toList());
        Set<Tag> postTags = tagService.getTags(tagIds);

        List<UUID> commentIds = postDto.getComments().stream().map(CommentDto::getId).toList();
        Set<Comment> comments = commentService.getComments(commentIds);

        Post post = mapper.toEntity(postDto).builder()
                .author(author)
                .title(postDto.getTitle())
                .body(postDto.getBody())
                .creationTime(LocalDate.now())
                .rating(0)
                .comments(comments)
                .tags(postTags).build();

        Post savedPost = repository.save(post);
        return mapper.toDto(savedPost);
    }

}
