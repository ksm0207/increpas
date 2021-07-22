package am;

public class Ex2_String {
	public static void main(String[] args) {
		
		// 암시적 : 객체의 재사용 + 메모리효율성으로 좋다
		// Strinjg 은 한번 들어간 값은 못바꾸게 만들었다.
		//불변적 특징이라고 한다.
		
		String str = "INCREPAS!"; 
		String str2 = "INCREPAS!";
			
		if (str == str2) {
			System.out.println("같은 주소입니다");
		}else {
			System.out.println("다른 주소입니다");
		}
		
		
		// str을 통해 값을 변경해보자
		// str이 가리키는 문자열에서 '!' 를 '#' 으로 변경한다
		str.replace("!", "#");
		
		System.out.println(str.replace("!", "#") == str2); 
		
		// replace를 호출하여 변경된 문자열을 str이
		// 받은 주소 이후의 주소값 비교
		
		if (str == str2) {
			System.out.println("같은 주소입니다");
		}else {
			System.out.println("다른 주소입니다");
		}
		
		
	}
}
