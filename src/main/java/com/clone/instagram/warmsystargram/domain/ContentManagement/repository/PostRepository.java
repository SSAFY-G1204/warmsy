package com.clone.instagram.warmsystargram.domain.ContentManagement.repository;


import com.clone.instagram.warmsystargram.domain.ContentManagement.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserUserId(Long userId);



}
