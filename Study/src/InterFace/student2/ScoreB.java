package InterFace.student2;

public class ScoreB extends Student implements ScoreConversion , ScoreOutput {
	
//	 B에서는 conversion()에서 점수에따라 20점씩 A등급부터 B,C,D,과락등급으로 나뉘고, 그 결과를 
//	 * output()에서 "x님의 학점은 'K'입니다."를 출력한다. (과락일 시, "재수강이 필요합니다" 문구 추가)

	@Override
	public void conversion() {
		if(score <= 100 && score > 80) {
			subject = "A";
		}else if (score <= 80 && score > 60) {
			subject = "B";
		}else if (score <= 60 && score > 40) {
			subject = "C";
		}else if (score <= 40 && score > 20) {
			subject = "D";
		}
	}
	
	@Override
	public void output() {
		
		if (subject != null) {
			System.out.println(name + "님 학점은");
			this.conversion();
			System.out.println(subject + " 입니다 ");
		}else {
			System.out.println("재수강이 필요합니다.");
		}
	}
}
