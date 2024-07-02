package com.kh.jdbc.day04.pstmt.common;

public class Singleton {
// 싱글 톤 반드는 법  static 이면서 클래스명과 동일한 멤버 변수 필요
	private static Singleton instance;

// static 이면서 public 이고 리턴타입이 Singleton 인 메소드 필요
// 메소드 안에서는 if문으로 NULL체크 후 없으면 객체 생성
// 있으면 그대로 리턴.
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
	}
}
