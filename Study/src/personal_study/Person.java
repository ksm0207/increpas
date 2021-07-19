package personal_study;


class T {
	
}

public class Person {

	 
	
	public static void main(String[] args) {
	    T t = null;	// T 타입의 t 객체를 선언하였다
					// Stack 영역 공간에 할당된다
		
	    System.out.println(t); // null
	    
	    t = new T() ; // new 연산자를 통해 객체가 생성된다
	                  // Heap 영역에 공간이 할당되며 객체 t에
	                  // 참조값을 할당했다 ( = new T() )
	    
	    System.out.println(t); // @5aaa6d82 참조값
	}
}
