package org.kh.library.controller;

import java.util.List;

import org.kh.library.model.service.BookServiceImple;
import org.kh.library.model.vo.Book;
import org.kh.library.model.vo.Customer;

public class BookController implements BookControllerI{

	BookServiceImple  bService;
	
	public BookController() {
		bService = new BookServiceImple();
	}
	@Override
	public List<Book> selectAllBook() {
		// TODO Auto-generated method stub
		List<Book>bList = bService.printAllbook();
		return bList;
	}

	@Override
	public void selectBookOne(int bookNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insertBook(Book book) {
		int result = bService.insertBook(book);
		return result;		
	}

	@Override
	public int deleteBook(String bookno) {
		int result = bService.deleteBook(bookno);
		return result;
		
	}
	public Book selectBookOneByCode(String bookcode) {
		Book result = bService.selectBookOneByCode(bookcode);
		return result;
	}
	public List<Customer> selectAllCustomer() {
		List<Customer> cList = bService.selectAllCustomer();
		return cList;
	}


}
