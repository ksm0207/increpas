package am;

public class Parent {
	
	String value;
	
//	public Parent() {
//		System.out.println("Parent Class ");
//	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void getPrint(int n) {
		for(int i=0; i<n; i++) {
			System.out.printf("%s",value);
		}
		System.out.println();
	}
	
	
	public void childPrint() {
		System.out.println("Parent 의 ChildPrint() 호출 ");
	}

	
}
