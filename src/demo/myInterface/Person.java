package demo.myInterface;
public class Person implements OverWeightPerson{
	private int weight;
	private String name;
	Person(String name ,int weight){
		this.name = name;
		this.weight = weight;
		//...���������;��е����Գ�ʼ��
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
		if(this.getWeight()>WEIGHT_STANDARD){		//FitnessPerson.WEIGHT_STANDARD  ���� Cantonese.WEIGHT_STANDARD
			System.out.println("������׼��Ҫ����");		//���� Cantonese c = new Cantonese(name,weight);
			return true;
		}											//c.WEIGHT_STANDARD �����Ե��ýӿڵĳ���
		else if(this.getWeight() == WEIGHT_STANDARD){
			System.out.println("���ϱ�׼,��Ҫά��");
		}
		else{
			System.out.println("���ڱ�׼,��������");
		}
		return false;
		
	}
}
