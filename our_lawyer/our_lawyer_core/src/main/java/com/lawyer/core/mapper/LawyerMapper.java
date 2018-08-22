package com.lawyer.core.mapper;


import com.lawyer.core.entity.Lawyer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LawyerMapper {
	
    List<Lawyer> findAll();

    List<Lawyer> findByPage(Lawyer laweyer, @Param(value="startRow")int startRow, @Param(value="endRow")int endRow);

    Lawyer findById(int id);

    void insert(Lawyer lawyer);
    
    void insertForBatch(List<Lawyer> list);

    int getTotalCounts(Lawyer laweyer);
}
