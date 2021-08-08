package InterFace.student3;

public class ScoreInputC extends Student implements ScoreConversion , ScoreOutput {
	
//	C에서는 conversion()에서 60점을 기준으로 합격/불합격으로 나뉘고, 그 결과를 output()에서 
//	"x님의 시험결과는 K입니다."를 출력한다.
	
	String subjectRes = "";

	@Override
	public void output() {
		
		boolean check = true;
		
		if (check)
			System.out.println(name + " 님의 "+ subject +" 시험 결과는 " + subjectRes + " 입니다  ");
	}

	@Override
	public void conversion() {
		
		
		if (score >= 60) {
			subjectRes = "'합격'";
		}else {
			subjectRes = "'불합격'";
		}
		
		output();
		
	}


}
