package com.team4.myapp.cause.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team4.myapp.cause.model.Cause;
import com.team4.myapp.cause.model.dto.CauseListDto;


public interface ICauseRepository {
	int selectCauseCount(String memberId);
	int selectCount();
	CauseListDto selectCauseDetail(int causeId);
	
	void insertCause(Cause cause);
	
	List<CauseListDto> selectCauseList(@Param("memberId") String memberId,
			@Param("start")int start, @Param("end") int end);
	
	List<CauseListDto> selectCauseAdmin(@Param("start")int start, @Param("end") int end);
	
	void updateCauseDetail(Cause cause);
	void deleteCause(int causeId);

}
