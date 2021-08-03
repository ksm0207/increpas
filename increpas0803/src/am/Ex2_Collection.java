package am;

import java.util.HashSet;
import java.util.Iterator;

public class Ex2_Collection {
	public static void main(String[] args) {
		
		HashSet<String> data = new HashSet<String>();
		
		data.add("Test");
		data.add("ABC");
		data.add("Test");
		
		Iterator<String> iter = data.iterator();
		
		while(iter.hasNext()) {
			String res = iter.next();
			System.out.println(res);
		}
		
	}
}
