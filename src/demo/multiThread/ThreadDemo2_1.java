package demo.multiThread;

public class ThreadDemo2_1 implements Runnable {

	private int ticket = 100;
	Object obj =new Object();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(obj){						//����synchronized�Ļ��п��ܳ���ʣ��-1,-2��Ʊ
				if(ticket>0){						//��Ϊ��0��ʱ��ûִ�м������(����1),������߳̾�ִ���ж����ticket=1,		
					try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace();}
					ticket--;						//Ȼ�����м���,ticket=0,Ȼ����ִ��ԭ�����̼߳������ticket=-1	
					System.out.println(Thread.currentThread().getName()+"����һ��Ʊ,ʣ��"+ticket+"��Ʊ");
				}
			}
			if(ticket==0){
				System.out.println(Thread.currentThread().getName()+"Ʊ������");
				break;
			}
		}
	}
}
/*
 * ����������̹߳���һ���ٽ���Դʱ,Ϊ�˷�ֹ��ͬ�߳���ͬһʱ�����ͬһ����
 * A,B,CҪ����ͬһ��Դ,A�Ƚ�ȥ,����Դ�ͳ���"��"ס��״̬,B��C���ܽ�ȥ.��A���������Դ������,B��C���ȼ��ߵ��ȷ���(����B),
 * ʣ�µ�A��C������
 * synchronized ͬ����
 * ����synchronized �п��ܳ��ֻ���ȴ���״��,���������(ԭ��1.��������	2.ռ�в��ȴ�)
 * 
 * ͬ����ǰ�᣺1.�ǲ����ж���߳�		2.�ǲ�����ͬһ����
 * 
 * ��֤ͬ���������� ���ж���Щ�߳���û��ͬ��
 * ͬ������ʹ�õ�����this
 * ͬ������飺	synchronized(this){Ҫͬ��������} ͬ����������������Ķ���  
 * 			������� if(true)synchronized(obj){...}		else synchronized func(); 
 * 			�̲߳���ͬ��, Ҫ synchronized(this)�̲߳���ͬ��,���Ķ���Ҫ��ͬ����ͬ��
 * ͬ��������public synchronized void(){Ҫͬ��������}  ͬ������������this
 * ����ʹ��ͬ�������,ͬ������������Ϊͬ�������ļ�д��ʽ�����Ҫͬ���Ķ�����this�Ϳ���д��ͬ������(��Ϊͬ������������this,����ͬ����ͬ��)
 * 
 * ��ʱ��Ҫͬ��������߳�ͬʱ���ʻ���(�߳�1��x=1,�߳�2��x�Ͳ���Ϊ1�������)�ҿɽ���(����̶߳���������һ������)������,Ӧ��ͬ���Ա�������,
 * 			�����ֹ�߳�ͬʱ�޸���
 * 
 * ��̬��������class
 * 			if synchronized(MyThread.class)<����synchronized(This.getClass())>{Ҫͬ��������}  
 * 			else static synchronized func();����ͬ��.
 * 			���synchronized(�������.class)  ��  ����� static synchronized func(); ����ͬ��
 * 
 * ���ͬ�������Ļ���̬������һ����ͬ�����Ǿ�̬�������ڵ���ģʽ����Ч���Ƽ��þ�̬����(���õ����Ƿ���)��
 * �����ͬ������飬���������Ҫ�����Ա�Լ�ָ����һ����Щ����Ϊsynchronized(this)ֻ���ڵ�̬ģʽ����Ч��
 *�������ʵ������ֻ��һ����
 *	MyThread mt1 = new MyThread();		��̬�����Ļ�4���߳�ͬ��,�Ǿ�̬�����Ļ�t1,t2ͬ��,t3,t4ͬ��
 *	MyThread mt2 = new MyThread();
 *	Thread t1 = new Thread(mt1);
 *	Thread t2 = new Thread(mt1);
 *	Thread t3 = new Thread(mt2);
 *	Thread t4 = new Thread(mt2);
 */