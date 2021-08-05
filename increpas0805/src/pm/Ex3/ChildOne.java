package pm.Ex3;

public class ChildOne extends Parent {

	int a = 100;
	String name;
	String bank;
	
	@Override
	public int getValue() {
		System.out.println("자식 클래스 (1) 호출");
		return a * VALUE;
	}

	@Override
	public String getName() {
		name = "Kim";
		return name;
	}

	@Override
	public String getBank() {
		bank = "KB국민은행";
		return bank;
	}

	

}
