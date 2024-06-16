package org.project.ghost_forum.enums;

import java.util.Arrays;
import java.util.Objects;

public enum TagName {

    АРТ,
    ХЕДКАНОН,
    КОСПЛЕЙ,
    КАВЕР,
    ФАНФИК,
    ХЕНДМЕЙД,
    ВИДЕО;

    public static TagName fromString(String tag){
        return Arrays.stream(TagName.values())
                .filter(type -> Objects.equals(tag, type.name()))
                .findAny().orElse(null);
    }
}
