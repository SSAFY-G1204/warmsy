package com.clone.instagram.warmsystargram.domain.UserInteractions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LikeResponseDto {
    private Long likeId;
    private Long userId;

}
