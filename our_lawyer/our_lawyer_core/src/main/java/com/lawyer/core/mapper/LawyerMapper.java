package com.lawyer.core.mapper;


import com.lawyer.core.entity.Lawyer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LawyerMapper {
	
    List<Lawyer> findAll();

    List<Lawyer> findByPage(@Param(value="lawyer")Lawyer laweyer, @Param(value="startRow")int startRow, @Param(value="endRow")int endRow);

    Lawyer findById(int id);

    int insert(Lawyer lawyer);
    
    int insertForBatch(List<Lawyer> list);

    int getTotalCounts(@Param(value="lawyer")Lawyer lawyer);
}
