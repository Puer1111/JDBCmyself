package com.kh.jdbc.day04.pstmt.employee.model.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day04.pstmt.employee.controller.EmployeeController;
import com.kh.jdbc.day04.pstmt.employee.model.vo.Employee;

public class EmployeeView {
	EmployeeController empController;
public EmployeeView() {
	empController = new EmployeeController();
}
	public void startApp() {
		
		end: 
			while (true) {
			int menu = mainMenu();
			switch (menu) {
			case 1:
				List<Employee>eList = empController.printAllEmp(); 
				this.showAllEmp(eList);
				break;
			case 2:
				Employee emp = inputEmpInfo();
				int result = empController.insertEmployee(emp);
				if(result>0) {
					printMessage("등록 성공");
				}else {
					printMessage("등록 실패");
				}
				break;
			case 3:
				String empId = inputEmpId();
				emp = empController.selectOneById(empId);
				if(emp!= null) {
				emp = modifyEmpInfo();
				emp.setEmpId(empId);
//				정보수정
				result = empController.updateEmployee(emp);
					if(result>0) {
						printMessage("수정 성공");
					}else {
						printMessage("수정 실패");
					}
				}
				
				else {
					printMessage("존재하지 않습니다.");
				}
				break;
			case 4:
				empId = inputEmpId();
				result = empController.deleteEmployee(empId);
				if(result > 0) {
					printMessage("삭제 성공");
				}else {
					printMessage("삭제 실패");
				}
				break;
			case 5:
				break;
			case 0:
				printMessage("프로그램이 종료 되었습니다.");
				break end;
			}

		}

	}

	private Employee modifyEmpInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=======사원 정보 수정 ========");
		System.out.println("이메일: ");
		String Email = sc.next();
		System.out.println("전화번호: ");
		String phone = sc.next();
		System.out.println("부서코드: ");
		String deptcode = sc.next();
		System.out.println("급여: ");
		int salary = sc.nextInt();
		System.out.println("보너스율: ");
		double bonus = sc.nextDouble();
		System.out.println("관리자: ");
		String managerId = sc.next();
		Employee emp = new Employee();
		emp.setEmail(Email);
		emp.setPhone(phone);
		emp.setDeptCode(deptcode);
		emp.setSalary(salary);
		emp.setBonus(bonus);
		emp.setManagerId(managerId);
		
		return emp;
	}
	private String inputEmpId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("사번 입력: ");
		
		return sc.next();
	}
	private Employee inputEmpInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======사원 정보 등록======");
		System.out.print("사번: ");
		String EmpId = sc.next();
		System.out.print("사원명: ");
		String EmpName = sc.next();
		System.out.println("주민등록번호: ");
		String EmpNo = sc.next();
		System.out.println("직급 코드: ");
		String JobCode = sc.next();
		System.out.println("급여 등급: ");
		String SalLevel = sc.next();
		
		Employee emp = new Employee();
		emp.setEmpId(EmpId);
		emp.setEmpName(EmpName);
		emp.setEmpNo(EmpNo);
		emp.setJobCode(JobCode);
		emp.setSallevel(SalLevel);
		return emp;
	}
	private void showAllEmp(List<Employee> eList) {
		System.out.println("=====사원 정보 전체 출력=====");
		for(Employee emp : eList) {
			System.out.printf("직원명: %s , 사번 : %s , 이메일: %s , 전화번호: %s , 입사일자: %s , 퇴직여부: %s\n",
					emp.getEmpName(),emp.getEmpId(),emp.getEmail(),emp.getPhone(),emp.getHireDate(),emp.getEntyn());
		}
		
	}
	private void printMessage(String msg) {
		System.out.println("[결과]:" + msg);}

	private int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====사원관리 프로그램=====");
		System.out.println("1. 사원 전체 출력");
		System.out.println("2. 사원 등록");
		System.out.println("3. 사원 정보 수정");
		System.out.println("4. 사원 삭제");
		System.out.println("0. 종료");
		System.out.println("메뉴 선택: ");
		int choice = sc.nextInt();
		return choice;
	}

}
