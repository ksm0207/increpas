package pm;

public class Main {
	
	public void testChild(Child n) {
		n.print();
	}
	
	public void testParent(Parent n) {
		n.print();
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		Child c = new Child();
		
		c.setData(100);
		main.testChild(c);
		main.testParent(c);
		
		// c안에 Object가 존재하는가 ?
		
		System.out.println(c instanceof Object);

	}
}
