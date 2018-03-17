package demo.multiThread;

public class ThreadDemo2_1 implements Runnable {

	private int ticket = 100;
	Object obj =new Object();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(obj){						//不加synchronized的话有可能出现剩余-1,-2张票
				if(ticket>0){						//因为到0的时候还没执行减法语句(还是1),另外的线程就执行判断语句ticket=1,		
					try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace();}
					ticket--;						//然后运行减法,ticket=0,然后再执行原来的线程减法语句ticket=-1	
					System.out.println(Thread.currentThread().getName()+"卖了一张票,剩余"+ticket+"张票");
				}
			}
			if(ticket==0){
				System.out.println(Thread.currentThread().getName()+"票卖完了");
				break;
			}
		}
	}
}
/*
 * 锁：当多个线程共用一种临界资源时,为了防止不同线程在同一时间访问同一方法
 * A,B,C要访问同一资源,A先进去,该资源就成了"锁"住的状态,B和C不能进去.等A访问完该资源出来后,B和C优先级高的先访问(假设B),
 * 剩下的A和C继续等
 * synchronized 同步锁
 * 由于synchronized 有可能出现互相等待的状况,则出现死锁(原因：1.加锁次序	2.占有并等待)
 * 
 * 同步的前提：1.是不是有多个线程		2.是不是用同一个锁
 * 
 * 验证同步函数的锁 ：判断这些线程有没有同步
 * 同步函数使用的锁是this
 * 同步代码块：	synchronized(this){要同步的内容} 同步代码块的锁是任意的对象  
 * 			但是如果 if(true)synchronized(obj){...}		else synchronized func(); 
 * 			线程不能同步, 要 synchronized(this)线程才能同步,锁的对象要相同才能同步
 * 同步函数：public synchronized void(){要同步的内容}  同步函数的锁是this
 * 建议使用同步代码块,同步函数可以作为同步代码块的简写形式。如果要同步的对象是this就可以写作同步函数(因为同步函数的锁是this,锁相同才能同步)
 * 
 * 何时需要同步：多个线程同时访问互斥(线程1的x=1,线程2的x就不能为1以外的数)且可交换(多个线程都可以用这一个方法)的数据,应该同步以保护数据,
 * 			多个防止线程同时修改它
 * 
 * 静态函数的锁class
 * 			if synchronized(MyThread.class)<或者synchronized(This.getClass())>{要同步的内容}  
 * 			else static synchronized func();可以同步.
 * 			如果synchronized(别的类名.class)  和  本类的 static synchronized func(); 不能同步
 * 
 * 如果同步方法的话静态方法则一定会同步，非静态方法需在单例模式才生效，推荐用静态方法(不用担心是否单例)。
 * 如果是同步代码块，则对象锁需要编程人员自己指定，一般有些代码为synchronized(this)只有在单态模式才生效；
 *（本类的实例有且只有一个）
 *	MyThread mt1 = new MyThread();		静态方法的话4个线程同步,非静态方法的话t1,t2同步,t3,t4同步
 *	MyThread mt2 = new MyThread();
 *	Thread t1 = new Thread(mt1);
 *	Thread t2 = new Thread(mt1);
 *	Thread t3 = new Thread(mt2);
 *	Thread t4 = new Thread(mt2);
 */