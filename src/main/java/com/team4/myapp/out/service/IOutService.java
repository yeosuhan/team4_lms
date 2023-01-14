package com.team4.myapp.out.service;

import java.text.ParseException;

import com.team4.myapp.out.model.OutListDto;

public interface IOutService {
	boolean selectOut(String memberId);
	
	void insertCheckIn(String memberId);
	
	void updateCheckOut(String memberId);
	
	OutListDto getOutDetails(String memberId, String today) throws ParseException;
}
