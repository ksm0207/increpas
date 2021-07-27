package pm;

public class Ex2_Main {
	
	// test 함수를 호출하려면 반드시 Ex2_value 객체의
	// 주소를 호출해야한다
	public void test(Ex2_Value ex2) {
		ex2.setValue("Hello");
	}

	public static void main(String[] args) {
		Ex2_Value ex2 = new Ex2_Value();
		Ex2_Main e_main = new Ex2_Main();
		
		e_main.test(ex2);
		ex2.print();
		

	}
}
