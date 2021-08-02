package CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(100);
		list.add(200);
		list.add(300);
		
		
		
		System.out.println("get() 메소드로 값 전체 출력하기");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("===================================");
		
		System.out.println("for-each 방식으로 값 전체 출력하기");
		for (int res : list) {
			System.out.println(res);
		}
		
		System.out.println("===================================");
		
		System.out.println("Iterator 사용해서 값 출력하기");
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		if(list.contains(100)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		System.out.println(list.indexOf(100));
		
		
		
		
	}
}
