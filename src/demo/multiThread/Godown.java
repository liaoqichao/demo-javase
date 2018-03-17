package demo.multiThread;


public class Godown {

	public static int MAX_NUM = 100;
	private int curNum = 0;
	private boolean canSale;
	private boolean canProduct;
	Godown(){}
	Godown(int curNum){
		this.curNum = curNum;
		canSale = true;
		canProduct = true;
	}
	public  void produce(Godown g,int needNum){				//������Ҫ��ͬ������,��ͬ�������
		synchronized(g){//������ g����g							//ͬ�����������Դ����(ͨ�����캯������ʹ���ǵĲֿ����ʱͬһ������),��Test4.class,Produce.class,Consumer.class,Godown.class������
			
			for(int i = 0 ;!g.canProduct;i++){				//���жϲ���������,������������ȴ�,�Ȼ��Ѻ�˳��ִ�к���Ĵ���
				try {										//**���ж���Ҫ�ȴ������,�Ȼ��Ѻ���ִ�в��õȴ��Ĵ���
					g.wait(100);
					if(i==5)
						break;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			canSale = true;
			g.notifyAll();									//notify();���⻽��һ�����̳߳��еȴ�״̬���߳�
			
			//-------�̱߳����Ѻ�ִ�еĲ���------
			while(needNum+curNum>MAX_NUM){					//�ȴ��̱߳�����,���ж��Ƿ���Ҫ����
				overflow(g,needNum);
			}
			//-----�߳��ٴα����Ѻ�ִ�еĲ���-----
			//if(needNum+curNum>MAX_NUM){					//�ٴβֿ�����������������	
			//	overflow(g,needNum);
			//}
			//else{
				produceGoods(g,needNum);
			//}
		}
	}
	public  void consume(Godown g,int needNum){
		/**
		 * ���߳�1����1����ѭ���Ļ�
		 * synchronized(obj){
		 * while(flag){ 			//��ѭ�������ݴ���,��������2������1�λ�������1������2��
		 * 	obj.wait();
		 * }
		 * �ı�flag
		 * notifyAll();				//��notify();�Ļ��п���ȫ�������ڵȴ�״̬
		 * 
		 */
		synchronized(g){
			for(int i = 0;!g.canSale;i++){					//���жϲ��ܱ����ѣ������ǰ�涼��Ҫ��while������if,��Ȼ���Ѻ��Լ���ͬ���ܵ��̵߳Ļ���û���ж��ܲ��ܱ����Ѿ�ֱ��ȥ������
				try {										//������notifyAll()��Ϊ���»��ѵ��Ǻ��Լ�һ�����߳� . Ȼ��ֻ�������߳̾ͽ�����ѭ��
					g.wait(100);							//���������Ѹ�����ͬ�ľͻ������ѭ��,����i��������������ѭ��(��for����while)
					if(i == 5)					
						break;								//�̶�ģʽ   synchronized(obj){
				} catch (InterruptedException e) {			// 		while(flag){ wait();}
															//		�ı�flag 
					// TODO Auto-generated catch block		//		notifyAll();
					e.printStackTrace();					//	}	���������Ѷ���������ʵ��m�������ߺ�n�������� 
				}											//����1������һ��
				canProduct = true;
				g.notifyAll();
			}
			//----�̱߳����Ѻ�ִ�еĲ���-------
			if(curNum<needNum){								//��ȡ���������,��ô�Ƴ�����?,���ж����Ϊ��������ȴ�,�ȴ�����,
															//�������Ĵ��벻��else,�Ȼ��Ѻ�˳��ִ�д���,�Ϳ��Լ�����
				empty(g,needNum);
			}
			//----�߳��ٴα����Ѻ�ִ�еĲ���-----
			if(curNum<needNum){								//if else ���, �ٿվͲ�����
				empty(g,needNum);
			}
			else{
				consumeGoods(g,needNum);
			}
		}
	}
	private void overflow(Godown g,int needNum){
			System.out.println(Thread.currentThread().getName()+" : Ŀǰ���"+curNum+",Ҫ������"+needNum+"����Ʒ,�����ֿⴢ������"+MAX_NUM+",����ʧ��");
			g.notifyAll();									//�Ȼ��ѱ���߳��Լ��ٵȴ�
			canProduct = false;								//�ֿ�������,����������,������������߳�,������
			canSale = true;
			//System.out.println("canProduct = "+canProduct+" ,canSale = "+canSale);
			try {
				g.wait(100);						
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	private void produceGoods(Godown g,int needNum){	
		curNum = curNum + needNum;
		System.out.println(Thread.currentThread().getName()+" : ������"+needNum+"����Ʒ,�ֿ⹲��"+curNum+"����Ʒ");
		canSale = true;								//�Ѿ�������,�����ܹ���,���Գ�������
		canProduct = false;							//��ʱ��������
		//System.out.println("canProduct = "+canProduct+" ,canSale = "+canSale);	
	}
	private void empty(Godown g,int needNum){
		System.out.println(Thread.currentThread().getName()+" : �ֿ���ʣ��"+curNum+",Ҫ��������Ʒ"+needNum+",�ֿ��治��,����ʧ��");
		canSale = false;
		canProduct = true;
		g.notifyAll();	
		//System.out.println("canProduct = "+canProduct+" ,canSale = "+canSale);
		try {
			g.wait(100);								//����ʱ��Ļ����ᱻ���ѣ���Ϊ�������ܶ���wait()�������Ѿ�����,���ܱ�����						
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void consumeGoods(Godown g,int needNum){
		curNum = curNum - needNum;
		System.out.println(Thread.currentThread().getName()+" : ������"+needNum+"����Ʒ,�ֿ⻹ʣ"+curNum+"����Ʒ");
		canProduct = true;				//�Ѿ�������,��治����������
										//����û��canSale = false, ����еĻ���1����1����,  ������1����Ȼ�����1~n����
		//System.out.println("canProduct = "+canProduct+" ,canSale = "+canSale);		
	}
}
