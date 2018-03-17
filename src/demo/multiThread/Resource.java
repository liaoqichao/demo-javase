package demo.multiThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

	private  int curNum;
	public static int MAX_NUM = 100;
	private boolean canProduce = true;
	private boolean canSale = true;
	private Lock lock = new ReentrantLock();					//�½���
	private Condition condition_producer = lock.newCondition();	//�½�condition ,������await,signal �ĵȴ����ѷ���
	private Condition condition_consumer = lock.newCondition();
	Resource(){}
	Resource( int num){
		this.curNum = num;
	}
	
	public void produce(Resource r,int needNum){
		
		lock.lock();  									//������Ҫͬ�������������� //synchronized(r){
		try{
			while(!canProduce)
				condition_producer.await();   			//wait(); try����������,��Ϊ����ָ�finally{lock.unlock()}
			canSale = true;
			condition_consumer.signal();				//notifyAll(); һ��lock����2����Ӧ��conditionʵ��,����
														//�Ͳ���signalAll();��ȫ���߳�(�ر��ǲ�Ӧ�ð������߻���)����,ֻ����һ�����������߾Ϳ���
			if(needNum+curNum>MAX_NUM){
				System.out.println(Thread.currentThread().getName()+" : Ŀǰ���"+curNum+",Ҫ������"+needNum+"����Ʒ,�����ֿⴢ������"+MAX_NUM+",����ʧ��");
				condition_consumer.signal(); 		//r.notifyAll();
				canProduce = false;
				canSale = true;
				condition_producer.await();				//r.wait();
			}
			else{
				curNum = curNum + needNum;
				System.out.println(Thread.currentThread().getName()+" : ������"+needNum+"����Ʒ,�ֿ⹲��"+curNum+"����Ʒ");
				canProduce = false;
				canSale = true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{										//}
			lock.unlock();  							//ͬ������,�ͷ���
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
				System.out.println(Thread.currentThread().getName()+" : �ֿ���ʣ��"+curNum+",Ҫ��������Ʒ"+needNum+",�ֿ��治��,����ʧ��");
				canSale = false;
				canProduce = true;
				condition_producer.signal();			//r.notifyAll();	
				condition_consumer.await();				//r.await();
			}
			else{
				curNum = curNum - needNum;
				System.out.println(Thread.currentThread().getName()+" : ������"+needNum+"����Ʒ,�ֿ⻹ʣ"+curNum+"����Ʒ");
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
