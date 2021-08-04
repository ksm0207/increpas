package Inheritance;

class Ex4Value {
	
	private int a = 10;
	private int b = 20;
	private int c = 30;
	
	void setA(int a) {
		this.a = a;
	}
	protected void setB(int b) {
		this.b = b;
	}
	
	private void setC(int c) {
		this.c = c;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;
	}
	
} // end of Ex4Value class

class Ex4Test extends Ex4Value{
	String testM; // Default
	
	public String getTestM() {
		return testM;
	}
	
	public void setTestM(String testM) {
		this.testM = testM;
	}
	
}// end of Ex4Test class

public class Ex4 {
	
	public static void main(String[] args) {
		
		Ex4Test run = new Ex4Test();
		
		run.setA(1120);
		run.setB(1150);
		run.setTestM("Result");
		
		System.out.println(run.getTestM() + " : " + run.getA() + " " + run.getB());
		
	}
}
