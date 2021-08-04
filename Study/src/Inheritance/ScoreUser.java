package Inheritance;

public class ScoreUser extends Person{
	
	int kor;
	int math;
	int eng;
	int his;
	
	public int getKor() {
		return kor;
	}
	
	public int getMath() {
		return math;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getHis() {
		return his;
	}
	
	public int sum(int kor , int math, int eng, int his) {
		
		return (kor + math) + (eng + his);
	}
	
}
