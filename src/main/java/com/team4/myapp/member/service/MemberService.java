package com.team4.myapp.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.myapp.member.dao.IMemberRepository;
import com.team4.myapp.member.model.Member;
@Service
public class MemberService implements IMemberService {

	@Autowired
	IMemberRepository memberDao;
	
	@Override
	public Member selectMember(String memberId) {
		return memberDao.selectMember(memberId);
	}
	@Override
	public String getPassword(String memberId) {
		return memberDao.getPassword(memberId);
	}
	@Override
	public Member selectLecture() {
		return memberDao.selectLecture();
	}
	
	
}
