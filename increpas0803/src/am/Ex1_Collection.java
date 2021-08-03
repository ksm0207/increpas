package am;

import java.util.ArrayList;
import java.util.Vector;

public class Ex1_Collection {
	
	public static void main(String[] args) {
		
		//
		Vector<String> data = new Vector<String>();
		
		data.add("Test");
		System.out.println("data.size(1번지): "+ data.size()); // 1
		
		data.addElement("ABC");
		System.out.println("data.size(2번지): "+ data.size()); // 2
		
		data.add("ABC");
		System.out.println("data.size(3번지): "+ data.size()); // 3
		
		data.add("Test");
		System.out.println("data.size(4번지): "+ data.size()); // 4
		
		// 순차적으로 빠른 요소를 지운다
		data.removeElement("Test");
	
		for(String res : data) {
			System.out.println(res);
		}
		
		System.out.println("==============================");
		
//		Vector --> ArrayList 합치기
		
		ArrayList<String> data2 = new ArrayList<String>();
		
		data2.add("A1");
		data2.add("A2");
		data2.add("A3");
		
		data.addAll(1,data2);
		
		for(String res : data2) {
			System.out.println(res);
		}
		
		
	}
}
