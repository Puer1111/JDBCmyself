package com.kh.jdbc.day02.stmt.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day02.stmt.member.model.vo.Member;

public class MemberDao {
	/*
	 * jdbc 코딩 절차 드라이버 등록 jdbc 연결 Statement 생성 쿼리문 전송 결과 받기 자원 해제
	 */
	private final String Driver_name = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "EZZJDBC";
	private final String PW = "EZZJDBC";
	Connection conn = null;
	Statement stmt = null;

	public void insertMember(Member member) {

		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
			stmt = conn.createStatement();
//			쿼리문 작성 ;오타 조심 홀따옴표 조심
			String query = "insert into member_tbl values('" + member.getID() + "','" + member.getPW() + "','"
					+ member.getName() + "','" + member.getGender() + "','" + member.getAge() + "','"
					+ member.getEmail() + "','" + member.getHobby() + "','" + member.getPhone() + "','"
					+ member.getAddress() + "',default)"; // 쿼리문 작성
//			DML의 경우 성공한 "행"의 개수 리턴 메소드는 executeUpdate 사용
			int result = stmt.executeUpdate(query); // 결과 받기

			if (result > 0) { // 지금은 자동 커밋이다.
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void insertMember() {
		// TODO Auto-generated method stub

	}

//MemberController 에 printAllMember 에서 선언중
	public List<Member> selectList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Member> mList = null;
		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
			stmt = conn.createStatement();
			String query = "Select * from member_tbl";
			rset = stmt.executeQuery(query);
			// 후처리 여러개니까 while 전부 가져올때까지
//			 null 이면 안되니 new ArrayList();
			mList = new ArrayList<Member>();
			while (rset.next()) {
				// rset은 바로 못쓰니 Member
				Member member = this.rsetToMember(rset);
				mList.add(member);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 호출한 곳에서 써야하니 return mList Member Controller printAllMember에서 사용중
		return mList;
	}

	public Member selectOne(String memberID) {
		Connection conn = null;
		Statement stmt = null;
//		셀렉트니까 Resultset
		ResultSet rset = null;
		Member member = null;
		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
			stmt = conn.createStatement();
			String query = "select * from member_tbl where member_id = '" + memberID + "'";
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				member = rsetToMember(rset);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}

	public Member rsetToMember(ResultSet rset) throws SQLException {
		Member member = new Member();
//		비어 있으면 안되니 Setter
//		resultset 에서 값 가져와야 하니 rset.getStirng(컬럼명) 
		member.setID(rset.getString("member_id"));
		member.setPW(rset.getString("member_pw"));
		member.setName(rset.getString("member_name"));
		member.setGender(rset.getString("gender"));
		member.setAge(rset.getInt("age"));
		member.setEmail(rset.getString("member_email"));
		member.setHobby(rset.getString("member_hobby"));
		member.setPhone(rset.getString("member_phone"));
		member.setAddress(rset.getString("member_address"));
		member.setRegDate(rset.getDate("reg_date"));
//		member에 다담은뒤 호출한곳에서 써야하니 return member;

		return member;
	}

	public int deleteMember(String memberID) {
		/*
		 * 드라이버 등록 DB연결 Statement 등록 쿼리문 작성 종료 후처리
		 * 
		 */
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
//			conn.setAutoCommit(false); ---> 밑에서 커밋 롤백 하는데 자동 커밋 해제 하는 키워드
			stmt = conn.createStatement();
//			문자열은 ' ' 로 감싸줘야한다.
			// DML 의 결과는 성공한 행의 개수라 정수
//			쿼리 실행 메소드는 DML이니 executeupdate
			String query = "Delete from member_Tbl where member_id = '" + memberID + "'";
			result = stmt.executeUpdate(query);
//			if(result> 0) {
//				this.displayMessage("삭제 성공");
//				
////				conn.commit(); 커밋 키는거
//			}else {
//				this.displayMessage("삭제 실패");
////				conn.rollback(); 롤백
//			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		try안 변수는 return 안되니 밖에서 해야함
//		호출한 곳은 return result MemberController 에 있음.

		return result;
	}

	public int updatemember(Member modifyInfo) {
// finally 에서 close 하니까 
		Connection conn = null;
		Statement stmt = null;
		int result = 0;

		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
//			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String query = "update member_tbl set member_pw = '"+modifyInfo.getPW()+"',Email = '"+modifyInfo.getEmail()+"',Phone = '"+modifyInfo.getPhone()+"',Hobby = '"+modifyInfo.getHobby()+"'where member_id = '"+modifyInfo.getID()+"'";
			result = stmt.executeUpdate(query);
			if (result > 0) {
				System.out.println("성공");
//				conn.commit();
			} else {
//			conn.rollback();
				System.out.println("실패");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
// MemberController 에서 호출
		return result;
	}

//	private void displayMessage(String Message) {
//		System.out.println("[서비스 결과] : " + Message);
//		
//	}
//

}
