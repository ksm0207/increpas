package Inheritance;

public class UserAddr {
	
	public static void main(String[] args) {
		
		AddressUser getUser = new AddressUser("서울");
		ScoreUser getScore = new ScoreUser();
		
		getUser.setName("Kim");
		getUser.setAge(27);
		getUser.setGender("Man");
	
		System.out.println("이름 : " + getUser.getName());
		System.out.println("나이 : " + getUser.getAge());
		System.out.println("성별 : " + getUser.getGender());
		System.out.println("주소 : " + getUser.getAddress());
		System.out.println("총점 : " + getScore.sum(100, 85, 90, 77));
	}
}
