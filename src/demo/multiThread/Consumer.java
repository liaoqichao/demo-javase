package demo.multiThread;


public class Consumer implements Runnable {		//������ԴҪ����Դ����  Godown g
	//Godown g = new Godown();			//new Godown(); �� Producer�� g ��ͬһ���ֿ���?
	Godown g;
	private int needNum;
	Consumer(Godown g,int needNum){
		this.g = g;
		this.needNum = needNum;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		g.consume(g, needNum);
	}

}
