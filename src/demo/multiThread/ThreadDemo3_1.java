package demo.multiThread;

public class ThreadDemo3_1 implements Runnable {

	private int sum = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i= 1; i<=10 ;i++){
			synchronized(this){
				sum += i;
				System.out.println(Thread.currentThread().getName()+"在运算"+sum);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				notify();							//本线程运算完后唤醒所有线程,一定要在同步块内
			}
		}
	}
	public int getSum(){
		return sum;
	}

}
