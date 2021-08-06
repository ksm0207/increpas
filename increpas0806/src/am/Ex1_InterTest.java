package am;

public class Ex1_InterTest implements Ex1_Inter {

	int v = 100;

	@Override
	public void print() {
		System.out.println("인터페이스");
	}
	
	@Override
	public int getData(int n) {
		// TODO Auto-generated method stub
		return n + v;
	}
	
}
