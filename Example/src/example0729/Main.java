package example0729;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Library library = new Library();
		Scanner scan = new Scanner(System.in);
		library.initBooks();
		
		boolean check = false;
		String getRentalList = "";
		
		System.out.print("도서명 검색 :");
		String find = scan.next();
			
		library.getFindBooks(find);
		// 07/30 : 이제 대여가능한 도서들 검색도 하기
		
		getRentalList = library.isRental(find);
		System.out.println(getRentalList);
		
			
		
		
	}

}
