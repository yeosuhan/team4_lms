package com.team4.myapp.reasoncategory.dao;

import java.util.List;

import com.team4.myapp.reasoncategory.model.ReasonCategory;

public interface IReasonCategoryRepository {
	List<ReasonCategory> selectCategoryList();
	
}
