package org.project.ghost_forum.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.project.ghost_forum.dto.LikedPostDto;
import org.project.ghost_forum.entity.LikedPost;
import org.project.ghost_forum.entity.primary_keys.LikedPostsPK;

//@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
//        unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface LikedPostMapper {
//    @Mapping(target = "postId", source = "pKey.post.id")
//    @Mapping(target = "userId", source = "user.id")
//    LikedPostDto toDto (LikedPost likedPost);
//
//    @Mapping(source = "postId", target = "post.id")
//    @Mapping(source = "userId", target = "user.id")
//    LikedPost toEntity (LikedPostDto likedPost);
//
//}
