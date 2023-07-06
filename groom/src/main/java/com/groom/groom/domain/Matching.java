package com.groom.groom.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.groom.groom.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicInsert
public class Matching extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;

    @Enumerated(EnumType.STRING)
    private MatchingStatus status;

    public Matching(Users user, Post post) {
        this.user = user;
        this.post = post;
        this.status = MatchingStatus.HOLDING;
    }

    public void setUser(Users user) {this.user = user;}
    public void setPost(Post post) {this.post = post;}
    public void setStatus() {this.status= MatchingStatus.OK;}


}
