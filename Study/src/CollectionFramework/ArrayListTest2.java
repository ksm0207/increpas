package CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListTest2 {
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.print("Array length : ");
		
		int length = scan.nextInt();
		int value; 
		
		for(int i=0; i<length; i++) {
			value = scan.nextInt();
			list.add(value);
		}
		System.out.println("==================");
		
		Collections.sort(list);
		
		for(int res : list) {
			System.out.println(res);
		}
	}
}
