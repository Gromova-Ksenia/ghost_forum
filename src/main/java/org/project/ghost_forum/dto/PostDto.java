package org.project.ghost_forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private UUID id;
    private UUID authorId;
    private String title;
    private String body;
    private LocalDate creationTime;
    private int rating = 0;
    private Set<CommentDto> comments;
    private Set<TagDto> tags;
}
