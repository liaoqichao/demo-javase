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

	public void demo1() {		//多线程的建立
		// TODO Auto-generated method stub
		ThreadDemo1_1 t1 = new ThreadDemo1_1("线程t1");				//3条执行路径,分成3个小栈main,t1.run,t2.run
		ThreadDemo1_1 t2 = new ThreadDemo1_1("线程t2");				//它们有自己的独立空间,在自己的的栈里push,pop,互不干扰
																	//t3.join(),加入到调用t3.join()的线程
		Thread t3 = new Thread(new ThreadDemo1_2());
		t3.setName("线程t3");
		Thread.currentThread().setName("主线程main");					//t1,t2它们MyThread的都有自己的局部变量x
		t1.start();
		t2.start();
		t3.start();
		//t1.join,t2,join等线程1，2，都完成后才完成主线程的任务 在主线程中用join()
		//如果在t2,t3之间用t2.join则当t2线程任务完成后才开始做主线程的任务(第一条语句时t3.start())
		//所以t2完成后t3才开始线程
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

		
		//sop(4/0) 									//名为"主线程main"的线程出现异常,除数不能为0
		for(int i=0;i<10;i++)		{				//主线程结束,t1,t2线程继续运行
			System.out.println(Thread.currentThread().getName()+" "+i);
			try{
			Thread.sleep((int)Math.random()*1000);
			}catch(InterruptedException e){e.printStackTrace();}
		}
		/*
		 * 创建线程的两种方式：	1.继承Thread类					2.实现Runnable接口
		 *					定义新类继承Thread,里面重写run()		定义新类继承Thread,里面重写run()
		 *					MyThread t =new MyThread();		Runnable r = new MyThread();//MyThread r = new MyThread();
		 *													Thread t = new Thread(r);
		 *													//Thread t =new Thread(new MyThread());
		 * 						t.start();						t.start();
		 * 
		 * 实际中通常只用Runnable,把线程任务run()封装成对象Runnable r = new MyThread();
		 * 然后新建线程对象,明确线程的任务Thread t = new Thread(r);
		 * 之前任务只是类的一部分内容,现在将任务单独封装成类
		 * 
		 * 实现Runnable接口的好处:
		 * 1.按照面向对象的思想将任务封装成对象
		 * 2.避免了JAVA单继承的局限性
		 * 	Student 继承了Person 的话就不能再继承Thread
		 * 
		 */
		
		
	}

	public void demo2() {		//同步和卖票例子
		// TODO Auto-generated method stub
		ThreadDemo2_1 t =new ThreadDemo2_1();
		Thread t1 = new Thread(t,"窗口一");
		Thread t2 = new Thread(t,"窗口二");
		Thread t3 = new Thread(t,"窗口三");
		Thread t4 = new Thread(t,"窗口四");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

	public void demo3() {		//线程的交互	//对象锁的拥有者.wait() notify() notifyAll()
		// TODO Auto-generated method stub
		
		ThreadDemo3_1 mt = new ThreadDemo3_1();
		
		Thread t =new Thread(mt);
		t.start();
		
		synchronized(t){					//锁拥有者是start的对象t,不是mt
			try {
				System.out.println("等待对象t,线程"+t.getName()+"计算...");
				//主线程等待,不是t对象的线程等待
				t.wait();					//放弃对象锁，进入等待此对象的等待锁定池,而sleep不会释放同步锁
											//wait,notify,notifyAll一定要在synchronized里面
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i<5; i++){
				System.out.println("线程"+Thread.currentThread().getName()+"在运算");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}//对象t算完后
		
		System.out.println("对象t计算的总数是"+mt.getSum());
	}

	public void demo4() {		//生产者消费者模型1
		// TODO Auto-generated method stub
		/**
		 * 生产者消费者模型1
		 * 1.生产者和消费者生产或消费的商品在同一仓库
		 * 2.当生产者生产的数量加上库存数量大于仓库上限,则推迟生产,等本线程唤醒后依然大于仓库上限,则放弃这次生产
		 *   如果上次生产不成功(canProduct = false) ,本线程如果还是生产,则推迟生产,推迟生产线程唤醒后发现还是大于仓库上限,则取消这次生产
		 * 3.当消费者的消费数量大于库存数量,则推迟消费，等到本线程被唤醒后依然消费数量大于库存数量,则放弃这次消费
		 *   如果上一个线程不能成功消费(canSale = false) ,本线程如果还是消费,则推迟消费,推迟消费线程唤醒后发现还是库存不足,则取消这次消费
		 * 4.但是当消费失败后,如果还有生产线程,这个生产线程不会立刻工作.(因为你只是wait()消费失败的线程,其他的消费线程没有同时进入wait()状态)
		 * 5.生产线程下一个是(显示)消费线程,(因为如果还是生产线程就进入wait()状态,即使自动唤醒,需要5次才跳出循环,如果有消费线程修改了canProduct,则不需要5次就能跳出循环)
		 */
		Godown g = new Godown(50);						//Thread t = new Thread(mt);
		/*
		 * 之前卖票的
		 * Thread t1 =new Thread(new(MyThread3));
		 * Thread t2 =new Thread(new(MyThread3));
		 * Thread t3 =new Thread(new(MyThread3));
		 * Thread t4 =new Thread(new(MyThread3));
		 * 4个new 出来4个对象 所以这样会出现各自卖完100张票,共卖了400张票
		 * 这里new出3个生产者,6个消费者, 他们的对象是不同的,但他们的生产和消费所在的仓库是同一个g(构造函数的传的参数相同),而同步函数就在Godown里面
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

	public void demo5() {		//生产者消费者模型2 Lock,Condition
		// TODO Auto-generated method stub
		/**
		 * 
		 * 生产者——消费者模型2
		 * 1.生产一个就要消费一个
		 * 2.生产线程和消费线程有多个
		 * 
		 * 
		 * Lock接口 提供了比synchronized 更广泛的锁定操作
		 * 实现ReentrantLock,ReentrantReadWriteLock.ReadLock,ReentrantReadWriteLock.WriteLock
		 * 方法摘要：
		 * lock();								获取锁
		 * lockInterruptibly();					如果线程未被中断则获取锁
		 * newCondition();						返回绑定到此lock实例的新Condition实例
		 * tryLock();							仅在调用时锁为空闲的状态才获取该锁
		 * tryLock(long time,timeUnit unit);	如果锁在给定时间内空闲，并且线程未被中断，则获取该锁
		 * unlock();							释放该锁
		 * 
		 * Condition类将Object监视器方法(wait,notify,notifyAll)分解成截然不同的对象,这些对象和Lock对象进行任意组合
		 * Lock代替了synchronized方法和语句的使用,Condition代替了Object监视器方法的使用
		 * 方法摘要
		 * await();								被中断前进入等待状态
		 * await(long time,timeUnit unit);		等待一段时间
		 * awaitNanos(long nanosTimeout);		等待一段时间
		 * awaitUntil(Date deadLine);			等待到某个时刻位置
		 * signal();							唤醒一个等待中的线程
		 * signal();							唤醒所有等待中的线程
		 * 
		 * Objec类的 notifyAll() 会唤醒全部等待进程,而notify();会唤醒任意的进程。不能达到只唤醒消费者或者只唤醒生产者的所有进程
		 * 1个lock实例 可以 对应多个Condition实例
		 * Condition condition_producer = lock.newCondition();
		 * Condition condition_consumer = lock.newCondition();
		 * 
		 * 格式：
		 * Lock lock = new ReentrantLock();				//产生锁对象。Reentrant 再进去的,凹角的
		 * Condition condition = lock.newCondition();	//产生await(),signal(),signalAll()等方法的对象
		 * lock.lock()									//上锁
		 * try{
		 * 		...; await(); ...signal();				//同步的代码
		 * }catcah(InterruptedException e){
		 * 		e.printStackTrace();
		 * }
		 * fially{										//释放所
		 * 	lock.unlock();
		 * }
		 */
		Resource r = new Resource(50);
		
		ProducerNew p1 =new ProducerNew(r,10);
		ProducerNew p2 =new ProducerNew(r,10);
		ConsumerNew c1 =new ConsumerNew(r,10);
		ConsumerNew c2 =new ConsumerNew(r,10);

		Thread t1 = new Thread(p1,"生产者1");
		Thread t2 = new Thread(p2,"生产者2");
		Thread t3 = new Thread(c1,"Consumer1");
		Thread t4 = new Thread(c2,"Consumer2");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public void demo6() {		//停止线程的方法
		// TODO Auto-generated method stub
		/**
		 * 线程的停止stop();
		 * public void stop();	//不建议使用,已过时，要结束进程的方法只有一个,结束run方法
		 * 通常多线程都会有循环结构 。如：while(flag) condition.await();  只要控制循环就可以让run方法结束
		 * 
		 * 特殊情况：  public void synchronized run(){ this.wait(); } ,t1,运行，等待；t2线程获得锁运行，等待；主线程运行完了,
		 * 	t1,t2仍没被唤醒继续运行。
		 * 线程处于冻结状态(wait(),sleep())就不会读取到flag，那么线程就不会结束。这时候用 t1.interrupt();清除所有wait,sleep方法,
		 * 继续运行线程，但会收到InterruptedException异常
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
				//st.changeFlag();				//通过改变flag来控制循环,从而结束run方法结束进程
				break;
			}
			System.out.println("main is running. "+num);
		}
		
	}

	public void demo7() {		//守护线程
		// TODO Auto-generated method stub
		/**
		 * 守护线程
		 * Thread类中的setDaemon();将该线程标记为守护线程或者用户线程或者后台线程。当在运行的线程都是守护线程时,JVM退出。该方法必须在线程启动前调用
		 * 守护线程和前台线程共同抢夺资源,当前台线程全部结束后,后台线程自动结束.
		 * 如果线程B依赖于线程A, 当线程A结束时,线程B也没有用.这时候可以把线程B设置为守护线程，线程A结束后线程B自动结束
		 */
		ThreadDemo7_1 mt = new ThreadDemo7_1();
		
		Thread t1 = new Thread(mt,"t1");
		Thread t2 = new Thread(mt,"t2");
		
		t1.setDaemon(true);				//所有前台线程(非守护线程)结束后,守护线程自动结束,
		t2.setDaemon(true);				// main ... 99 后 t2 :158 ~ t2:164然后程序就结束了
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
		 * join();用来临时加入线程执行。  在线程A中 用线程B线程的join方法, 那么A线程就会等B线程执行完后A才继续执行
		 */
		ThreadDemo8_1 tt = new ThreadDemo8_1();
		Thread t1 = new Thread(tt,"t1");
		Thread t2 = new Thread(tt,"t2");
		
		t1.start();
		//t2.start();						//如果t2在这里,t1抢到main的执行权, t1和 t2交替输出,t1结束后,main才开始运行下面的代码
		try {
			t1.join();						//t1运行完后,t2和main才运行。在main线程里面加t1.join();t1要抢夺main的执行权
		} catch (InterruptedException e) {	//等t1运行完后,main才开始运行,这时候t2还没start(t2.start()在 t1.join()后面)
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
		 * ThreadLocal的作用，在多线程的时候有一些数据不想要别的线程访问。通常是把成员变量放在ThreadLocal中
		 * 内部实现。Map<Thread,T>,T是泛型，是要存储的数据
		 * 1个线程可以存储一个数据。set,get,remove方法都是
		 * 	map.put(Thread.currentThread(),data);
		 * 	map.get(Thread.currentThread());
		 * 	map.remove(Thread.currentThread());
		 * 	键是当前线程,所以被的线程是不能set,get,remove别的线程的数据。
		 */
		final ThreadLocal<String> t1 = new ThreadLocal<>();//内部类访问这里要final
//		t1.set("hello");			//存
//		t1.set("world");//覆盖hello
//		String s = t1.get();		//取
//		t1.remove();				//删
//		System.out.println(t1.get());//world
		
		new Thread(){
			public void run(){
				t1.set("内部类存");
//				System.out.println("内部类"+t1.get());//内部类null
			}
		}.start();
		Thread.sleep(1000);
		System.out.println(t1.get());
	}
}
/*
 *  获得当前线程对象的方法：Thread.currentThread(); 
 *  一旦线程启动，它就永远不能再重新启动。只有一个新的线程可以被启动，并且只能一次。一个可运行的线程或死线程可以被重新启动。
 *  
 * 	开始线程		public void start();	public void run();
 * 	挂起和唤醒线程	public void resume();	public void suspend();已过时  //两个都不建议使用
 * 				public void sleep(long millis);	public void sleep(long millis,int nanos);//毫秒,纳秒
 * 	终止线程		public void stop();	//不建议使用,已过时，要结束进程的方法只有一个,结束run方法	public void interrupt();
 * 	得到线程状态	public boolean isAlive();	public boolean isInterrupt(); 
 * 				public static boolean interrupted();
 *  join()方法的功能就是使异步执行的线程变成同步执行
 *  setPriority(10); 1~10 ,默认是5,10优先级最高
 *  线程的让步使用Thread.yield()方法，yield() 为静态方法，功能是暂停当前正在执行的线程对象，并执行其他线程。
 *  线程的让步含义就是使当前运行着线程让出CPU资源。yield()只能给相同优先级的线程让步,让步的时间设置不了,
 *  但sleep()可以设置时间。使用sleep和yield都会占住对象锁,不建议在同步块和同步函数里使用
 *  
 *  public void stop();	//不建议使用,已过时，要结束进程的方法只有一个,结束run方法
 *  通常多线程都会有循环结构 。如：while(flag) condition.await();  只要控制循环就可以让run方法结束	
 */
