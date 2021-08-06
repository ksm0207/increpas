package InterFace.Student;

public class Student extends School implements Score {

	String name;
	int sum;
	int kor;
	int math;
	int eng;
	int science;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int korScore() {
		// TODO Auto-generated method stub
		return kor;
	}
	@Override
	public int mathScore() {
		// TODO Auto-generated method stub
		return math;
	}
	@Override
	public int engScore() {
		// TODO Auto-generated method stub
		return eng;
	}
	@Override
	public int scienceScore() {
		// TODO Auto-generated method stub
		return science;
	}
	
	
	/* InterFace */
	
	@Override
	public int score() {
		return (korScore() + mathScore()) + (engScore() + scienceScore());
	}
	
	@Override
	public double avg() {
		sum = score();
		sum /=4;
		return sum;
	}
	
	
	/* end of InterFace */

}
