package increpas_example02;

public class ifEx1 {
	
	
	public String check(int value) {
		String res = "";
		
		if (value >= 50) {
			res = "50이상";
		}
		return res;
	}
	
	public static void main(String[] args) {
	
		ifEx1 i1 = new ifEx1();
		String res = i1.check(51);
		
		System.out.println(res + " 입니다.");
	}
}
