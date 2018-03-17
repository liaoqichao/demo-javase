package demo.multiThread;

public class ThreadDemo1_1 extends Thread {
	
	ThreadDemo1_1(String name ){
		super(name);					//给线程起名字			
	}
	//除了extends Thread 还可以 implements Runnable,但里面没有sleep等方法
	public void run(){					//要用Thread.sleep();
		for(int i=0;i<10;i++){
			if(i%3==0)
			try {
				sleep((int)Math.random()*1000);						//0毫秒,10纳秒。一定要有trycatch,不然会报错
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}

}
