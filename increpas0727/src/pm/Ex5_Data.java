package pm;

public class Ex5_Data {

	// 이름 전화번호
	String name;
	String phone;
	
	// name 이라는 변수의 값을 변경하는 동작
	public void setName(String n) {
		name = n;	
	}
	
	// name 의 값을 반환하는 동작
	public String getName() {
		return name;
	}
	
	// 전화번호를 변경하는 동작
	public void setPhone(String p) {
		phone = p;
	}
	
	// 전화번호 반환하는 동작
	public String getPhone() {
		return phone;
	}
}
