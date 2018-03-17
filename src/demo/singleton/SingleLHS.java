package demo.singleton;

public class SingleLHS {
	private int num;

	private SingleLHS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	//¿¡∫∫ Ω
	private static SingleLHS s;
	public static final SingleLHS getInstance(){
		if(s==null)
			s = new SingleLHS();
		return s;
	}
}
