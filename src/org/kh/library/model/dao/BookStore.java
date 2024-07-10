package org.kh.library.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.kh.library.model.vo.Book;

public interface BookStore {

	public List<Book> selectAllBook(Connection conn);
	public Book selectBookOne(int bookNo, Connection conn);
	public int insertBook(Book book, Connection conn) throws SQLException;
	public int deleteBook(String bookNo, Connection conn) throws SQLException;
	public Book selectBookOneByCode(Connection conn, String bookcode) throws SQLException;

}
