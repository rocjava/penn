package com.lawyer.core.mapper;

import com.lawyer.core.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int getTotalCounts(@Param(value="user")User user);

    List<User> findByPage(@Param(value="user")User user, @Param(value="startRow")int startRow, @Param(value="endRow")int endRow);

    User findById(int id);

    //int insert(User user);


}
