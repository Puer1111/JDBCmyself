package com.kh.jdbc.day03.pstmt.member.model.vo;

import java.sql.Date;

public class Member {
String MemberID;
String MemberPW;
String MemberName;
String gender;
int Age;
String email;
String phone;
String address;
String hobby;
private Date regDate;

public Date getRegDate() {
	return regDate;
}

public Member(String memberPW, String email, String phone, String address, String hobby) {
	super();
	MemberPW = memberPW;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.hobby = hobby;
}

public void setRegDate(Date regDate) {
	this.regDate = regDate;
}
public Member(String memberID, String memberPW, String memberName, String gender, int age, String email, String phone,
		String address, String hobby) {
	super();
	this.MemberID = memberID;
	this.MemberPW = memberPW;
	this.MemberName = memberName;
	this.gender = gender;
	this.Age = age;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.hobby = hobby;
}
public Member() {
}

public String getMemberID() {
	return MemberID;
}
public void setMemberID(String memberID) {
	MemberID = memberID;
}
public String getMemberPW() {
	return MemberPW;
}
public void setMemberPW(String memberPW) {
	MemberPW = memberPW;
}
public String getMemberName() {
	return MemberName;
}
public void setMemberName(String memberName) {
	MemberName = memberName;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
}
