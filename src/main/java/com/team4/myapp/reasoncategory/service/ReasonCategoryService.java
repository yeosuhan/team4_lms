package com.team4.myapp.reasoncategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.myapp.reasoncategory.dao.IReasonCategoryRepository;
import com.team4.myapp.reasoncategory.model.ReasonCategory;

@Service
public class ReasonCategoryService implements IReasonCategoryService {
	
	@Autowired
	IReasonCategoryRepository rcRepository;
	
	@Override
	public List<ReasonCategory> selectCategoryList() {
		return rcRepository.selectCategoryList();
	}

}
