package pm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Ex6_Lotto {
	public static void main(String[] args) {
		
		TreeSet<Integer> items = new TreeSet<>();
	
		
		
		while(items.size() < 6) {
			items.add((int)(Math.random()*45)+1);
		}	
		
		
		
		Iterator<Integer> iter = items.iterator();
		
		while(iter.hasNext()) {
			int res = iter.next();	
			System.out.printf("%-4d" , res);
		}
		
	
		
	}
}
