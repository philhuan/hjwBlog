package com.hjwblog.hjwblogserver.service;

import com.hjwblog.hjwblogserver.model.User;

public interface UserService {
    /**
     * 添加一个用户
     * @param user 用户对象
     */
    public boolean add(User user);
}
