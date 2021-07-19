package personal_study;

public class HeapTest {
	public static void main(String[] args) {
		
		int [] a = null ; // int 형 배열은 Stack 영역 공간에 할당된다
		System.out.println(a);
		
		a = new int [10]; // Heap 영역에 5개의 연속된 공간이 할당되고
		                  // 변수 a에 참조값을 할당했다
		
		System.out.println(a); // [I@7d6f77cc 참조값이 16진수로 나왔다 
	}
}
