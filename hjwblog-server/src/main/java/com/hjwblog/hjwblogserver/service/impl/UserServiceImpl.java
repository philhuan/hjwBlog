package com.hjwblog.hjwblogserver.service.impl;

import com.hjwblog.hjwblogserver.model.User;
import com.hjwblog.hjwblogserver.model.mapper.UserMapper;
import com.hjwblog.hjwblogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;
    @Override
    public boolean add(User user) {
        return mapper.insert(user) > 0;
    }

}
