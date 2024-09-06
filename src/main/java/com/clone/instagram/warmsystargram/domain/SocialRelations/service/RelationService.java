package com.clone.instagram.warmsystargram.domain.SocialRelations.service;

import com.clone.instagram.warmsystargram.domain.SocialRelations.dao.Relation;
import com.clone.instagram.warmsystargram.domain.SocialRelations.repository.RelationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationService {

    private final RelationRepository relationRepository;

    public RelationService(RelationRepository relationRepository) {
        this.relationRepository = relationRepository;
    }

    public List<Relation> findRelationByFollowerId(Long userId) {
        return relationRepository.findRelationByFollowerId(userId);
    }




}
