package demo.multiThread;

public class Producer implements Runnable {		//操作资源要有资源对象  Godown g

	//Godown g = new Godown();			//new Godown(); 和 Consumer的g 是同一个仓库吗?通过构造函数的参数
	Godown g;							//Godown g 来控制,如果生产者和消费者的构造函数的参数是同一个对象
	private int needNum;				//,那么他们生产和消费的就是同一个仓库。当然也可以用单例模式，但是比较麻烦
	Producer(Godown g,int needNum){
		this.g = g;
		this.needNum = needNum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		g.produce(g, needNum);
	}

}
