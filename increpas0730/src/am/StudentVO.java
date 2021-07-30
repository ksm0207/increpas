package am;

public class StudentVO{
	
	String number; // 학번
	String name;   // 이름
	MajorVO mvo;
	
	
//      현재클래스는 생성자를 하나도 정의하지 않았다.
//      이렇게 되면 컴파일러가 알아서 기본생성자를 아래와 같이 정의한다
//	    public StudentVO() {}
	
	public StudentVO() {
		// StudentVO() 객체가 생성될 때 MajorVO() 객체도 같이 생성된다
		mvo = new MajorVO();
	}
	
	public StudentVO(String number , String name) {
		mvo = new MajorVO();
		this.number = number;
		this.name = name;
	}
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	public MajorVO getMvo() {
		return mvo;
	}
	public void setMvo(MajorVO mvo) {
		this.mvo = mvo;
	}

}
