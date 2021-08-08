package InterFace.student3;

public class ScoreInputB extends Student implements ScoreConversion , ScoreOutput {
	
//	B에서는 conversion()에서 점수에따라 20점씩 A등급부터 B,C,D,과락등급으로 나뉘고, 그 결과를 
//	 * output()에서 "x님의 학점은 'K'입니다."를 출력한다. (과락일 시, "재수강이 필요합니다" 문구 추가)

	String subjectRes = "";

	@Override
	public void output() {
		boolean check = false;
		
		if (subjectRes != null) {
			System.out.println(name + " 님의 " + subject + " 학점은  " + subjectRes + " 입니다.");
			check = true;
		}else {
			if (!check) {
				System.out.println(name + " 님은 " + " '재수강'이 필요합니다.");		
			}
		} 
	}

	@Override
	public void conversion() {
		
		
		if (score <= 100 && score >= 80) {
			subjectRes = "A";
		}else if (score <= 80 && score >= 60)  {
			subjectRes = "B";
		}else if (score <= 60 && score >= 40) {
			subjectRes = "C";
		}else if (score <= 40 && score >= 20) {
			subjectRes = "D";
		}else {
			subjectRes = null;
		}
		output();
		
	}
	

}
