package com.clone.instagram.warmsystargram.domain.SocialRelations.repository;


import com.clone.instagram.warmsystargram.domain.SocialRelations.dao.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {
    List<Relation> findRelationByFollowerId(Long userId);
}
