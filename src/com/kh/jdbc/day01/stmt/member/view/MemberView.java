package com.kh.jdbc.day01.stmt.member.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day01.stmt.member.controller.MemberController;
import com.kh.jdbc.day01.stmt.member.model.vo.Member;

public class MemberView {

	MemberController mController = new MemberController();
	public MemberView() {
		mController = new MemberController();
	}
public void startProgram() {
//	mController.insertMember();
//	List<Member>mList = mController.listMember();
//	this.displayMemberList(mList);--> insert 쓸때 필요
	end:
	while(true) {
		int	choice = this.printMainMenu();
		switch(choice) {
		case 1: 
			Member member = this.inputMember();
			mController.insertMember(member);
			break;
		case 2:
			List<Member>mList = mController.listMember();
			this.displayMemberList(mList);
			break;
		case 3:
			String memberID = this.inputMemberID();
			member = mController.printOneMember(memberID);
			this.displayOne(member);
			break;
		case 0:
			System.out.println("종료합니다.");
			break end;
		default:
			this.displayMsg("메뉴를 다시 선택해 주세요");
		}
	}
}
	public void displayMsg(String msg) {
		System.out.println(msg);
	}
	private String inputMemberID() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력: ");
		String memberID  = sc.next();
		return memberID;
	}
	private void displayOne(Member member) {
		System.out.println(" == 회원 정보 출력 ==");
		System.out.println("이름 : %s , 나이 :%s , 아이디: %s , 성별:%s , 이메일: %s, 전화번호 : %s , 주소: %s , 취미 :%s , 가입날짜 : %s\n ");
		
		member.getGender();
		member.getHobby();
		member.getMemberaddress();
		member.getMemberage();
		member.getMemberEmail();
		member.getMembername();
		member.getMemberID();
		member.getMemberPW();
		member.getPhone();
	}
	private Member inputMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====회원 정보 입력====");
		System.out.print("아이디: " );
		String MemberID = sc.next();
		System.out.print("비밀번호: ");
		String MemberPW = sc.next();
		System.out.print("이름: ");
		String MemberName = sc.next();		
		System.out.print("성별: ");
		String MemberGender = sc.next();
		System.out.print("이메일: ");
		String MemberEmail = sc.next();
		System.out.print("전화번호: ");
		String Memberphone = sc.next();
		System.out.print("주소: ");
		sc.nextLine();
		String Memberaddress = sc.next();
		System.out.print("취미: ");
		sc.nextLine();
		String Memberhobby = sc.nextLine();
		System.out.print("나이: ");
		String Memberage = sc.next();		
		Member member = new Member();
		member.setGender(MemberGender);
		member.setHobby(Memberhobby);
		member.setMemberaddress(Memberaddress);
		member.setMemberage(Memberage);
		member.setMemberEmail(MemberEmail);
		member.setMembername(MemberName);
		member.setMemberID(MemberID);
		member.setMemberPW(MemberPW);
		member.setPhone(Memberphone);
		
		return member;
	}
private int printMainMenu() {
	Scanner sc= new Scanner(System.in);
	System.out.println("===회원 관리 프로그램===");
	System.out.println("1.회원가입");
	System.out.println("2.회원 전체 조회");
	System.out.println("3.회원아이디로 조회");
	System.out.println("0.프로그램 종료");
	int value = sc.nextInt();
	
	return value;
}

public void displayMemberList(List<Member>mList) {
	System.out.println("==== 회원 정보 전체 출력 ====");
	for(Member member : mList) {
		System.out.printf("이름: %s\n", member.getMembername());
		System.out.printf("아이디: %s\n", member.getMemberID());
		System.out.printf("비밀번호: %s\n", member.getMemberPW());
		System.out.printf("이메일: %s\n", member.getMemberEmail());
		System.out.printf("성별: %s\n", member.getGender());
		System.out.printf("폰: %s\n", member.getPhone());
		System.out.printf("주소 %s\n" ,member.getMemberaddress());
		System.out.printf("나이 %d\n" ,member.getMemberage());
		System.out.printf("취미 %s\n" ,member.getHobby());
	}
}

}