package class_study;

public class StringExample {
	public static void main(String[] args) {
		
		String name1 = "Kim";
		String name2 = "Kim";
		String name3 = new String("Kim");
		
		
		if (name1 == name2) {
			System.out.println("name 1 과 name2 는 주소가 같다." + true);
		}else {
			System.out.println("name 1 과 name2 는 주소가 다르다." + false);
		}
		
		if (name1 == name3) {
			System.out.println("name 1 과 name3 는 주소가 같다." + true);
		}else {
			System.out.println("name 1 과 name2 는 주소가 다르다." + false);
		}

		if (name1.equals(name2)) {
			System.out.println("문자열 내용이 같다." + true);
		}else {
			System.out.print("문자열 내용이 다르다 " + false);
		}
		
		if (name1.equals(name3)) {
			System.out.println("문자열 내용이 같다." + true);
		}else {
			System.out.print("문자열 내용이 다르다 " + false);
		}
		
		String name4 = new String("커피");
		String name5 = new String("커피");
		
		if(name4.equals(name5))
			System.out.println(true);
		else 
			System.out.println(false);
		
		String coffee = "Ediya";
		coffee = "Kanu";
		System.out.println(coffee);
		
		for (int i = 0 ; i < 10;  i ++) {
			String test = "안녕하세요?";
			System.out.println(test);
		}
		
		
	}
}
