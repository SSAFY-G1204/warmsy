package com.clone.instagram.warmsystargram.domain.ContentManagement.dao;
import com.clone.instagram.warmsystargram.domain.UserInfoManagement.dao.User;
import com.clone.instagram.warmsystargram.domain.UserInteractions.dao.Comment;
import com.clone.instagram.warmsystargram.domain.UserInteractions.dao.Like;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@AllArgsConstructor // 모든 필드를 초기화하는 생성자
@Builder // 빌더 패턴
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId ;

    //내용
    @Column(length = 100)
    private String content;

    //좋아요 수
    @Column(length = 100, nullable = false)
    private String liking;

    //등록일
    @Column(nullable = false)
    private String rgtDate;

    //유저키
    @OneToMany(mappedBy ="post")
    @Column(nullable = false)
    private List<Like> likes = new ArrayList<Like>();

    @OneToMany(mappedBy ="post")
    @Column(nullable = false)
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "post")
    @Column(nullable=false)
    private List<Media> medias = new ArrayList<Media>();


    //JsonIgnore은 가져오지 않게 한거임 Post 조회할때..
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

}