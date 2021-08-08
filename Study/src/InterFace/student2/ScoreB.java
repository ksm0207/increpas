package InterFace.student2;

public class ScoreB extends Student implements ScoreConversion , ScoreOutput {

	
	String res = "";
	
	@Override
	public void conversion() {
		if(score <= 100 && score >= 80) {
			res = "A";
		}else if (score <= 80 && score >= 60) {
			res = "B";
		}else if (score <= 60 && score >= 40) {
			res = "C";
		}else if (score <= 40 && score >= 20) {
			res = "D";
		}
	
		output();
	}
	
	@Override
	public void output() {
		System.out.println(subject);
		if (res != null) {
			System.out.println(name + "님의 " + subject + " 학점은" + res + " 입니다 ");
		}else {
			System.out.println("재수강이 필요합니다.");
		}
	}
}
