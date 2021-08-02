package Collection;

public class GenericsArrayList<T> {

	private Object[] element = new Object[3];
	private int size;
	
	public void add(Object value) {
		element[size++] = value;
	}
	
	public T get(int idx) {
		return (T) element[idx];
	}
}
