package com.example.forum_back;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Table(name = "forum")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Forum {

    @Id
    private Long id;
    private String title;
    private String description;
    private String author;
    private String category;

    public static Forum CreateNewForum(String title, String description, String author, String category) {
        Forum forum = new Forum();
        forum.title = title;
        forum.description = description;
        forum.author = author;
        forum.category = category;
        return forum;
    }

}
