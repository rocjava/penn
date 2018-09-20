package com.lawyer.service;

import com.lawyer.core.entity.User;

import java.util.List;

public interface UserService {

    int totalCounts(User user);

    List<User> findByPage(User user, int startRow, int endRow);

    User findById(int id);
}
