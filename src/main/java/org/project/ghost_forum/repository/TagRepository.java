package org.project.ghost_forum.repository;

import jakarta.persistence.Id;
import org.project.ghost_forum.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
}
