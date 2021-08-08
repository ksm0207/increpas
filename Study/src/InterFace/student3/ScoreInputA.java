package InterFace.student3;

public class ScoreInputA extends Student implements ScoreConversion , ScoreOutput {
	
	// A에서는 conversion()에서 점수에따라 20점씩 1등급부터 5등급으로 나뉘고, 그 결과를 output()에서 
    // "x님의 등급은 k등급입니다."를 출력한다.
	
	String subjectRes = "";

	@Override
	public void output() {
		
		if (subject != null)
			System.out.println(name + " 님의 " + subject +" 등급은 " + subjectRes + " 등급 입니다.");
	}

	@Override
	public void conversion() {
		// number : 100 80 60 40 20
		if (score <= 100 && score > 80) {
			subjectRes = "1";
		}else if (score <= 80 && score > 60)  {
			subjectRes = "2";
		}else if (score <= 60 && score > 40) {
			subjectRes = "3";
		}else if (score <= 40 && score > 20) {
			subjectRes = "4";
		}else {
			subjectRes = "5";
		}
		output();
		
	}
	
}
