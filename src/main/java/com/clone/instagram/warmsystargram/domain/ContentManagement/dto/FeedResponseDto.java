package com.clone.instagram.warmsystargram.domain.ContentManagement.dto;


import com.clone.instagram.warmsystargram.domain.UserInteractions.dto.CommentResponseDto;
import com.clone.instagram.warmsystargram.domain.UserInteractions.dto.LikeResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FeedResponseDto {
    private Long postId;
    private String content;
    private String rgtDate;
    private Long userId;

    private List<MediaResponseDto> medias;
    private List<LikeResponseDto> likes;
    private List<CommentResponseDto> comments;

}
