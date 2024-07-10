package org.kh.library.model.vo;

import java.sql.Date;

public class Customer {
private	int userno;
private String userID;
private String username;
private int userage;
private String addr;
private String gender;
private Date enrolldate;
public int getUserno() {
	return userno;
}
public void setUserno(int userno) {
	this.userno = userno;
}
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getUserage() {
	return userage;
}
public void setUserage(int userage) {
	this.userage = userage;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Date getEnrolldate() {
	return enrolldate;
}
public void setEnrolldate(Date enrolldate) {
	this.enrolldate = enrolldate;
}
@Override
public String toString() {
	return "Customer [userno=" + userno + ", userID=" + userID + ", username=" + username + ", userage=" + userage
			+ ", addr=" + addr + ", gender=" + gender + ", enrolldate=" + enrolldate + "]";
}

}
