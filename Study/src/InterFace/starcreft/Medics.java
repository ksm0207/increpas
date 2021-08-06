package InterFace.starcreft;

public class Medics extends Barracks implements Production{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "메딕";
	}

	@Override
	public int getMineral() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public int getGas() {
		// TODO Auto-generated method stub
		return 25;
	}



}
