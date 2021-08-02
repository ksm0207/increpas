package Collection;

public class GenericsExample {
	
	private int size;
	private Object[] element = new Object[2];
	
	public void add(Object value) {
		element[size++] = value;
	}
	
	public Object get(int idx) {
		return element[idx];
	}
	
	public static void main(String[] args) {
		GenericsExample generics = new GenericsExample();
		
		generics.add("300");
		generics.add("200");
		
		Integer x = (Integer) generics.get(0);
		Integer y = (Integer) generics.get(1);
		
		System.out.println( x + y );
		
	}
	
	
}
