package demo.collectionFreamwork.example;

public class Worker extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7761351282308291891L;

	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Worker(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Worker [name=" + getName() + ", age=" + getAge()
				+ "]";
	}


	

}
