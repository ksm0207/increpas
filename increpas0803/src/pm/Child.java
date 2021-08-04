package pm;

public class Child extends Parent{
	
	String value = "Child";
	int data ;
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	// 부모의 동작 중 같은 동작을 다시 정의 해보자
	// 오버라이딩 - 메소드 재정의 기능

	@Override
	public void print() {
		System.out.println(value +" :"+" Data = " + data);
	}

}
