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
	
	
	//˫������ʽ
	private static SingleDoubleLock s ;
	public static SingleDoubleLock getInstance(){
		
		//  3.����Ľ����������жϲ�Ϊ�վ�ֱ�ӳ�ȥ��,û�о����ж�ͬ���Ķ������ǲ�����ͬ������ֻ��һ��ʼ�߳�0��1����3�αȽ�,
		//	����Ľ���ֻ�ý���1�αȽ�,����������ж�,����ͬ�������Ļ�ÿ�����̽�������Ҫ2���ж�
		if(s==null){								//Ϊ�˽��Ч������
			//1.�߳�0��1������������,���Ǻ���ͬ��,ֻ��0��ȥ
			synchronized(SingleDoubleLock.class){	//Ϊ�˽���̰߳�ȫ����
				if(s==null)
				//2.�߳�0���뵽����,����ͬ���߳�1������������жϴ�������s,Ȼ���߳�1,s���ղ�����
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
