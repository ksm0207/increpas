package personal_study;

public class Variables {
    
	// 전역변수 
	int globalInteger;
	String globalString;
	double globalDouble;
	
	
	public void getInfo() {
		// 메소드안에 생성되는 지역변수
		String localString ="";
	}
	
	public void sum(int x , int y) {
		globalInteger = x + y;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("sum = "+ globalInteger);
	}
	
	public static void main(String[] args) {
		Variables var = new Variables();
		var.sum(10, 20);
		
		System.out.println("result = " +var.globalInteger);
	}
}
