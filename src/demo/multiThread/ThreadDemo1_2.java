package demo.multiThread;

public class ThreadDemo1_2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			if(i%4 == 0)
				try {
					Thread.sleep((int)Math.random()*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}

}
