package demo.myInterface;


public class CantoneseRocker extends Cantonese implements Rocker {

	private Song s;
	
	public CantoneseRocker(String name, int weight) {
		super(name, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rockstyle() {
		// TODO Auto-generated method stub
		sing(s);
		System.out.println("Rock!!!");

	}
}
/*
 * ��չ,û��ǰ��FitnessPerson.java����Ĵ���
 * ֱ��ͨ���̳���չ
 * CantoneseRocker��ǰ��Cantonese��һЩ�ӿں��µ�Rocker�ӿھۺ϶���
 */
