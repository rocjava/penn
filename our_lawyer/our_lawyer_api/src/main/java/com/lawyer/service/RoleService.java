package com.lawyer.service;

import com.lawyer.core.entity.Role;

import java.util.List;

/**
 * Created by Administrator on 2018/9/21.
 */
public interface RoleService {
    int totalCounts(Role role);

    List<Role> findByPage(Role role, int startRow, int endRow);

    Role findById(int id);
}
