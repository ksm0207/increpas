package increpas_example02;

public class ifEx3 {
	
	public String check(int value) {
		String res = "";
		
		if (value >= 41) {
			res = "고급";
		}else if(value >= 11) {
			res = "중급";
		}else if (value >= 0) {
			res = "초급";
		}else {
			res = "음수";
		}
		return res;
	}
	public static void main(String[] args) {
		ifEx3 i3 = new ifEx3();
		String res = i3.check(10);
		System.out.println(res + " 입니다 ");
	}
}
