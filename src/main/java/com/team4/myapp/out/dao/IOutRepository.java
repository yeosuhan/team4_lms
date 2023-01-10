package com.team4.myapp.out.dao;

import org.apache.ibatis.annotations.Param;

import com.team4.myapp.out.model.OutDto;

public interface IOutRepository {
	OutDto selectCheckOut(@Param("memberId") String memberId, @Param("today") String today);
	
	void insertCheckIn(String membetId);
	
	void updateCheckOut(String memberId);
}
