package am;

public class StudentVO{
	
	String number; // 학번
	String name;   // 이름
	MajorVO mvo;
	
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
