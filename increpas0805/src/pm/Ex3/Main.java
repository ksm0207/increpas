package pm.Ex3;

public class Main {
	
	public void getResult(ChildOne c1 , ChildTwo c2) {
		
		System.out.println("이름 : " +c1.getName());
		System.out.println("지급 금액 : "+c1.getValue() + "원 ");
		System.out.println("은행 지점 : " + c1.getBank());
		
		System.out.println("==================================");
		
		System.out.println("이름 : " +c2.getName());
		System.out.println("지급 금액 : "+c2.getValue() + "원 ");
		System.out.println("은행 지점 : " + c2.getBank());
	}

	
	public static void main(String[] args) {
		
		ChildOne c1 = new ChildOne();
		ChildTwo c2 = new ChildTwo();
		
		Main main = new Main();
		
		main.getResult(c1,c2);
		
		
		
		
		
		

	}
	
	
}
