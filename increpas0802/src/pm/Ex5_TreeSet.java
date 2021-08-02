package pm;

import java.util.Iterator;
import java.util.TreeSet;

public class Ex5_TreeSet {
	
	public static void main(String[] args) {
		
		TreeSet<Integer> getInt = new TreeSet<Integer>();
		int res ;
		
		getInt.add(26);
		getInt.add(13);
		getInt.add(7);
		getInt.add(4);
		getInt.add(8);
		getInt.add(41);
		
	
		Iterator<Integer> iter = getInt.iterator();
		
		while(iter.hasNext()) {
			res = iter.next();	
			System.out.printf("%-3d" , res);
		}
		
		
	}
}
