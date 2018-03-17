package demo.multiThread;

import org.junit.Test;

import demo.DemoInterface;

public class MultiThread implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();
		//demo7();
		//demo8();
		demo9();

	}

	public void demo1() {		//���̵߳Ľ���
		// TODO Auto-generated method stub
		ThreadDemo1_1 t1 = new ThreadDemo1_1("�߳�t1");				//3��ִ��·��,�ֳ�3��Сջmain,t1.run,t2.run
		ThreadDemo1_1 t2 = new ThreadDemo1_1("�߳�t2");				//�������Լ��Ķ����ռ�,���Լ��ĵ�ջ��push,pop,��������
																	//t3.join(),���뵽����t3.join()���߳�
		Thread t3 = new Thread(new ThreadDemo1_2());
		t3.setName("�߳�t3");
		Thread.currentThread().setName("���߳�main");					//t1,t2����MyThread�Ķ����Լ��ľֲ�����x
		t1.start();
		t2.start();
		t3.start();
		//t1.join,t2,join���߳�1��2������ɺ��������̵߳����� �����߳�����join()
		//�����t2,t3֮����t2.join��t2�߳�������ɺ�ſ�ʼ�����̵߳�����(��һ�����ʱt3.start())
		//����t2��ɺ�t3�ſ�ʼ�߳�
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//t3.start();
		/*
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
		//sop(4/0) 									//��Ϊ"���߳�main"���̳߳����쳣,��������Ϊ0
		for(int i=0;i<10;i++)		{				//���߳̽���,t1,t2�̼߳�������
			System.out.println(Thread.currentThread().getName()+" "+i);
			try{
			Thread.sleep((int)Math.random()*1000);
			}catch(InterruptedException e){e.printStackTrace();}
		}
		/*
		 * �����̵߳����ַ�ʽ��	1.�̳�Thread��					2.ʵ��Runnable�ӿ�
		 *					��������̳�Thread,������дrun()		��������̳�Thread,������дrun()
		 *					MyThread t =new MyThread();		Runnable r = new MyThread();//MyThread r = new MyThread();
		 *													Thread t = new Thread(r);
		 *													//Thread t =new Thread(new MyThread());
		 * 						t.start();						t.start();
		 * 
		 * ʵ����ͨ��ֻ��Runnable,���߳�����run()��װ�ɶ���Runnable r = new MyThread();
		 * Ȼ���½��̶߳���,��ȷ�̵߳�����Thread t = new Thread(r);
		 * ֮ǰ����ֻ�����һ��������,���ڽ����񵥶���װ����
		 * 
		 * ʵ��Runnable�ӿڵĺô�:
		 * 1.������������˼�뽫�����װ�ɶ���
		 * 2.������JAVA���̳еľ�����
		 * 	Student �̳���Person �Ļ��Ͳ����ټ̳�Thread
		 * 
		 */
		
		
	}

	public void demo2() {		//ͬ������Ʊ����
		// TODO Auto-generated method stub
		ThreadDemo2_1 t =new ThreadDemo2_1();
		Thread t1 = new Thread(t,"����һ");
		Thread t2 = new Thread(t,"���ڶ�");
		Thread t3 = new Thread(t,"������");
		Thread t4 = new Thread(t,"������");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

	public void demo3() {		//�̵߳Ľ���	//��������ӵ����.wait() notify() notifyAll()
		// TODO Auto-generated method stub
		
		ThreadDemo3_1 mt = new ThreadDemo3_1();
		
		Thread t =new Thread(mt);
		t.start();
		
		synchronized(t){					//��ӵ������start�Ķ���t,����mt
			try {
				System.out.println("�ȴ�����t,�߳�"+t.getName()+"����...");
				//���̵߳ȴ�,����t������̵߳ȴ�
				t.wait();					//����������������ȴ��˶���ĵȴ�������,��sleep�����ͷ�ͬ����
											//wait,notify,notifyAllһ��Ҫ��synchronized����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i<5; i++){
				System.out.println("�߳�"+Thread.currentThread().getName()+"������");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}//����t�����
		
		System.out.println("����t�����������"+mt.getSum());
	}

	public void demo4() {		//������������ģ��1
		// TODO Auto-generated method stub
		/**
		 * ������������ģ��1
		 * 1.�����ߺ����������������ѵ���Ʒ��ͬһ�ֿ�
		 * 2.���������������������Ͽ���������ڲֿ�����,���Ƴ�����,�ȱ��̻߳��Ѻ���Ȼ���ڲֿ�����,������������
		 *   ����ϴ��������ɹ�(canProduct = false) ,���߳������������,���Ƴ�����,�Ƴ������̻߳��Ѻ��ֻ��Ǵ��ڲֿ�����,��ȡ���������
		 * 3.�������ߵ������������ڿ������,���Ƴ����ѣ��ȵ����̱߳����Ѻ���Ȼ�����������ڿ������,������������
		 *   �����һ���̲߳��ܳɹ�����(canSale = false) ,���߳������������,���Ƴ�����,�Ƴ������̻߳��Ѻ��ֻ��ǿ�治��,��ȡ���������
		 * 4.���ǵ�����ʧ�ܺ�,������������߳�,��������̲߳������̹���.(��Ϊ��ֻ��wait()����ʧ�ܵ��߳�,�����������߳�û��ͬʱ����wait()״̬)
		 * 5.�����߳���һ����(��ʾ)�����߳�,(��Ϊ������������߳̾ͽ���wait()״̬,��ʹ�Զ�����,��Ҫ5�β�����ѭ��,����������߳��޸���canProduct,����Ҫ5�ξ�������ѭ��)
		 */
		Godown g = new Godown(50);						//Thread t = new Thread(mt);
		/*
		 * ֮ǰ��Ʊ��
		 * Thread t1 =new Thread(new(MyThread3));
		 * Thread t2 =new Thread(new(MyThread3));
		 * Thread t3 =new Thread(new(MyThread3));
		 * Thread t4 =new Thread(new(MyThread3));
		 * 4��new ����4������ ������������ָ�������100��Ʊ,������400��Ʊ
		 * ����new��3��������,6��������, ���ǵĶ����ǲ�ͬ��,�����ǵ��������������ڵĲֿ���ͬһ��g(���캯���Ĵ��Ĳ�����ͬ),��ͬ����������Godown����
		 */
		new Thread(new Producer(g,20),"p1").start();	
		new Thread(new Producer(g,30),"p2").start();	
		new Thread(new Producer(g,50),"p3").start();
		
		new Thread(new Consumer(g,10),"c1").start();
		new Thread(new Consumer(g,10),"c2").start();
		new Thread(new Consumer(g,20),"c3").start();
		new Thread(new Consumer(g,20),"c4").start();
		new Thread(new Consumer(g,30),"c5").start();
		new Thread(new Consumer(g,50),"c6").start();
	}

	public void demo5() {		//������������ģ��2 Lock,Condition
		// TODO Auto-generated method stub
		/**
		 * 
		 * �����ߡ���������ģ��2
		 * 1.����һ����Ҫ����һ��
		 * 2.�����̺߳������߳��ж��
		 * 
		 * 
		 * Lock�ӿ� �ṩ�˱�synchronized ���㷺����������
		 * ʵ��ReentrantLock,ReentrantReadWriteLock.ReadLock,ReentrantReadWriteLock.WriteLock
		 * ����ժҪ��
		 * lock();								��ȡ��
		 * lockInterruptibly();					����߳�δ���ж����ȡ��
		 * newCondition();						���ذ󶨵���lockʵ������Conditionʵ��
		 * tryLock();							���ڵ���ʱ��Ϊ���е�״̬�Ż�ȡ����
		 * tryLock(long time,timeUnit unit);	������ڸ���ʱ���ڿ��У������߳�δ���жϣ����ȡ����
		 * unlock();							�ͷŸ���
		 * 
		 * Condition�ཫObject����������(wait,notify,notifyAll)�ֽ�ɽ�Ȼ��ͬ�Ķ���,��Щ�����Lock��������������
		 * Lock������synchronized����������ʹ��,Condition������Object������������ʹ��
		 * ����ժҪ
		 * await();								���ж�ǰ����ȴ�״̬
		 * await(long time,timeUnit unit);		�ȴ�һ��ʱ��
		 * awaitNanos(long nanosTimeout);		�ȴ�һ��ʱ��
		 * awaitUntil(Date deadLine);			�ȴ���ĳ��ʱ��λ��
		 * signal();							����һ���ȴ��е��߳�
		 * signal();							�������еȴ��е��߳�
		 * 
		 * Objec��� notifyAll() �ỽ��ȫ���ȴ�����,��notify();�ỽ������Ľ��̡����ܴﵽֻ���������߻���ֻ���������ߵ����н���
		 * 1��lockʵ�� ���� ��Ӧ���Conditionʵ��
		 * Condition condition_producer = lock.newCondition();
		 * Condition condition_consumer = lock.newCondition();
		 * 
		 * ��ʽ��
		 * Lock lock = new ReentrantLock();				//����������Reentrant �ٽ�ȥ��,���ǵ�
		 * Condition condition = lock.newCondition();	//����await(),signal(),signalAll()�ȷ����Ķ���
		 * lock.lock()									//����
		 * try{
		 * 		...; await(); ...signal();				//ͬ���Ĵ���
		 * }catcah(InterruptedException e){
		 * 		e.printStackTrace();
		 * }
		 * fially{										//�ͷ���
		 * 	lock.unlock();
		 * }
		 */
		Resource r = new Resource(50);
		
		ProducerNew p1 =new ProducerNew(r,10);
		ProducerNew p2 =new ProducerNew(r,10);
		ConsumerNew c1 =new ConsumerNew(r,10);
		ConsumerNew c2 =new ConsumerNew(r,10);

		Thread t1 = new Thread(p1,"������1");
		Thread t2 = new Thread(p2,"������2");
		Thread t3 = new Thread(c1,"Consumer1");
		Thread t4 = new Thread(c2,"Consumer2");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public void demo6() {		//ֹͣ�̵߳ķ���
		// TODO Auto-generated method stub
		/**
		 * �̵߳�ֹͣstop();
		 * public void stop();	//������ʹ��,�ѹ�ʱ��Ҫ�������̵ķ���ֻ��һ��,����run����
		 * ͨ�����̶߳�����ѭ���ṹ ���磺while(flag) condition.await();  ֻҪ����ѭ���Ϳ�����run��������
		 * 
		 * ���������  public void synchronized run(){ this.wait(); } ,t1,���У��ȴ���t2�̻߳�������У��ȴ������߳���������,
		 * 	t1,t2��û�����Ѽ������С�
		 * �̴߳��ڶ���״̬(wait(),sleep())�Ͳ����ȡ��flag����ô�߳̾Ͳ����������ʱ���� t1.interrupt();�������wait,sleep����,
		 * ���������̣߳������յ�InterruptedException�쳣
		 */
		StopThread st = new StopThread();
		
		Thread t1 = new Thread(st,"s1");
		Thread t2 = new Thread(st,"s2");
		t1.start();
		t2.start();
		int num=0;
		while(true){
			if(num++ == 65){
				t1.interrupt();
				t2.interrupt();
				//st.changeFlag();				//ͨ���ı�flag������ѭ��,�Ӷ�����run������������
				break;
			}
			System.out.println("main is running. "+num);
		}
		
	}

	public void demo7() {		//�ػ��߳�
		// TODO Auto-generated method stub
		/**
		 * �ػ��߳�
		 * Thread���е�setDaemon();�����̱߳��Ϊ�ػ��̻߳����û��̻߳��ߺ�̨�̡߳��������е��̶߳����ػ��߳�ʱ,JVM�˳����÷����������߳�����ǰ����
		 * �ػ��̺߳�ǰ̨�̹߳�ͬ������Դ,��ǰ̨�߳�ȫ��������,��̨�߳��Զ�����.
		 * ����߳�B�������߳�A, ���߳�A����ʱ,�߳�BҲû����.��ʱ����԰��߳�B����Ϊ�ػ��̣߳��߳�A�������߳�B�Զ�����
		 */
		ThreadDemo7_1 mt = new ThreadDemo7_1();
		
		Thread t1 = new Thread(mt,"t1");
		Thread t2 = new Thread(mt,"t2");
		
		t1.setDaemon(true);				//����ǰ̨�߳�(���ػ��߳�)������,�ػ��߳��Զ�����,
		t2.setDaemon(true);				// main ... 99 �� t2 :158 ~ t2:164Ȼ�����ͽ�����
		t1.start();
		t2.start();
		
		for(int i = 0 ; i <100 ; i++){
			System.out.println("main ... "+i);
		}
		System.out.println("over");
		
	}

	public void demo8() {		//join
		// TODO Auto-generated method stub
		
		/**
		 * join();������ʱ�����߳�ִ�С�  ���߳�A�� ���߳�B�̵߳�join����, ��ôA�߳̾ͻ��B�߳�ִ�����A�ż���ִ��
		 */
		ThreadDemo8_1 tt = new ThreadDemo8_1();
		Thread t1 = new Thread(tt,"t1");
		Thread t2 = new Thread(tt,"t2");
		
		t1.start();
		//t2.start();						//���t2������,t1����main��ִ��Ȩ, t1�� t2�������,t1������,main�ſ�ʼ��������Ĵ���
		try {
			t1.join();						//t1�������,t2��main�����С���main�߳������t1.join();t1Ҫ����main��ִ��Ȩ
		} catch (InterruptedException e) {	//��t1�������,main�ſ�ʼ����,��ʱ��t2��ûstart(t2.start()�� t1.join()����)
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		for(int i = 0 ; i < 80 ; i ++){
			System.out.println(Thread.currentThread().getName()+" ... "+ i);
		}
		
	}

	@Test
	public void demo9() throws Exception {		//ThreadLocal
		
		/**
		 * ThreadLocal�����ã��ڶ��̵߳�ʱ����һЩ���ݲ���Ҫ����̷߳��ʡ�ͨ���ǰѳ�Ա��������ThreadLocal��
		 * �ڲ�ʵ�֡�Map<Thread,T>,T�Ƿ��ͣ���Ҫ�洢������
		 * 1���߳̿��Դ洢һ�����ݡ�set,get,remove��������
		 * 	map.put(Thread.currentThread(),data);
		 * 	map.get(Thread.currentThread());
		 * 	map.remove(Thread.currentThread());
		 * 	���ǵ�ǰ�߳�,���Ա����߳��ǲ���set,get,remove����̵߳����ݡ�
		 */
		final ThreadLocal<String> t1 = new ThreadLocal<>();//�ڲ����������Ҫfinal
//		t1.set("hello");			//��
//		t1.set("world");//����hello
//		String s = t1.get();		//ȡ
//		t1.remove();				//ɾ
//		System.out.println(t1.get());//world
		
		new Thread(){
			public void run(){
				t1.set("�ڲ����");
//				System.out.println("�ڲ���"+t1.get());//�ڲ���null
			}
		}.start();
		Thread.sleep(1000);
		System.out.println(t1.get());
	}
}
/*
 *  ��õ�ǰ�̶߳���ķ�����Thread.currentThread(); 
 *  һ���߳�������������Զ����������������ֻ��һ���µ��߳̿��Ա�����������ֻ��һ�Ρ�һ�������е��̻߳����߳̿��Ա�����������
 *  
 * 	��ʼ�߳�		public void start();	public void run();
 * 	����ͻ����߳�	public void resume();	public void suspend();�ѹ�ʱ  //������������ʹ��
 * 				public void sleep(long millis);	public void sleep(long millis,int nanos);//����,����
 * 	��ֹ�߳�		public void stop();	//������ʹ��,�ѹ�ʱ��Ҫ�������̵ķ���ֻ��һ��,����run����	public void interrupt();
 * 	�õ��߳�״̬	public boolean isAlive();	public boolean isInterrupt(); 
 * 				public static boolean interrupted();
 *  join()�����Ĺ��ܾ���ʹ�첽ִ�е��̱߳��ͬ��ִ��
 *  setPriority(10); 1~10 ,Ĭ����5,10���ȼ����
 *  �̵߳��ò�ʹ��Thread.yield()������yield() Ϊ��̬��������������ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������̡߳�
 *  �̵߳��ò��������ʹ��ǰ�������߳��ó�CPU��Դ��yield()ֻ�ܸ���ͬ���ȼ����߳��ò�,�ò���ʱ�����ò���,
 *  ��sleep()��������ʱ�䡣ʹ��sleep��yield����ռס������,��������ͬ�����ͬ��������ʹ��
 *  
 *  public void stop();	//������ʹ��,�ѹ�ʱ��Ҫ�������̵ķ���ֻ��һ��,����run����
 *  ͨ�����̶߳�����ѭ���ṹ ���磺while(flag) condition.await();  ֻҪ����ѭ���Ϳ�����run��������	
 */
