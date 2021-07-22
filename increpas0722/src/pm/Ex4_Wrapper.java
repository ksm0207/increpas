package pm;

public class Ex4_Wrapper {
	public static void main(String[] args) {
		
		// 옛날 방법
		
		//=============================
		int a = 100;
		Integer i1 = new Integer(a);
		// i1 을 int 변환
		int a1 = i1.intValue();
		//==============================
		
		// 요즘 꺼
		
		// =============================
		Integer i2 = a; // AutoBoxing 방법 (자동 포장)
		int a2 = i2; // UnBoxing (자동 포장 해제 )
		//==============================
		
		
	}
}
