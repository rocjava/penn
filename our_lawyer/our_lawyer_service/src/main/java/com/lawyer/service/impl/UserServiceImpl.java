package com.lawyer.service.impl;

import com.lawyer.core.entity.User;
import com.lawyer.core.mapper.UserMapper;
import com.lawyer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int totalCounts(User user) {
        return userMapper.getTotalCounts(user);
    }

    @Override
    public List<User> findByPage(User user, int startRow, int endRow) {
        return userMapper.findByPage(user, startRow, endRow);
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }
}
