package org.project.ghost_forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private UUID commentId;
    private UUID postId;
    private UUID userId;
    private LocalDate creationTime;
    private String body;
}
