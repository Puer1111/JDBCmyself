package com.kh.jdbc.day02.stmt.member.controller;

import java.util.List;

import com.kh.jdbc.day02.stmt.member.model.dao.MemberDao;
import com.kh.jdbc.day02.stmt.member.model.vo.Member;

public class MemberController {
	MemberDao mDao;

	public  MemberController() {
		mDao = new MemberDao();
	}

	public void insertMember(Member member) {
		mDao.insertMember(member);
	}

	public List<Member> printAllMember() {
		List<Member>mList = mDao.selectList();
		//호출한 곳에서 써야하니 return, MemberView :29;
		return mList;
	}
//	View 가 준거 받아야 하니 printOneMember(String memberID)
	public Member printOneMember(String memberID) {
//		한개라 List 필요없 Member
//		Dao 로 전달 해야하니 SelectOne(memberID)
		
		Member member = mDao.selectOne(memberID);
//		호출 한 곳에서 써야하니 return member ,
		return member;
	}



	public int deleteMember(String memberID) {
// View 에서 ID값 받아야 하니deleteMember(String memberID)
//		reutrn 이 int 라 void 대신 int
//		DML 은 int 라 int result
//		MemberID 전달해야 하니 deleteMember(memberID);
		int result = mDao.deleteMember(memberID);
		return result;
	}

	public int modifyMember(Member modifyInfo) {
//	DML은 int --> int result
//		modifyInfo 전달해야 하니 updateMember(modifyInfo)
		int result = mDao.updatemember(modifyInfo);
//		호출한 곳에 써야하니 return result
		return result;
	}


}
