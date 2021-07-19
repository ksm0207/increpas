package personal_study;

public class HeapTest2 {
	public static void main(String[] args) {
		
		String add1 = new String("Kim");
		String add2 = new String("Kim");
		
		if (add1 == add2) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		System.out.println("add1 의 주소값 : " +System.identityHashCode(add1));
		System.out.println("add2 의 주소값 : " +System.identityHashCode(add2));
	}
}
