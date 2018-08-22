package com.lawyer.service;


import com.lawyer.core.entity.Lawyer;

import java.util.List;


public interface LawyerService {

	List<Lawyer> findAll();
	
    Lawyer findById(int id);

    void insert(Lawyer lawyer);
    
    void insertForBatch(List<Lawyer> list);

    int totalCounts(Lawyer laweyer);

    List<Lawyer> findByPage(Lawyer laweyer, int startRow, int endRow);
}
