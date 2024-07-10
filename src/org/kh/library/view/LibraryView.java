package org.kh.library.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.kh.library.controller.BookController;
import org.kh.library.controller.CustomerController;
import org.kh.library.model.vo.Book;
import org.kh.library.model.vo.Customer;
import org.kh.library.model.vo.Library;

public class LibraryView implements LibraryViewI {

	public Scanner sc = new Scanner(System.in);
	private BookController bController;
	private CustomerController cController;

	public LibraryView() {
		bController = new BookController();
		cController = new CustomerController();
	};

	@Override
	public int mainMenu() {
		// TODO Auto-generated method stub
		System.out.println("메인메뉴");
		System.out.println("1. 책 관리");
		System.out.println("2. 회원 관리");
		System.out.println("3. 대여 관리");
		System.out.print("메뉴 선택 : ");
		return sc.nextInt();
	}

	@Override
	public void bookMenu() {
		// TODO Auto-generated method stub
		end: while (true) {
			System.out.println("책관리 서브메뉴");
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 코드로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 삭제하기");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Book> bList = bController.selectAllBook();
				if (!bList.isEmpty()) { // isEmpty OR Size()
					this.displayBookList(bList);
				} else {
					this.displayError("존재하지 않는 정보입니다");
				}
				break;
			case 2:
//				String bookNo = this.inputBookNo();
				String bookNo = this.inputBookNo();
				Book book = bController.selectBookOneByCode(bookNo);
				if (book != null) {
					this.displayMessage("조회 성공");
				} else {
					this.displayError("조회 실패");
				}
				break;
			case 3:
				book = this.inputBook();
				int result = bController.insertBook(book);
				if (result > 0) {
					this.displaySucess("책 등록 성공");
				} else {
					this.displayError("책 등록 실패");
				}
				break;
			case 4:
				String bookno = this.inputBookNo();
				result = bController.deleteBook(bookno);
				if (result > 0) {
					this.displaySucess("삭제 성공");
				} else {
					this.displayError("삭제 실패");
				}
			case 0:
				break end;

			}
		}

	}

	private String inputBookcode() {
		Scanner sc = new Scanner(System.in);
		System.out.println("책 코드 입력 : ");

		return sc.next();
	}

	@Override
	public void customerMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("회원관리 서브메뉴");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 회원 이름으로 조회");
			System.out.println("3. 회원 아이디로 조회");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 메인 메뉴로 이동");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Customer> cList = bController.selectAllCustomer();
				if (cList.size() > 0) {
					this.displayCustomerList(cList);
				}
				break;
			case 2:
				String custId = this.inputCName();
				if(custId != null) {
					Customer cust = cController.selectNameSearch(custId);
				}
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				return;
			}
		}
	}

	@Override
	public void libraryMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("대여관리 서브메뉴");
			System.out.println("1. 전체 대여 조회");
			System.out.println("2. 대여 아이디로 조회");
			System.out.println("3. 대여 책이름으로 조회");
			System.out.println("4. 대여정보 추가");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				return;
			}
		}
	}

	@Override
	public void displayLibraryList(ArrayList<Library> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayLibraryList(Library library) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displaySucess(String msg) {
		// TODO Auto-generated method stub
		System.out.println("[서비스결과 :]" + msg);

	}

	@Override
	public String inputUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inputBookName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Library insertLibrary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayBookList(List<Book> bList) {
		System.out.println("=====책 전체 조회=====");
		for (Book book : bList) {
			System.out.printf("책 번호: %s , 책 제목 : %s , 글쓴이: %s , 가격: %d , 출판사 :%s ,장르: %s\n", book.getBookNo(),
					book.getBookName(), book.getBookWriter(), book.getBookPrice(), book.getPublisher(),
					book.getGenre());
		}
	}

	@Override
	public void displayMessage(String message) {
		System.out.println("[안내]: " + message);
	}

	@Override
	public void displayError(String message) {
		System.out.println("[서비스결과 :]" + message);
	}

	@Override
	public void displayCustomerList(List<Customer> cList) {
		System.out.println("=====회원 전체 조회======");
		for (Customer cust : cList) {
			System.out.printf("고객번호: %d , 고객 아이디: %s , 이름: %s , 나이:%d , 주소: %s , 성별: %s\n", cust.getUserno(),
					cust.getUserID(), cust.getUsername(), cust.getUserage(), cust.getAddr(), cust.getGender());
		}
	}

	@Override
	public void diplayCutomerOne(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public String inputCName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회 할 이름 : ");
		return sc.next();
	}

	@Override
	public String inputCId() {
		return null;
	}

	@Override
	public List<Customer> inputCustomer() {

		return null;
	}

	@Override
	public Customer modifyCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inputBookNo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 책 번호 입력: ");

		return sc.next();
	}

	@Override
	public Book inputBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====책 정보 등록=====");
		System.out.println("책 제목: ");
		String bookName = sc.nextLine();
		System.out.println("글쓴이: ");
		String bookWriter = sc.nextLine();
		System.out.println("가격:");
		int bookPrice = sc.nextInt();
		System.out.println("출판사: ");
		sc.nextLine();
		String publisher = sc.nextLine();
		System.out.println("장르: ");
		String genre = sc.nextLine();

		Book book = new Book();
		book.setBookName(bookName);
		book.setBookWriter(bookWriter);
		book.setBookPrice(bookPrice);
		book.setPublisher(publisher);
		book.setGenre(genre);

		return book;
	}

}
