package personal_study;

public class CallbyReferenceTest {
	
	static void swap(Numbers first, Numbers last) {
		int temp;	// 임시 변수
		
		temp = first.num; // 10
		first.num = last.num; // 20
		last.num = temp; // 10
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numbers first = new Numbers(10);
		Numbers last = new Numbers(20);
		
		System.out.println("Swap 전 ");
		System.out.println("first = " + first.num);
		System.out.println("last = " + last.num);
		System.out.println("===================");
		
		
		swap(first, last);
		
		System.out.println("===================");
		System.out.println("Swap 후 ");
		System.out.println("first = " + first.num);
		System.out.println("last = " + last.num);
	}
	
	// 자리 바꾸기 메소드
	
}

class Numbers {
	int num;
	
	Numbers (int num) {
		this.num = num;
	}
}


