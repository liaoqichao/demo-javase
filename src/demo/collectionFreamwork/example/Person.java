package demo.collectionFreamwork.example;
import java.io.Serializable;
import java.util.Comparator;


public class Person implements Serializable,Comparable<Object>{//ǿ����Person�߱��Ƚ���
	/**
	 * 
	 */
	private static final long serialVersionUID = -7244975991977167301L;
	
	private int age;
	private String name;
	private final static CompareByAge compareByAge = new CompareByAge();
	private final static CompareByName compareByName = new CompareByName();

	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void chifan(){			//װ�����ģʽ����
		System.out.println("�Է�");
	}

	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	/**
	 * ArrayList��contain��remove����equals����,����Ҫ����equals����
	 * HashSet�Ĺ�ϣ����ݹ�ϣֵ�ж�ʱ���ظ�,����Ҫ����hashCode����,�����ϣֵ��ͬ���ж��Ƿ�ͬһ����,���Ի�Ҫ����equals����
	 * �����Ļ�ÿ�ζ�Ҫ�Ƚ�2��(hashCode��equals)�����Ը������������ù�ϣֵ,���ͬ��ͬ�����ϣֵһ��,����Ͳ�һ���������ͼ����˲�һ��
	 * �ıȽϴ�����
	 */
	public boolean equals(Object obj){			//����Object���еķ���,�ж��������ǵ�ֵַ,�������ֺ�����
		//ע�����������Person obj ��û�и�д
		if(obj instanceof Person){
			Person person = (Person)obj;
			//System.out.println(this.name+"::"+this.age+"..equals?.."+person.name+"::"+person.age+" : "+(this.name.equals(person.name) && age == person.age));
			return this.name.equals(person.name) && age == person.age; //�����equals��String�ķ���
		}
		return false;
	}
	public int hashCode(){
		//ע�⺯����д����û�и�д ���� hasCode ����h
		//System.out.println(name+"::"+age+"...hashCode");
		return name.hashCode()+age*39;		//�����hashCode()��String��д�ķ�������һ����������һ��,��һ����ô��?
											//*39������֤��ϣֵΨһ
		//return 1;							//����ÿ�ζ�Ҫ�Ƚ�2��
	}
	
	@Override
	public String toString() {
		return "Person " + name + ":" + age ;
	}
	@Override
	public int compareTo(Object o)  {//���ظ�����0������ ���ж�  ���������С�ڣ����ڻ��Ǵ��ڲ����Ǹ����󣬺�������throws�쳣,��Ϊ�ӿڵ�������󷽷�û���׳�����쳣
		//����0��ʱ��2���������
		// TODO Auto-generated method stub
		//return 1; //�����Ļ�ÿ��������Ԫ�ض���ǰ���Ԫ�ش�,����ÿ��Ԫ�ض��Ǳȶ���������ȫ���ڵ�󣬷������ұ�..ֻ���������ͱ��һ����
		//			  ����add��˳���it.next()��˳��һ��
		if(o instanceof Person){
			Person person = (Person)o;
			//System.out.println(this.name+"::"+this.age+"..compareTo.."+person.name+"::"+person.age);
			if(this.age == person.age){//��Ҫ������ͬ���մ�Ҫ������,��Ҫ����Ҳ��ͬ,˵��Ԫ����ͬ
				return this.name.compareTo(person.name);	//String��Ҳʵ���� compareTo
			}
			return this.age-person.age;
		}
		throw new RuntimeException("����Person����");
	}
	public static CompareByAge getCompareByAge() {		//TreeMap demo1��,ֱ��������ȡ�Ƚ���,����new �Ƚ���(���ü�ס�Ƚ���������)
		return compareByAge;
	}
	public static CompareByName getCompareByName() {
		return compareByName;
	}
	
}
class CompareByName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.getName()==o2.getName()?o1.getAge()-o2.getAge():o1.getName().compareTo(o2.getName());
	}
}
class CompareByAge implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		/*
		if(o1.getName() == o2.getName())
			return o1.getAge()-o2.getAge();
		return o1.getName().compareTo(o2.getName());
	}*/
		return o1.getName()==o2.getName()?o1.getAge()-o2.getAge():o1.getName().compareTo(o2.getName());
	}
}

class NewPerson{			//װ�����ģʽ,��ǿ�Է�����
	
	private Person p;
	NewPerson(Person p){
		this.p = p;
	}
	public void chifan(){		//��ǿ�Է�����
		System.out.println("��θ��");
		p.chifan();
		System.out.println("���");
	}
}