package demo.multiThread;

public class ThreadDemo1_1 extends Thread {
	
	ThreadDemo1_1(String name ){
		super(name);					//���߳�������			
	}
	//����extends Thread ������ implements Runnable,������û��sleep�ȷ���
	public void run(){					//Ҫ��Thread.sleep();
		for(int i=0;i<10;i++){
			if(i%3==0)
			try {
				sleep((int)Math.random()*1000);						//0����,10���롣һ��Ҫ��trycatch,��Ȼ�ᱨ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}

}
