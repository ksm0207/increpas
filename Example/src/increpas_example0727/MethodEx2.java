package increpas_example0727;

public class MethodEx2 {
	
	int var;
	
	public void setInt(int var) {
		this.var = var;
	}
	
	public int getInt() {
		return var;
	}

	public static void main(String[] args) {
		MethodEx2 ex2 = new MethodEx2();
		
		ex2.setInt(1500);
		System.out.println("Var ===> " +ex2.getInt());
		
	}
}
