package com.kh.jdbc.day01.stmt.member.model.vo;

import java.sql.Date;

public class Member {
private String Membername;
private String MemberID;
private String MemberPW;
private String MemberEmail;
private String Memberage;
private Date reg_date;
private String gender;
private String Memberaddress;
private String hobby;
private String phone;


public String getMembername() {
	return Membername;
}
public void setMembername(String membername) {
	this.Membername = membername;
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
public String getMemberEmail() {
	return MemberEmail;
}
public void setMemberEmail(String memberEmail) {
	MemberEmail = memberEmail;
}
public String getMemberage() {
	return Memberage;
}
public void setMemberage(String memberage) {
	Memberage = memberage;
}
public Date getReg_date() {
	return reg_date;
}
public void setReg_date(Date reg_date) {
	this.reg_date = reg_date;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMemberaddress() {
	return Memberaddress;
}
public void setMemberaddress(String memberaddress) {
	this.Memberaddress = memberaddress;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Member [Membername=" + Membername + ", MemberID=" + MemberID + ", MemberPW=" + MemberPW + ", MemberEmail="
			+ MemberEmail + ", Memberage=" + Memberage + ", reg_date=" + reg_date + ", gender=" + gender
			+ ", Memberaddress=" + Memberaddress + ", hobby=" + hobby + ", phone=" + phone + "]";
}
public void setID(String iD) {
	// TODO Auto-generated method stub
	
}



}