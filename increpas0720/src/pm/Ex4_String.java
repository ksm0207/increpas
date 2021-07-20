package pm;

public class Ex4_String {
	public static void main(String[] args) {
		String str = "INCREPAS!";
		
		// 문제 1. str length() 길이를 구하세요
		System.out.println("str.length() = " + str.length());
		
		// 문제 2. str 2번지부터 3자를 추출하여 출력하세요
		System.out.println(str.substring(2,5));
		
		// 문제 3. str 에서 '!' 를 찾아 '#' 으로 변경하세요
		System.out.println(str +" ==> "+str.replace('!', '#'));
		
		// 문제 4. str에서 A의 인덱스 위치값을 찾으세요
		System.out.println("A 위치 : "+str.indexOf("A"));
//		System.out.println("A 위치 : "+str.indexOf('A'));
//		System.out.println("A 위치 : "+str.indexOf(65));
	}
}