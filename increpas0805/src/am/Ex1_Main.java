package am;

public class Ex1_Main {

	public static void main(String[] args) {
		
// 		Static 선언된 멤버변수나 메소드 들이 있다
// 		해당 객체를 생성하지 않고도 직접 호출이 가능하다
		System.out.println(Ex1_Static.msg);
		System.out.println(Ex1_Static.b);
		Ex1_Static.staticPrint();
		
		System.out.println("=======================");
		
//		static으로 선언되지 않은 멤버들은 객체를 생성 후 사용한다
//		레퍼런스 변수로 Static 을 호출하는 것은 바람직하지 않음		
		Ex1_Static ex1 = new Ex1_Static();
		Ex1_Static ex2 = new Ex1_Static();
		Ex1_Static ex3 = new Ex1_Static();
		
		ex2.a = 1300;
		System.out.println("Ex1 객체 : " +ex1.a); // 100
		System.out.println("Ex2 객체 : "+ ex2.a); // 1300

//      정적 필드 Ex1_Static.b는 정적 방법으로 액세스해야 합니다.		
		ex2.b = 2500;
		System.out.println("Ex1.value2 : " + ex1.b);

		System.out.println("Ex1_Static.b : " + Ex1_Static.b);
		
		System.out.println("==============================");
		
		System.out.println(ex3.b);
		
	}
}
