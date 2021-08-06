package am;

public class Ex1_Main {
	
	public static void main(String[] args) {
	
		Ex1_Inter inter = new Ex1_InterTest();
		
		
//		inter의 참조는 Ex1_Inter를 하고있지만 print() 메소드가
//		Ex1_InterTest에서 재정의를 하여 숨겨진 상태가 된다
//		호출 시 Ex1_InterTest에 있는 print()가 호출된다.
		inter.print();
	}

}
