package increpas_example02;

public class ifEx2 {
	
	
	public String check(int value) {
		String res = "";
		
		if (value >= 50) {
			res = "50이상";
		}else {
			res = "50미만";
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		
		ifEx2 i2 = new ifEx2();
		String res = i2.check(51);

		System.out.println(res + " 입니다.");
		
	}
}
