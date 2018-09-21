package com.lawyer.service.impl;

import com.lawyer.core.entity.Role;
import com.lawyer.core.mapper.RoleMapper;
import com.lawyer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/9/21.
 */
@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int totalCounts(Role role) {
        return roleMapper.getTotalCounts(role);
    }

    @Override
    public List<Role> findByPage(Role role, int startRow, int endRow) {
        return roleMapper.findByPage(role, startRow, endRow);
    }

    @Override
    public Role findById(int id) {
        return roleMapper.findById(id);
    }
}
