package com.clone.instagram.warmsystargram.domain.UserInteractions.dao;

import com.clone.instagram.warmsystargram.domain.UserInfoManagement.dao.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@AllArgsConstructor // 모든 필드를 초기화하는 생성자
@Builder // 빌더 패턴
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ChannelId;
    @Column(nullable = false)
    private Long receivedId;
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

}