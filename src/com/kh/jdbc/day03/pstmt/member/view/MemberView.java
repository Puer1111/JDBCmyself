package com.kh.jdbc.day03.pstmt.member.view;

import java.util.Scanner;

import com.kh.jdbc.day03.pstmt.member.controller.MemberController;
import com.kh.jdbc.day03.pstmt.member.model.vo.Member;

public class MemberView {
	MemberController mController;

	public MemberView() {
		mController = new MemberController();
	}

	public void StartProgram() {
		end: while (true) {
			int choice = this.MainMenu();
			switch (choice) {
			case 1:
//				회원 정보를 입력 받은 후 객체 저장 후 
				Member member = this.inputInfo();
//				객체를 컨트롤러에 전달.
				int result = mController.registerMember(member);
				if (result > 0) {
					printMessage("회원가입 성공");
				} else {
					printMessage("회원가입 실패");
				}
				break;
			case 2:
				member = this.inputLoginInfo();
//				입력한 ID ,PW 가 있는지 DB에서 확인
				member = mController.checkLogin(member);
				if(member!= null) {
					this.printOneMember(member);
				}else {
					printMessage("존재하지 않습니다");
				}
				break;
			case 3:
				String memberID = inputMemberID();
				member = mController.checkMember(memberID);
				if(member!= null) {
					member = modifyMember();
					member.setMemberID(memberID);
					result = mController.updateMember(member);
					if(result > 0) {
						printMessage("정보수정 성공");
					}
				}else {
					printMessage("존재하지 않습니다");
				}
				break;
			case 4:
				memberID = inputMemberID();
				member = mController.checkMember(memberID);
				result = mController.deleteMember(memberID);
				if(member!=null) {
					printMessage("삭제 성공");
				}else {
					printMessage("존재하지 않는 정보");
				}
				break;
			case 5:
				break;
			case 6:
				break;
			case 9:
				printMessage("프로그램 종료");
				break end;

			}

		}

	}

	private Member modifyMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======회원 정보 입력======");
		System.out.print("비밀번호: ");
		String MemberPW = sc.next();
		System.out.print("이메일: ");
		String email = sc.next();
		System.out.print("전화 번호: ");
		String phone = sc.next();
		System.out.print("주소: ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미: ");
		String hobby = sc.next();
//		리턴 여러개 안되니 객체 생성해 하나로 넣어서 반환
//		매개변수 생성자 사용
		Member member = new Member(MemberPW, email, phone, address, hobby);

		return member;
	}

	private String inputMemberID() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력: ");
		String memberID = sc.next();

		return memberID;
	}

	private void printOneMember(Member member) {
		System.out.println("===회원 정보 출력===");
		System.out.printf(
				"아이디: %s\t " + 
				" 이름: %s\t ," + 
				" 성별: %s\t ," + 
				" 나이: %d\t ," + 
				" 이메일:%s\t ,," +
				" 전화번호: %s\t ,"+ 
				" 주소: %s\t ," + 
				" 취미 : %s\t ," + 
				" 날짜: %t\t ",
				member.getMemberID(), 
				member.getMemberName(),
				member.getGender(), 
				member.getAge(), 
				member.getEmail(),
				member.getPhone(), 
				member.getAddress(), 
				member.getHobby(),
				member.getRegDate());

//		member.getMemberID() ;
//		member.getMemberName();
//		member.getGender();
//		member.getAge();
//		member.getEmail();
//		member.getPhone();
//		member.getAddress();
//		member.getHobby();
//		member.getRegDate();		
	}

	private Member inputLoginInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======로그인 정보 입력======");
		System.out.print("아이디: ");
		String MemberID = sc.next();
		System.out.print("비밀번호: ");
		String MemberPW = sc.next();
//		리턴 여러개니 객체 이용
		Member member = new Member();
	
		member.setMemberID(MemberID);
		member.setMemberPW(MemberPW);
		return member;

	}

	private Member inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======회원 정보 입력======");
		System.out.print("아이디: ");
		String MemberID = sc.next();
		System.out.print("비밀번호: ");
		String MemberPW = sc.next();
		System.out.print("이름: ");
		String MemberName = sc.next();
		System.out.print("성별: ");
		String gender = sc.next();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("이메일: ");
		String email = sc.next();
		System.out.print("전화 번호: ");
		String phone = sc.next();
		System.out.print("주소: ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미: ");
		String hobby = sc.next();
//		리턴 여러개 안되니 객체 생성해 하나로 넣어서 반환
//		매개변수 생성자 사용
		Member member = new Member(MemberID, MemberPW, MemberName, gender, age, email, phone, address, hobby);
//		member.setMemberID(MemberID);
//		member.setMemberPW(MemberPW);
//		member.setMemberName(MemberName);
//		member.setGender(gender);
//		member.setAge(age);
//		member.setEmail(email);
//		member.setPhone(phone);
//		member.setAddress(address);
//		member.setHobby(hobby);

		return member;
	}

	private void printMessage(String msg) {
		System.out.println("[결과]:" + msg);

	}

	private int MainMenu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====== 회원 관리 프로그램 ======");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 회원정보 수정");
		System.out.println("4. 회원정보탈퇴");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 선택 :");
		int input = sc.nextInt();
		return input;

	}

}
