package CollectionFramework;

import java.util.LinkedList;

public class LinkedListTest {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> data = new LinkedList<Integer>();
		
		data.addFirst(10); // Index 가장 앞의 데이터 추가
		data.addLast(20);  // Index 가장 뒤의 데이터 추가
		
		data.removeFirst(); // 가장 앞의 데이터 삭제
		data.removeLast();  // 가장 뒤의 데이터 삭제
		
		data.add(30);
		data.add(0,40);
		
		for (int res : data) {
			System.out.println(res);
		}
		
		System.out.println(data.size());
		System.out.println(data.contains(30));
		System.out.println(data.indexOf(30));
	}
}
