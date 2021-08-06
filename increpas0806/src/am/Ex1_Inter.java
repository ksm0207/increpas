package am;

public interface Ex1_Inter {

	// 상수만 정의됨.
	int data = 100;
	
	// 자식클래스에서 재정의되면 메소드들은 숨겨진다.
	public void print();
	
	public int getData(int n);
	
	
	
}
