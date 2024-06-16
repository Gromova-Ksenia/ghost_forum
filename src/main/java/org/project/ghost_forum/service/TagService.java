package org.project.ghost_forum.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.project.ghost_forum.dto.TagDto;
import org.project.ghost_forum.mapper.TagMapper;
import org.project.ghost_forum.repository.TagRepository;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.project.ghost_forum.entity.Tag;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository repository;
    private final TagMapper mapper;

    public void addTag(TagDto dto){
        Tag tag = mapper.toEntity(dto);
        repository.save(tag);
    }

    @Transactional
    public void addTag(Tag tag){
        repository.saveAndFlush(tag);
        System.out.println("Должно было случиться сохранение");
        System.out.println(tag);
    }
}
