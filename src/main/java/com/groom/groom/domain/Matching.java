package com.groom.groom.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.groom.groom.BaseTimeEntity;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @JoinColumn(name = "opener_id")
    @JsonIgnore
    private Users opener;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;

    @Enumerated(EnumType.STRING)
    private MatchingStatus status;


    @Column(nullable = false)
    @Schema(description = "연락수단", example = "전화번호/카카오톡id/옾챗")
    private String contact;

    public Matching(Users user,Users opener, Post post, String contact) {
        this.user = user;
        this.opener = opener; // opener 추가
        this.post = post;
        this.status = MatchingStatus.HOLDING;
        this.contact= contact;
    }

    public void setUser(Users user) {this.user = user;}
    public void setPost(Post post) {this.post = post;}
    public void setStatus() {this.status= MatchingStatus.OK;}

    public char getPostStatus() {
        return post.getStatus();
    }

    public void setOpener(Users opener) { // setter 추가
        this.opener = opener;
    }

}
