package com.lawyer.core.mapper;

import com.lawyer.core.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/9/20.
 */
@Repository
public interface RoleMapper {

    int getTotalCounts(@Param(value="role")Role role);

    List<Role> findByPage(@Param(value="role")Role role, @Param(value="startRow")int startRow, @Param(value="endRow")int endRow);

    Role findById(int id);
}
