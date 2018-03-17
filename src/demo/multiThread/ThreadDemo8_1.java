package demo.multiThread;

public class ThreadDemo8_1 implements Runnable {
	
	public void run(){
		
		for(int i = 0 ; i<75;i++)
			System.out.println(Thread.currentThread().getName()+"..."+i);
		
	}

}
