package pm.Ex2;

public abstract class Ex2_Abs {
	
	int value = 100;
	
	static final int VAL = 200; 

	public int getValue() {
		return value;
	}
	
	// 추상메소드 - 자식 클래스들의 움직임이 통일되지 않을 때
	// 자식클래스들이 직접 구현하도록 만드는 기술
	public abstract int getData(); 
	
	// ※ 추상메소드를 단 하나라도 가지고 있으면 클래스는 추상클래스여야 함
	
}
