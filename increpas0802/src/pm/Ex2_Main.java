package pm;

public class Ex2_Main {
	public static void main(String[] args) {
		
		// gen_str =>은 String 객체만 받는다.
		
		Ex2_Gen<String> gen_str = new Ex2_Gen<String>();
		
		gen_str.setValue("String");
		System.out.println(gen_str.getValue());
		System.out.println(gen_str.hashCode());
		
		// Integer 객체자료형을 받는다
		
		Ex2_Gen<Integer> gen_int = new Ex2_Gen<Integer>();
		gen_int.setValue(50);
		System.out.println(gen_int.getValue());
		System.out.println(gen_int.hashCode());
		
	}
}
