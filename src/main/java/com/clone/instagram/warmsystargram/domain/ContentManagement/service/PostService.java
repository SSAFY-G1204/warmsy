package com.clone.instagram.warmsystargram.domain.ContentManagement.service;


import com.clone.instagram.warmsystargram.domain.ContentManagement.dao.Media;
import com.clone.instagram.warmsystargram.domain.ContentManagement.dao.Post;
import com.clone.instagram.warmsystargram.domain.ContentManagement.dto.FeedResponseDto;
import com.clone.instagram.warmsystargram.domain.ContentManagement.dto.MediaResponseDto;
import com.clone.instagram.warmsystargram.domain.ContentManagement.repository.PostRepository;
import com.clone.instagram.warmsystargram.domain.SocialRelations.dao.Relation;
import com.clone.instagram.warmsystargram.domain.SocialRelations.repository.RelationRepository;
import com.clone.instagram.warmsystargram.domain.UserInteractions.dao.Comment;
import com.clone.instagram.warmsystargram.domain.UserInteractions.dao.Like;
import com.clone.instagram.warmsystargram.domain.UserInteractions.dto.CommentResponseDto;
import com.clone.instagram.warmsystargram.domain.UserInteractions.dto.LikeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RelationRepository relationRepository;

    public List<Post> findByUserId(Long userId) {
        //System.out.print(postRepository.findByUserUserId(userId).toString());
        return postRepository.findByUserUserId(userId);
    }



    public List<FeedResponseDto> findFolollowingPostsByUserId(Long userId){

        // 관계 테이블에서 내가 파리미터로 준 userId를 follower로 두고 있는 관계들을 찾는다.
        List<Relation> relations = relationRepository.findRelationByFollowerId(userId);
        List<Post> tgtpost = new ArrayList<>();

        List<FeedResponseDto> feedResponseDtos = new ArrayList<>();

        for( int idx = 0 ; idx<relations.size(); idx++){
            tgtpost = findByUserId(relations.get(idx).getUsers().getUserId());
        }

        if(!tgtpost.isEmpty()){
            for (int idx = 0; idx< tgtpost.size(); idx++){

                List<Like> likes =  tgtpost.get(idx).getLikes();

                List<Media> medias =  tgtpost.get(idx).getMedias();

                List<Comment> comments = tgtpost.get(idx).getComments();

                List<LikeResponseDto> likeResponseDtos = new ArrayList<>();
                List<MediaResponseDto> mediaReponseDtos = new ArrayList<>();
                List<CommentResponseDto> commentResponseDtos = new ArrayList<>();


                for(int i=0; i<likes.size(); i++){
                    Like like = likes.get(i);
                    LikeResponseDto likeResponseDto = new LikeResponseDto(like.getLikeId(),like.getUser().getUserId());
                    likeResponseDtos.add(likeResponseDto);

                }

                for(int i=0; i<medias.size(); i++){
                    MediaResponseDto mediaReponseDto = new MediaResponseDto(medias.get(i).getImageSrc());
                    mediaReponseDtos.add(mediaReponseDto);
                }

                for(int i=0; i<comments.size(); i++){
                    Comment cmt = comments.get(i);
                    CommentResponseDto commentResponseDto = new CommentResponseDto(cmt.getCommentId(),cmt.getContent(),cmt.getRgtDate());
                    commentResponseDtos.add(commentResponseDto);
                }


                FeedResponseDto feedResponseDto = new FeedResponseDto(tgtpost.get(idx).getPostId(),
                        tgtpost.get(idx).getContent(),
                        tgtpost.get(idx).getRgtDate(),
                        tgtpost.get(idx).getUser().getUserId(),
                        mediaReponseDtos,likeResponseDtos,commentResponseDtos);


                feedResponseDtos.add(feedResponseDto);
            }
        }

        return feedResponseDtos;

    }

}

