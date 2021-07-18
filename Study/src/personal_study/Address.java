package personal_study;

public class Address {
	
	String res = "";
	
	public Address(String res) {
		this.res = res;
	}

	
	
	public static void main(String[] args) {
		// 1. 개인 공부 - 객체 주소값 확인해보기
		
		Address ad1 = new Address("Kim");
		Address ad2 = new Address("Nam");
		
		ad1 = null;
		
		System.out.println(ad1);
		System.out.println(System.identityHashCode(ad1));
		
		System.out.println("============================");
		
		System.out.println(ad2);
		System.out.println(System.identityHashCode(ad2));
		
		
		
		System.out.println(ad1);
	}

}
