package example0729;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Library library = new Library();
		Scanner scan = new Scanner(System.in);
		library.initBooks();
		
		System.out.print("도서명 검색 :");
		String find = scan.next();
			
		library.getFindBooks(find);
		
		
	}

}
