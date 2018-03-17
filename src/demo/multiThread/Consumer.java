package demo.multiThread;


public class Consumer implements Runnable {		//操作资源要有资源对象  Godown g
	//Godown g = new Godown();			//new Godown(); 和 Producer的 g 是同一个仓库吗?
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
