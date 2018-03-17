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
	
	//����ʽ�ṹ
	private static final SingleEHS s = new SingleEHS();//˽��,��̬
	public static SingleEHS getInstance(){
		return s;
	}
}
