package class_study;

public class StringExample {
	public static void main(String[] args) {
		
		String name1 = "Kim";
		String name2 = "Kim";
		String name3 = new String("Kim");
		
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		System.out.println(System.identityHashCode(name3));
		
		if (name1 == name2) {
			System.out.println(name1 == name2);
		}else {
			System.out.println(name1 == name2);
		}
		
		if (name1 == name3) {
			System.out.println(name1 == name3);
		}else {
			System.out.println(name1 == name3);
		}
		
	}
}
