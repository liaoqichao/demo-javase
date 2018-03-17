package demo.collectionFreamwork.example;

public class Student extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2926157808697645008L;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [name=" + getName() + ", age=" + getAge()
				+ "]";
	}



}
