package com.kh.jdbc.day01.stmt.member.model.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.stmt.member.model.vo.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
//JDBC를 이용하여 Oracle DB에 접속하는 클래스
//	/JDBC 코딩이 있어야함
private final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
private final String USERNAME = "EDZZ";
private final String PASSWORD = "EDZZ";

	// mList에 member가 들어가는 이유 : 리스트 멤버니까
//	2. rset은 왜  mList에 못들어가나요
//	3. rset을 member로 어떻게 바꾸나요
//	3.1 Member클래스에는 필드, 게터 세터 필요 
//	3.2 resultset 의 getString , getDate 등등 중요
	
public List<Member> selectList() {
	List<Member> mList = new ArrayList<Member>();
	try {
		
		Class.forName(Driver_Name);
		Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		Statement stmt = conn.createStatement();
		String query = "select * from member_tbl";
		ResultSet rset = stmt.executeQuery(query);
		
		while(rset.next()) {
			Member member = new Member();
		
			member.setMembername(rset.getString("member_name"));
			member.setMemberID(rset.getString("member_ID"));
			member.setMemberPW(rset.getString("member_pw"));
			member.setGender(rset.getString("gender"));
			member.setMemberEmail(rset.getString("member_email"));
			member.setPhone(rset.getString("member_phone"));
			member.setMemberage(rset.getString("age"));
			member.setMemberaddress(rset.getString("member_address"));
			member.setHobby(rset.getString("member_hobby"));
			member.setReg_date(rset.getDate("reg_date"));
			
			mList.add(member);
//			System.out.println("이름: "+rset.getString("member_name"));
//			System.out.println("아이디: "+rset.getString("member_ID"));
//			System.out.println("비밀번호: "+rset.getString("member_pw"));
//			System.out.println("성별: "+rset.getString("gender"));
//			System.out.println("이메일: "+rset.getString("member_email"));
//			System.out.println("전화번호: "+rset.getString("member_phone"));
//			System.out.println("나이: "+rset.getString("age"));
//			System.out.println("주소: "+rset.getString("member_address"));
//			System.out.println("취미: "+rset.getString("member_hobby"));
//			System.out.println("등록일: "+rset.getString("reg_date"));
			
		}

		stmt.close();
	
		conn.close();
	
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return mList;
	
}
	

	public void insertMember(Member member)  {
/* 1. 드라이버 연결 (jar)
 * 2. DBMS 연결 생성
 * 3.Statement 생성
 * 4.쿼리문 전송
 * 5.결과값 받기
 * 6.자원해제
 * 
 * 
 * 	
*/		
		
	try {
//		1
		Class.forName("oracle.jdbc.driver.OracleDriver");
//		2
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","EZZJDBC","EZZJDBC");
//		3
		Statement stmt = conn.createStatement();
//		4
		String query = "insert into member_tbl values('"+member.getMemberID()+"','"+member.getMemberPW()+"','"+member.getMembername()+"','"+member.getGender()+"','"+member.getMemberage()+"','"+member.getMemberEmail()+"','"+member.getPhone()+"','"+member.getMemberaddress()+"','"+member.getHobby()+"',default)";
//		5
//		ResultSet rest = stmt.executeQuery(query); select 일때만 사용
 		int result = stmt.executeUpdate(query); // DML경우 호출 메소드
//	후처리
 		if(result>0) {
 			System.out.println("성공");
 		}
 		else {
 	
 		}
// 		6
 		stmt.close();
 		conn.close();
 		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}


	public Member selectOne(String memberId) {
		Member member = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","EDZZJDBC","EDZZJDBC");
			Statement stmt = conn.createStatement();
			String query = "select * from member_tbl where Member_id = '"+ memberId+"'";
			ResultSet rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				member = new Member();
				String memberPw = rset.getString("MEMBER_PW");
				String memberName = rset.getString("Member_name");
				member.setMemberage(rset.getString("age"));
				member.setGender(rset.getString("Gender"));
				member.setHobby(rset.getString("hobby"));
				member.setMemberaddress(rset.getString("Member_address"));
				member.setMemberEmail(rset.getString("Member_Email"));
				member.setMembername(memberName);
				member.setMemberID(memberId);
				member.setMemberPW(memberPw);
				member.setPhone("phone");
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
		return member;
	}
}
