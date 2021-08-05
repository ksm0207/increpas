package pm.Ex1;

public class Ex1_Final {
	
	// 인스턴스 변수 선언
	int value = 100;
	
	// 인스턴스 상수 선언
//	final int VALUE1 = 1;
	
	// 상수 선언 Static 영역에 올라간다
	static final int ADD = 1;
	static final int SEARCH = 2;
	static final int DELETE = 3;
	static final int TOTAL = 4;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public void exe() {
		if (value == Ex1_Final.ADD) {
			System.out.println("데이터를 추가하였습니다.");
			
		}else if (value == Ex1_Final.SEARCH) {
			System.out.println("검색 결과입니다.");
			
		}else if (value == Ex1_Final.DELETE) {
			System.out.println("데이터를 삭제하였습니다.");
			
		}else if (value == Ex1_Final.TOTAL) {
			System.out.println("전체 리스트 입니다.");
		}
	}
	
}// end of Final



