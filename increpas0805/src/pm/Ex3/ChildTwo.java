package pm.Ex3;

public class ChildTwo extends Parent {
	
	int a = 200;
	String name;
	String bank;

	@Override
	public int getValue() {
		System.out.println("자식클래스 (2) 호출");
		return a * VALUE;
	}

	@Override
	public String getName() {
		name = "Nam";
		return name;
	}

	@Override
	public String getBank() {
		bank = "IBK기업은행";
		return bank;
	}
	

}
