package demo.io;
import java.io.Serializable;
import java.util.Comparator;


public class Person implements Serializable,Comparable<Object>{//强制让Person具备比较性
	/**
	 * 
	 */
	private static final long serialVersionUID = 6429465552683766429L;//用于判断类和对象是否同一版本

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

	public void chifan(){			//装饰设计模式例子
		System.out.println("吃饭");
	}

	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	/**
	 * ArrayList的contain和remove调用equals方法,所以要覆盖equals方法
	 * HashSet的哈希表根据哈希值判断时候重复,所以要覆盖hashCode方法,如果哈希值相同再判断是否同一对象,所以还要覆盖equals方法
	 * 这样的话每次都要比较2次(hashCode和equals)，可以根据条件来设置哈希值,如果同名同年龄哈希值一样,否则就不一样，这样就减少了不一样
	 * 的比较次数。
	 */
	public boolean equals(Object obj){			//覆盖Object类中的方法,判断条件不是地址值,而是名字和年龄
		//注意如果参数是Person obj 则没有复写
		if(obj instanceof Person){
			Person person = (Person)obj;
			//System.out.println(this.name+"::"+this.age+"..equals?.."+person.name+"::"+person.age+" : "+(this.name.equals(person.name) && age == person.age));
			return this.name.equals(person.name) && age == person.age; //这里的equals是String的方法
		}
		return false;
	}
	public int hashCode(){
		//注意函数名写错则没有复写 例如 hasCode 少了h
		//System.out.println(name+"::"+age+"...hashCode");
		return name.hashCode()+age*39;		//这里的hashCode()是String复写的方法。万一两个加数不一样,和一样怎么办?
											//*39尽量保证哈希值唯一
		//return 1;							//这样每次都要比较2次
	}
	
	@Override
	public String toString() {
		return "Person " + name + ":" + age ;
	}
	@Override
	public int compareTo(Object o)  {//返回负数，0，整数 来判断  这个对象是小于，等于还是大于参数那个对象，函数不能throws异常,因为接口的这个抽象方法没有抛出这个异常
		//等于0的时候2个对象相等
		//按年龄排序
		// TODO Auto-generated method stub
		//return 1; //这样的话每个后来的元素都比前面的元素大,所以每个元素都是比二叉树里面全部节点大，放在最右边..只有右子树就变成一条线
		//			  所有add的顺序和it.next()的顺序一样
		if(o instanceof Person){
			Person person = (Person)o;
			//System.out.println(this.name+"::"+this.age+"..compareTo.."+person.name+"::"+person.age);
			if(this.age == person.age){//主要条件相同按照次要条件排,次要条件也相同,说明元素相同
				return this.name.compareTo(person.name);	//String类也实现了 compareTo
			}
			return this.age-person.age;
		}
		throw new RuntimeException("不是Person对象");
	}
	public static CompareByAge getCompareByAge() {
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

class NewPerson{			//装饰设计模式,增强吃饭功能
	
	private Person p;
	NewPerson(Person p){
		this.p = p;
	}
	public void chifan(){		//增强吃饭功能
		System.out.println("开胃酒");
		p.chifan();
		System.out.println("甜点");
	}
}