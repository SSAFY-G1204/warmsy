package com.clone.instagram.warmsystargram.domain.UserInfoManagement.service;

import com.clone.instagram.warmsystargram.domain.UserInfoManagement.dao.User;
import com.clone.instagram.warmsystargram.domain.UserInfoManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findUsersByNickname(String keyword) {
        return userRepository.findUsersByNickname(keyword);
    }




}




