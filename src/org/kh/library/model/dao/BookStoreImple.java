package org.kh.library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.kh.library.model.vo.Book;
import org.kh.library.model.vo.Customer;

public class BookStoreImple implements BookStore {

	@Override
	public List<Book> selectAllBook(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		List<Book>bList = null;
		try {
			String query = "select * from Book ";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			bList = new ArrayList<Book>();	
			while(rset.next()) {
				Book book = rsetToBook(rset);
				bList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bList;
	}

	private Book rsetToBook(ResultSet rset) throws SQLException {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setBookNo(rset.getString("Book_No"));
		book.setBookName(rset.getString("Book_name"));
		book.setBookWriter(rset.getString("Book_writer"));
		book.setBookPrice(rset.getInt("Book_Price"));
		book.setPublisher(rset.getString("Publisher"));
		book.setGenre(rset.getString("genre"));
		return book;
	}

	@Override
	public Book selectBookOne(int bookNo, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBook(Book book, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into book values(seq_book_no.nextval , ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getBookWriter());
		pstmt.setInt(3, book.getBookPrice());
		pstmt.setString(4, book.getPublisher());
		pstmt.setString(5, book.getGenre());
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}

	@Override
	public int deleteBook(String bookNo, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "Delete from Book where Book_no = ?";
		pstmt= conn.prepareStatement(query);
		pstmt.setString(1,bookNo);
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}

	public Book selectBookOneByCode(Connection conn, String bookcode) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Book result = null;
		String query = "Select * from Book where Book_code = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, bookcode);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			result = rsetToBook(rset);
		}
		pstmt.close();
		
		return result;
	}

	public List<Customer> selectAllCustomer(Connection conn)  {
		Statement stmt = null;
		ResultSet rset = null;
		List<Customer>cList =null;
		try {
			stmt = conn.createStatement();
			String query = "select * from Customer";
			rset=stmt.executeQuery(query);
			cList = new ArrayList<Customer>();
			
			while(rset.next()) {
				Customer cust = rsetToCustomer(rset);
				cList.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cList;
	}

	private Customer rsetToCustomer(ResultSet rset) throws SQLException {
		Customer cust = new Customer ();
		cust.setUserno(rset.getInt("user_no"));
		cust.setUserID(rset.getString("user_ID"));
		cust.setUsername(rset.getString("user_name"));
		cust.setUserage(rset.getInt("user_age"));
		cust.setAddr(rset.getString("addr"));
		cust.setGender(rset.getString("gender"));
		
		return cust;
	}



}
