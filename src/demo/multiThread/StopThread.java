package demo.multiThread;

public class StopThread implements Runnable {

	private boolean flag = true;
	public synchronized void  run(){
		while(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(Thread.currentThread().getName()+" InterruptionException");
				flag = false;
			}
			System.out.println(Thread.currentThread().getName()+" is running");
		}
	}
	public void changeFlag(){
		flag = !flag;
	}
}
