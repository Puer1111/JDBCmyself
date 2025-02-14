package org.kh.library.model.vo;

public class Book {
private String bookNo;
private String bookName;
private String bookWriter;
private int bookPrice;
private String publisher;
private String genre;

public String getBookNo() {
	return bookNo;
}
public void setBookNo(String bookNo) {
	this.bookNo = bookNo;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getBookWriter() {
	return bookWriter;
}
public void setBookWriter(String bookWriter) {
	this.bookWriter = bookWriter;
}
public int getBookPrice() {
	return bookPrice;
}
public void setBookPrice(int bookPrice) {
	this.bookPrice = bookPrice;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
@Override
public String toString() {
	return "Book [bookNo=" + bookNo + ", bookName=" + bookName + ", bookWriter=" + bookWriter + ", bookPrice="
			+ bookPrice + ", publisher=" + publisher + ", genre=" + genre + ", getBookNo()=" + getBookNo()
			+ ", getBookName()=" + getBookName() + ", getBookWriter()=" + getBookWriter() + ", getBookPrice()="
			+ getBookPrice() + ", getPublisher()=" + getPublisher() + ", getGenre()=" + getGenre() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
}
