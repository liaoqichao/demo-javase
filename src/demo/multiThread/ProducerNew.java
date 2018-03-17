package demo.multiThread;


public class ProducerNew implements Runnable {

	private Resource r;
	private int needNum;
	ProducerNew(Resource r, int needNum){
		this.r = r;
		this.needNum = needNum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			r.produce(r,needNum);
	}
}
