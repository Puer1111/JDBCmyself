package com.kh.jdbc.day02.stmt.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day02.stmt.member.model.vo.Member;
import com.kh.jdbc.day02.stmt.member.controller.MemberController;

public class MemberView {
	MemberController mController;

	public MemberView() {
		mController = new MemberController();
	}

	public void startProgram() {
		end:
		while (true) {
			int value = this.printMainMenu();
			switch (value) {
			case 1:
					Member member = this.inputMember();
					mController.insertMember(member);
				// 1일때 회원 정보 입력 받기
					break;
			case 2:
				// 회원 전체 정보 출력
				//1. db에서 데이터 가져오기
				List<Member>mList = mController.printAllMember();
				
				//2. view 의 메소드를 이용해서 출력하기
				this.printAllMembers(mList);
				break;
			case 3:
				//회원의 정보를 아이디로 검색해야함
				// 사용자가 검색한 아이디 입력 받아야 하니까 inputMember();
				String memberID = this.inputMemberID();
//				입력받은 아이디로DM에서 검색해야 하니 printOneMember();
//				컨트롤러로 전달해야하니 printOneMember(memberID);
				member = mController.printOneMember(memberID);
				this.printOneMember(member);
				break;
			case 4:
//				회원의 정보를 수정해야한다 (아이디로 정보가 존재하는지 확인 후 있으면 수정 없으면 X)
				memberID = this.inputMemberID();
//				전달 받은 입력 아이디 있는지 확인
				member = mController.printOneMember(memberID);
//				ID가 있는건지 체크 
				if(member!= null) {
//					수정할 땐 수정할 정보를 입력해야 하니 modifyMember(member)
//					수정할 정보를 가진 member객체가 필요
					Member modifyInfo =  this.inputModifyInfo();
//					UPDATE 할때는 중요한게 where 조건절이니까 where 에 들어갈 데이터를 전달해줘야함
					//modifyMember(modifyinfo)에서 modifyinfo에 memberID 를 넣어줘야한다. modifyinfo.setID(ID)필요.
					modifyInfo.setID(memberID);
					int result = mController.modifyMember(modifyInfo); 
					if(result>0) {
						this.displayMessage("수정 성공");
					}
					else {
						this.displayMessage("수정 실패");
					}
				}else {
					this.displayMessage("존재하지 않는 정보입니다");
				}
				
				break;
			case 5:
				// 회원의 정보를 삭제 해야함
				// 사용자가 검색한 아이디 입력 받아야 하니까 inputMember();
				memberID = this.inputMemberID();
				if(memberID != null) {
					int result = mController.deleteMember(memberID);
					if(result > 0) {
						this.displayMessage("삭제 성공");
					}
					else {
						this.displayMessage("삭제 실패");
					}					
				}
				else {
					this.displayMessage("존재하지 않는 정보입니다.");
				}
//				입력받은 아이디로DB에서 제거해야 하니 deleteOneMember();
//				DML의 결과는 int 니까 int result
				break;
			case 0:
				break end;
		
			}
		}
	}

	private Member inputModifyInfo() {
		Scanner sc = new Scanner(System.in);

		System.out.print("비밀번호: ");
		String PW = sc.next();
		System.out.print("이메일: ");
		String email = sc.next();
		System.out.print("취미: ");
		String hobby = sc.next();
		System.out.print("폰: ");
		String phone = sc.nextLine();
		sc.nextLine();
		System.out.print("주소: ");
		String address = sc.nextLine();
		
		Member member = new Member();
	
		member.setPW(PW);
		member.setEmail(email);
		member.setHobby(hobby);
		member.setPhone(phone);
		member.setAddress(address);
		
		return member;
	}

	private void displayMessage(String Message) {
		System.out.println("[서비스 결과] : " + Message);
		
	}


	private void printOneMember(Member member) {
		System.out.println(" == 회원 정보 출력 ==");
		System.out.printf("아이디: %s\t" + "비밀번호 : %s\t" + "이름 : %s\t"+"성 : %s\t " + " 나이: %d\t"+ "이메일: %s\t"+"취미: %s\t"+"폰: %s\t"+"주소 :%s\t\n",
		member.getID(),
		member.getPW(),
		member.getName(),
		member.getGender(),
		member.getAge(),
		member.getEmail(),
		member.getHobby(),
		member.getPhone(),
		member.getAddress()
		);
		
	}

	private String inputMemberID() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String ID = sc.next();
		return ID;
	}

	private void printAllMembers(List<Member> mList) {
		System.out.println(" == 회원 정보 출력 ==");
		for(Member member : mList)
		System.out.printf("아이디: %s \t " + "비밀번호 : %s \t" + "이름 : %s \t"+"성 : %s\t " + " 나이: %d \t"+ "이메일: %s \t"+"취미: %s \t"+"폰: %s \t"+"주소 :%s \t\n",
		member.getID(),
		member.getPW(),
		member.getName(),
		member.getGender(),
		member.getAge(),
		member.getEmail(),
		member.getHobby(),
		member.getPhone(),
		member.getAddress()
		);
	}

	private Member inputMember() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디: ");
		String ID = sc.next();
		System.out.print("비밀번호: ");
		String PW = sc.next();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("성: ");
		String Gender = sc.next();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("이메일: ");
		String email = sc.next();
		System.out.print("취미: ");
		String hobby = sc.next();
		System.out.print("폰: ");
		String phone = sc.nextLine();
		sc.nextLine();
		System.out.print("주소: ");
		String address = sc.nextLine();
		
		Member member = new Member();
		member.setID(ID);
		member.setPW(PW);
		member.setName(name);
		member.setGender(Gender);
		member.setAge(age);
		member.setEmail(email);
		member.setHobby(hobby);
		member.setPhone(phone);
		member.setAddress(address);
		
		return member;
		
	}

	public int printMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====회원 관리 프로그램====");
		System.out.println("1. 회원가입 ");
		System.out.println("2. 전체 회원조회 ");
		System.out.println("3. 회원 아이디로 조회 ");
		System.out.println("4. 회원 정보 수정 ");
		System.out.println("5. 회원 탈퇴 ");
		System.out.println("0. 종료 ");
		System.out.println(" 메뉴 선택 ");
		int choice = sc.nextInt();
		return choice;
	}

}
