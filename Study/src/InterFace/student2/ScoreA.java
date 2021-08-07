package InterFace.student2;

public class ScoreA  extends Student implements ScoreConversion , ScoreOutput  {

	// A에서는 conversion()에서 점수에따라 20점씩 1등급부터 5등급으로 나뉘고, 그 결과를 output()에서 
    //	 * "x님의 등급은 k등급입니다."를 출력한다.
	
	@Override
	public void conversion() {
		if(score <= 100 && score > 80 ) {
			System.out.println("1등급");
		}else if (score <= 80 && score > 60) {
			System.out.println("2등급");
		}else if (score <= 60 && score > 40) {
			System.out.println("3등급");
		}else if (score <= 40 && score > 20) {
			System.out.println("4등급");
		}else {
			System.out.println("5등급");
		}
	}
	
	@Override
	public void output() {
		System.out.println(name + " 님의 등급은 ");
		this.conversion();
		System.out.println("입니다 ");
	}
}
