package demo.multiThread;

public class ThreadDemo7_1 implements Runnable {
	
	public void run(){
		for(int i = 0 ; true ; i++){
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}

}
