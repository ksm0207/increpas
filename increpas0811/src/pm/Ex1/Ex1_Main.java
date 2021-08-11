package pm.Ex1;

import pm.Ex1.Ex1_Inner.Inner;

public class Ex1_Main {

	public static void main(String[] args) {
		
		/* 멤버 내부 클래스 */
		
		Ex1_Inner outer = new Ex1_Inner();
		
		Inner in = outer.new Inner();
		in.print();
	}
	
}
