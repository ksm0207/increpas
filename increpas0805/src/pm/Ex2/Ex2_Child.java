package pm.Ex2;

public class Ex2_Child extends Ex2_Abs{

	// Ex2_Abs의 모든 멤버들을 상속받았다.
	// getData 라는 메소드에서 200을 반환하는 것이 아닌
	// 아래의 변수값을 곱해서 반환해야 한다.
	
	int su = 3;
	
	// 부모메소드 재정의
	// ↓ 어노테이션 선언한 메서드가 오버라이드 되었다는 것을 나타낸다.
	@Override 
	public int getData() {
		return VAL * su;
	}
}
