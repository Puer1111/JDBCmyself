package com.kh.jdbc.day03.pstmt.member.controller;

import com.kh.jdbc.day03.pstmt.member.model.dao.MemberDao;
import com.kh.jdbc.day03.pstmt.member.model.vo.Member;

public class MemberController {
	MemberDao mDao;

	public MemberController() {
		mDao = new MemberDao();
	}

	public int registerMember(Member member) {
		int result = mDao.insertMember(member);
		return result;
	}

	public Member checkLogin(Member member) {
		Member result = mDao.selectOne(member);
		return null;
	}

	public int deleteMember(String memberID) {
	int result = mDao.deleteMember(memberID);
		return result;
	}

	public Member checkMember(String memberID) {
		Member result = mDao.selectOne(memberID);
		return null;
	}

	public int updateMember(Member member) {
		int result = mDao.UpdateMember(member);
		return result;
	}


}
