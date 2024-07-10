package org.kh.library.model.service;

import java.util.ArrayList;
import java.util.List;

import org.kh.library.model.vo.Book;

public interface BookService {
	public ArrayList<Book> selectAllBook();
	public List<Book>printAllbook();
	public Book selectBookOne(int bookNo);
	public int insertBook(Book book);
	public int deleteBook(String bookNo);
	public Book selectBookOneByCode(String bookcode);
	
}
