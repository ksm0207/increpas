package am;

public class EX4_Exception {
	public static void main(String[] args) {
		EX4_Exception ex4 = new EX4_Exception();
		
		System.out.println(ex4.test());
	}
	
	private boolean test() {
		
		boolean flag = false;
		
		try {
			System.out.println(10/3);
			return flag;
		} catch (Exception e) {
			System.out.println("예외 발생!");
		} finally {
			System.out.println("Finally !");
		}
		
		return true;
	}
}
