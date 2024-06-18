package org.project.ghost_forum.entity;
import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //Внутри класса Post
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "body", length = 5000)
    @NotNull
    private String body;

    @Column(name = "creation_time")
    @NotNull
    private LocalDate creationTime;

    @Column(name = "rating")
    @Builder.Default
    private int rating = 0;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    @JoinTable(name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Tag> tags;
}
