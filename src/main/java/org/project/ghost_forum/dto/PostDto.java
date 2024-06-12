package org.project.ghost_forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.ghost_forum.entity.User;

import java.time.LocalDate;
import java.util.List;
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
    //private List<Comment> coments;
    private Set<TagDto> tags;
}
