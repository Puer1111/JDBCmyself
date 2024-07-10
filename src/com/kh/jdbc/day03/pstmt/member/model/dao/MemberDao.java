package com.kh.jdbc.day03.pstmt.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.jdbc.day03.pstmt.member.model.vo.Member;

public class MemberDao {
// 넘어오는 값 이름은 상관없다 타입만 같으면 된다. memOne = 컨트롤러에 mOne 이랑 같고 view 에 member랑 같다.
	private final String Driver_name = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "EZZJDBC";
	private final String PW = "EZZJDBC";

	public int insertMember(Member member) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
			String query = "insert into member_Tbl values(? , ? , ? ,?, ? , ? , ? , ? , ? ,Default)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberID());
			pstmt.setString(2, member.getMemberPW());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getHobby());
			pstmt.setString(9, member.getAddress());
			result = pstmt.executeUpdate();
			// stmt = conn.createStatement();
//			String query = "insert into member_tbl values('" + member.getMemberID() + "','" + member.getMemberPW()
//					+ "','" + member.getMemberName() + "','" + member.getGender() + "'," + member.getAge() + ",'"
//					+ member.getEmail() + "','" + member.getPhone() + "','" + member.getHobby() + "','"
//					+ member.getAddress() + "',default)";
//			result = stmt.executeUpdate(query);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member selectOne(Member member) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Member result = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
//			쿼리문을 그대로 실행하는 Statement와 다르게 쿼리문을 이용하여 컴파일을 미리하여 객체 생성
//			쿼리문에는 값이 들어가는 자리를 위치홀더로 표시 해줘야함
			String query = "Select * from member_tbl where MEMBER_ID = ? and MEMBER_PW = ? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberID());
			pstmt.setString(2, member.getMemberPW());
			rset = pstmt.executeQuery();
// Statement 사용			
			// stmt = conn.createStatement();
//			String query = "select * from member_tbl where member_id = '" + member.getMemberID() + "' and member_pw = '"
//					+ member.getMemberPW() + "'";
//			rset = stmt.executeQuery(query);

			if (rset.next()) {
				result = rsetToMember(rset);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	private Member rsetToMember(ResultSet rset) throws SQLException {

		Member member = new Member();
//		String MemberID = rset.getString("MEMBER_ID");
		member.setMemberID(rset.getString("MEMBER_ID"));
//		String MemberPw = rset.getString("MEMBER_PW");
//		member.setMemberPW(MemberPw);
		member.setMemberPW(rset.getString("MEMBER_PW"));
		member.setMemberName(rset.getString("MEMBER_NAME"));
		member.setGender(rset.getString("GENDER"));
		member.setAge(rset.getInt("AGE"));
		member.setEmail(rset.getString("MEMBER_EMAIL"));
		member.setPhone(rset.getString("MEMBER_PHONE"));
		member.setHobby(rset.getString("MEMBER_HOBBY"));
		member.setAddress(rset.getString("MEMBER_ADDRESS"));
		member.setRegDate(rset.getDate("REG_DATE"));

		return member;
	}

	public int deleteMember(String memberID) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		int result = 0;
		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
			String query = "DELETE from MEMBER_TBL where MEMBER_ID = ? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberID);
//			stmt = conn.createStatement();
			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public Member selectOne(String memberID) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		Member result = null;

		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
//			쿼리문을 그대로 실행하는 Statement와 다르게 쿼리문을 이용하여 컴파일을 미리하여 객체 생성
//			쿼리문에는 값이 들어가는 자리를 위치홀더로 표시 해줘야함
			String query = "Select * from member_tbl where member_id = ? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberID);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rsetToMember(rset);
			}
// Statement 사용			
			// stmt = conn.createStatement();
//			String query = "select * from member_tbl where member_id = '" + member.getMemberID() + "' and member_pw = '"
//					+ member.getMemberPW() + "'";
//			rset = stmt.executeQuery(query);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	
	
	public int UpdateMember(Member member) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		int result = 0;

		try {
			Class.forName(Driver_name);
			conn = DriverManager.getConnection(URL, ID, PW);
			conn.setAutoCommit(false);
			String query = "Update member_tbl set Member_PW = ? , member_email = ? , member_phone = ? , member_address = ? , member_hobby = ? , member_ID = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPW());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getHobby());
			pstmt.setString(6, member.getMemberID());

			result = pstmt.executeUpdate();
			if(result> 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
		return result;
	}
}
