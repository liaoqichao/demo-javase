package demo.singleton;

public class SingleEHS {
	
	private int num;
	private SingleEHS(){
		
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	//饿汉式结构
	private static final SingleEHS s = new SingleEHS();//私有,静态
	public static SingleEHS getInstance(){
		return s;
	}
}
