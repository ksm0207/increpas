package personal_study;

class Random {
	
	int[] random;
	
	public void setRandom(int[] random) {
		this.random = random;
	}
	
	public int[] getRandom() {
		return random;
	}
	
}
public class Test {
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] rand = new int [5];
				
		for (int i=0 ; i < rand.length; i++) {
			rand[i]=(int)(Math.random()*9 +1);
			random.setRandom(rand);
		}
		for (int i=0; i<rand.length; i++) {
			System.out.println(rand[i]);
		}
		
	}

}
