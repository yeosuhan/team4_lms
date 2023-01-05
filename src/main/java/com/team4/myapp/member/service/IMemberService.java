package com.team4.myapp.member.service;

import com.team4.myapp.member.model.Member;

public interface IMemberService {
	Member selectMember(String memberId);
	String getPassword(String memberId);
}
