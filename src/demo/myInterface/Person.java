package demo.myInterface;
public class Person implements OverWeightPerson{
	private int weight;
	private String name;
	Person(String name ,int weight){
		this.name = name;
		this.weight = weight;
		//...人生下来就具有的属性初始化
	}
	public final int getWeight(){
		return weight;
	}
	public final String getName(){
		return name;
	}
	public void hello(){
		System.out.println("Hello, I am "+getName());
	}
	@Override
	public boolean overweight() {
		// TODO Auto-generated method stub
		if(this.getWeight()>WEIGHT_STANDARD){		//FitnessPerson.WEIGHT_STANDARD  或者 Cantonese.WEIGHT_STANDARD
			System.out.println("超出标准需要减肥");		//或者 Cantonese c = new Cantonese(name,weight);
			return true;
		}											//c.WEIGHT_STANDARD 都可以调用接口的常量
		else if(this.getWeight() == WEIGHT_STANDARD){
			System.out.println("符合标准,需要维持");
		}
		else{
			System.out.println("低于标准,适量增肥");
		}
		return false;
		
	}
}
