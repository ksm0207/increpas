package pm;

import java.util.ArrayList;

public class Ex3_List {
	
	public static void main(String[] args) {
		
		// Integer 객체자료형
		ArrayList<Integer> getInt = new ArrayList<Integer>();
		
		for (int i=0; i<10; i++) {
			getInt.add(i+1);
		}
		
		System.out.println("Print() :  ====> "+getInt.size()); // 10
		
		
			
		getInt.remove(1);
		System.out.println("remove(1): ====> "+getInt.size()); // 9
		
		for(int i=0; i<getInt.size(); i++) {
//			getInt에서 하나씩 가져오기
			Integer e = getInt.get(i);
			System.out.printf("%-2d",e);
		}
		
		System.out.println();
		
		// index , element
		getInt.add(1, 2);
		
		for(int res : getInt) {
			System.out.printf("%-2d",res);
		}
		System.out.println();
		
		int findIndex = getInt.indexOf(5);
		System.out.println("getInt.indexOf(5) ==== > "+ findIndex);
		
		// 값이 비어있는가?
		if(getInt.isEmpty()) {
			System.out.println("isEmpty() : ==> "+true);
		}else {
			System.out.println("isEmpty() : ==> " +false);
		}
		
		// 모두 삭제.
		getInt.clear();
		
		// 값이 비어있는가?
		if(getInt.isEmpty()) {
			System.out.println("isEmpty() : == > "+true);
		}else {
			System.out.println("isEmpty() : ==> " +false);
		}
		
		System.out.println("getInt.size() : == > "+getInt.size());
	}
}
