
public class EqualsTest {
	String a;
	
	public void Another(String a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		EqualsTest a1 = new EqualsTest();
		EqualsTest a2 = new EqualsTest();
		
		String name1 = "Kim";
		a1.Another(name1);
		System.out.println(System.identityHashCode(a1));
	
		String name2 = "Nam";
		a2.Another(name2);
		System.out.println(System.identityHashCode(a2));
		System.out.println("=============================");
		
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		
		if (a1.equals(name1) && a2.equals(name2)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		if (name1.equals("Kim") == name2.equals("Nam")) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
}
