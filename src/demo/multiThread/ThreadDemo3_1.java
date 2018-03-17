package demo.multiThread;

public class ThreadDemo3_1 implements Runnable {

	private int sum = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i= 1; i<=10 ;i++){
			synchronized(this){
				sum += i;
				System.out.println(Thread.currentThread().getName()+"������"+sum);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				notify();							//���߳���������������߳�,һ��Ҫ��ͬ������
			}
		}
	}
	public int getSum(){
		return sum;
	}

}
