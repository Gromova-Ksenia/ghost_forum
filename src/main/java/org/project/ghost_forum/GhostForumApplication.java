package org.project.ghost_forum;

import jakarta.persistence.Id;
import org.project.ghost_forum.entity.Tag;
import org.project.ghost_forum.enums.TagName;
import org.project.ghost_forum.mapper.TagMapper;
import org.project.ghost_forum.mapper.TagMapperImpl;
import org.project.ghost_forum.repository.TagRepository;
import org.project.ghost_forum.service.TagService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@SpringBootApplication
public class GhostForumApplication {
	public static void main(String[] args) {

//		TagMapper mapper = new TagMapperImpl();
//
//		TagService service = new TagService();
//
//		Tag arttag = new Tag();
//		arttag.setName(TagName.АРТ);
//		//arttag.setId(UUID.randomUUID());
//		service.addTag(arttag);

//		Tag hctag = new Tag();
//		hctag.setName(TagName.ХЕДКАНОН);
//
//		Tag cosplaytag = new Tag();
//		cosplaytag.setName(TagName.КОСПЛЕЙ);
//
//		Tag covertag = new Tag();
//		covertag.setName(TagName.КАВЕР);
//
//		Tag fictag = new Tag();
//		fictag.setName(TagName.ФАНФИК);
//
//		Tag handtag = new Tag();
//		handtag.setName(TagName.ХЕНДМЕЙД);
//
//		Tag videotag = new Tag();
//		videotag.setName(TagName.ВИДЕО);
		SpringApplication.run(GhostForumApplication.class, args);
	}


}

