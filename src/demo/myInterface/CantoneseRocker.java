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
 * 拓展,没改前面FitnessPerson.java里面的代码
 * 直接通过继承拓展
 * CantoneseRocker由前面Cantonese的一些接口和新的Rocker接口聚合而成
 */
