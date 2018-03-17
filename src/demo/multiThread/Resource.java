package demo.multiThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

	private  int curNum;
	public static int MAX_NUM = 100;
	private boolean canProduce = true;
	private boolean canSale = true;
	private Lock lock = new ReentrantLock();					//新建锁
	private Condition condition_producer = lock.newCondition();	//新建condition ,里面有await,signal 的等待唤醒方法
	private Condition condition_consumer = lock.newCondition();
	Resource(){}
	Resource( int num){
		this.curNum = num;
	}
	
	public void produce(Resource r,int needNum){
		
		lock.lock();  									//进到需要同步的内容先锁上 //synchronized(r){
		try{
			while(!canProduce)
				condition_producer.await();   			//wait(); try语句放在外面,因为最后又个finally{lock.unlock()}
			canSale = true;
			condition_consumer.signal();				//notifyAll(); 一个lock产生2个对应的condition实例,这样
														//就不用signalAll();把全部线程(特别是不应该把生产者唤醒)唤醒,只唤醒一个任意消费者就可以
			if(needNum+curNum>MAX_NUM){
				System.out.println(Thread.currentThread().getName()+" : 目前库存"+curNum+",要求生产"+needNum+"个商品,超过仓库储存上限"+MAX_NUM+",生产失败");
				condition_consumer.signal(); 		//r.notifyAll();
				canProduce = false;
				canSale = true;
				condition_producer.await();				//r.wait();
			}
			else{
				curNum = curNum + needNum;
				System.out.println(Thread.currentThread().getName()+" : 生产了"+needNum+"个商品,仓库共有"+curNum+"个商品");
				canProduce = false;
				canSale = true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{										//}
			lock.unlock();  							//同步结束,释放锁
		}
	
	}
	public void consume(Resource r,int needNum){
		lock.lock();									//synchronized(r){
		try{
			while(!canSale)
				condition_consumer.await();				//await();
			canProduce = true;
			condition_producer.signal();				//notifyAll();
			//
			if(curNum<needNum){
				System.out.println(Thread.currentThread().getName()+" : 仓库库存剩余"+curNum+",要求消费商品"+needNum+",仓库库存不够,消费失败");
				canSale = false;
				canProduce = true;
				condition_producer.signal();			//r.notifyAll();	
				condition_consumer.await();				//r.await();
			}
			else{
				curNum = curNum - needNum;
				System.out.println(Thread.currentThread().getName()+" : 消费了"+needNum+"个商品,仓库还剩"+curNum+"个商品");
				canProduce = true;				
				canSale = false;
			}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{											//}
			lock.unlock();
		}
	}
}
