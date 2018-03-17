package demo.xml.student.vo;
//这里vo指的是值对象
public class Student {
	//为了方便都用String
	private String id;
	private String name;
	private String age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new String(getId()+":"+getName()+":"+getAge());
	}
	
}
