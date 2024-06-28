package com.kh.jdbc.day01.stmt.member.controller;

import java.util.List;


import com.kh.jdbc.day01.stmt.member.model.dao.MemberDao;
import com.kh.jdbc.day01.stmt.member.model.vo.Member;

public class MemberController {
MemberDao mDao;

public MemberController() {
	mDao = new MemberDao();
}

public void insertMember(Member member) {
//	mDao.selectList(); insert 할때 쓰던거
	mDao.insertMember(member);
	
}
public List<Member>listMember(){
	return mDao.selectList();
}


public Member printOneMember(String memberID) {
Member member = mDao.selectOne(memberID);
	return null;
}
}
