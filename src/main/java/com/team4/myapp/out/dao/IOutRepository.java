package com.team4.myapp.out.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team4.myapp.out.model.dto.OutDto;

public interface IOutRepository {
	OutDto selectLastOut(@Param("memberId") String memberId, @Param("today") String today);
	
	void insertCheckIn(String membetId);
	
	void updateCheckOut(int outId);
	
	List<OutDto> selectOutList(@Param("memberId") String memberId, @Param("today") String today);
	
	void updateOutNull(@Param("today") String today, @Param("timestamp") String timestamp);

	List<String> selectMemberId(String today);
}
