package org.kh.library.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.kh.library.common.JDBCTemplate;
import org.kh.library.model.dao.BookStoreImple;
import org.kh.library.model.vo.Book;
import org.kh.library.model.vo.Customer;

public class BookServiceImple implements BookService {

	private BookStoreImple bStore;

	public BookServiceImple() {
		bStore = new BookStoreImple();
	}

	@Override
	public ArrayList<Book> selectAllBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book selectBookOne(int bookNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBook(Book book) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			result = bStore.insertBook(book, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public int deleteBook(String bookno) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			result = bStore.deleteBook(bookno, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Book> printAllbook() {
		Connection conn = null;
		List<Book> bList = null;
		try {
			conn = JDBCTemplate.getConnection();
			bList = bStore.selectAllBook(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bList;
	}

	public Book selectBookOneByCode(String bookcode) {
		Connection conn = null;
		Book result = null;
		try {
			conn = JDBCTemplate.getConnection();
			result = bStore.selectBookOneByCode(conn, bookcode);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public List<Customer> selectAllCustomer() {
		Connection conn = null;
		List<Customer> cList = null;
		try {
			conn = JDBCTemplate.getConnection();
			cList = bStore.selectAllCustomer(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cList;
	}

}
