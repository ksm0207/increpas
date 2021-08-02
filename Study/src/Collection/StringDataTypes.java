package Collection;

public class StringDataTypes {
	
	public static void main(String[] args) {
		GenericsArrayList<String> data = new GenericsArrayList<String>();
		
		data.add("10");
		data.add("20");
		data.add("30");
		
		String A = data.get(0);
		String B = data.get(1);
		String C = data.get(2);
		
		System.out.println( (A + B) + C);

	}
}
