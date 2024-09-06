package com.clone.instagram.warmsystargram.domain.ContentManagement.controller;

import com.clone.instagram.warmsystargram.domain.ContentManagement.dto.FeedResponseDto;
import com.clone.instagram.warmsystargram.domain.ContentManagement.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {


    @Autowired
    private PostService postService;


    //내가 팔로잉 하는 사람의 post 객체 찾기
    @GetMapping("/home/feeds")
    public List<FeedResponseDto> GetMyFeed(@RequestParam long userId){
        return postService.findFolollowingPostsByUserId(userId);
    }

//    @GetMapping("/home/test")
//    public List<testDto> GetMyTest(){
//        return postService.findPost();
//    }
//

}
