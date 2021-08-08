package InterFace.student2;

public class ScoreC extends Student implements ScoreConversion , ScoreOutput{

	
//	C에서는 conversion()에서 60점을 기준으로 합격/불합격으로 나뉘고, 그 결과를 output()에서 
//	 * "x님의 시험결과는 K입니다."를 출력한다.
	
	boolean res = false;

	@Override
	public void conversion() {
		
		if (score >= 60) {
			res = true;
		}
		
		output();
	}
	
	@Override
	public void output() {
		if(res) {
			System.out.println("합격이다 이거야아~");
		}else {
			System.out.println("불합격이다 이거야아~");
		}
	}
}
