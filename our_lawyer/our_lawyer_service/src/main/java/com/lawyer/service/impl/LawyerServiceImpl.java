package com.lawyer.service.impl;

import com.lawyer.core.entity.Lawyer;
import com.lawyer.core.mapper.LawyerMapper;
import com.lawyer.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("lawyerService")
public class LawyerServiceImpl implements LawyerService {

	@Autowired
	private LawyerMapper lawyerMapper;

	@Override
	public List<Lawyer> findAll() {
		return lawyerMapper.findAll();
	}

	@Override
	public Lawyer findById(int id) {
		return lawyerMapper.findById(id);
	}

	@Override
	public void insert(Lawyer lawyer) {
		lawyerMapper.insert(lawyer);
	}

	@Override
	public void insertForBatch(List<Lawyer> list) {
		lawyerMapper.insertForBatch(list);
	}

	@Override
	public int totalCounts(Lawyer laweyer) {
		return lawyerMapper.getTotalCounts(laweyer);
	}

	@Override
	public List<Lawyer> findByPage(Lawyer laweyer, int startRow, int endRow) {
		return lawyerMapper.findByPage(laweyer, startRow, endRow);
	}

}
