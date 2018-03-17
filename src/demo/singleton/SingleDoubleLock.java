package demo.singleton;

public class SingleDoubleLock implements Runnable {

	private int num;
	private SingleDoubleLock(){
		super();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	//双重锁形式
	private static SingleDoubleLock s ;
	public static SingleDoubleLock getInstance(){
		
		//  3.后面的进程在这里判断不为空就直接出去了,没有经过判断同步的对象锁是不是相同。这样只有一开始线程0和1进行3次比较,
		//	后面的进程只用进行1次比较,而不用外层判断,而用同步方法的话每个进程进来都需要2次判断
		if(s==null){								//为了解决效率问题
			//1.线程0和1都进来了这里,但是后面同步,只有0进去
			synchronized(SingleDoubleLock.class){	//为了解决线程安全问题
				if(s==null)
				//2.线程0进入到这里,由于同步线程1进不来，完成判断创建对象s,然后到线程1,s不空不创建
					s = new SingleDoubleLock();
			}
		}
		return s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" = "+getNum());
		
	}
}
