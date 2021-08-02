package pm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Ex6_Lotto {
	public static void main(String[] args) {
		
		Ex6_Lotto ex6 = new Ex6_Lotto();
		ex6.getPrint();
		
	}
	private void getPrint() {
		TreeSet<Integer> items = new TreeSet<>();
		int rand;
		
		while(items.size() < 6) {
			rand = (int)(Math.random()* 45)+1;
			items.add(rand);
		}	
		
		Iterator<Integer> iter = items.iterator();
		
		while(iter.hasNext()) {
			int res = iter.next();	
			System.out.printf("%-4d" , res);
		}
	}
}
