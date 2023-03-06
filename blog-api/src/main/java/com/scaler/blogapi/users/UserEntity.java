package com.scaler.blogapi.users;

import com.scaler.blogapi.articles.ArticleEntity;
import com.scaler.blogapi.commons.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "users")
@Setter @Getter
public class UserEntity extends BaseEntity {
    @Column(unique = true, nullable = false, length = 50)
    String username;
    String password;
    String email;
    String bio;
    String image;

    @ManyToMany(mappedBy = "likedBy")
    List<ArticleEntity> likedArticles;

    @ManyToMany
    @JoinTable(
            name = "follows",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "followee_id")
    )
    List<UserEntity> following;

    @ManyToMany(mappedBy = "following")
    List<UserEntity> followers;

}
