package Collection;

public class IntegerDataTypes {
	public static void main(String[] args) {
		
		GenericsArrayList<Integer> data = new GenericsArrayList<Integer>();
		
		data.add(100);
		data.add(200);
		data.add(300);
		
		int A = data.get(0);
		int B = data.get(1);
		int C = data.get(2);
		
		System.out.println( (A + B) + C );
		
	}
}
