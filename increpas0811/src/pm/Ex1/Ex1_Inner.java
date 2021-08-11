package pm.Ex1;

public class Ex1_Inner {
	
	String msg;
	int value;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	class Inner{
		int su = 100;
		
		public void print() {
			
			System.out.println("Su : " + (su + value));
		}
	}
	
}

