package InterFace.starcreft;

public class Ghost extends Barracks implements Production{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "고스트";
	}

	@Override
	public int getMineral() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public int getGas() {
		// TODO Auto-generated method stub
		return 75;
	}


}
