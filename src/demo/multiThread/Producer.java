package demo.multiThread;

public class Producer implements Runnable {		//������ԴҪ����Դ����  Godown g

	//Godown g = new Godown();			//new Godown(); �� Consumer��g ��ͬһ���ֿ���?ͨ�����캯���Ĳ���
	Godown g;							//Godown g ������,��������ߺ������ߵĹ��캯���Ĳ�����ͬһ������
	private int needNum;				//,��ô�������������ѵľ���ͬһ���ֿ⡣��ȻҲ�����õ���ģʽ�����ǱȽ��鷳
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
