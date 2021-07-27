package am;

import java.util.Scanner;

public class Ex1_Class {
	
//	멤버변수 선언
	int value;
	
//	          멤버메소드 선언
	
	// 1. 호출될 때마다 1씩 증가하는 메소드
	public void inc() {
		value ++;
	}
	
	// 2. 호출하면 value를 반환하는 메소드
	public int getReturnValue() {
		return value;
	}
	
	// 3. 호출하면 정수를 하나 받아서 value 와 비교하여
	// value 보다 크면 크다를 반환하고
	// 작으면 작다를 반환하고
	// 같으면 같다를 반환해라.

	 public String check(int x) {
		
		String res = "";
		
		if (x > value) {
			res = "X 는 Value 보다 크다";
		}else if (x < value) {
			res = "X 는 Value 보다 작다";
		}else {
			res = "X 는 Value 보다 같다";
		}
		return res;
	}
}
