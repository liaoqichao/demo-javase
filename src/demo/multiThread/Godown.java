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
	public  void produce(Godown g,int needNum){				//尽量不要用同步函数,用同步代码块
		synchronized(g){//监视器 g或锁g							//同步锁最好用资源对象(通过构造函数传参使他们的仓库对象时同一个对象),用Test4.class,Produce.class,Consumer.class,Godown.class都可以
			
			for(int i = 0 ;!g.canProduct;i++){				//先判断不可以生产,不可以生产则等待,等唤醒后顺序执行后面的代码
				try {										//**先判断需要等待的情况,等唤醒后再执行不用等待的代码
					g.wait(100);
					if(i==5)
						break;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			canSale = true;
			g.notifyAll();									//notify();任意唤醒一个在线程池中等待状态的线程
			
			//-------线程被唤醒后执行的部分------
			while(needNum+curNum>MAX_NUM){					//等待线程被唤醒,在判断是否需要生产
				overflow(g,needNum);
			}
			//-----线程再次被唤醒后执行的部分-----
			//if(needNum+curNum>MAX_NUM){					//再次仓库溢出则放弃本次生产	
			//	overflow(g,needNum);
			//}
			//else{
				produceGoods(g,needNum);
			//}
		}
	}
	public  void consume(Godown g,int needNum){
		/**
		 * 多线程1生产1消费循环的话
		 * synchronized(obj){
		 * while(flag){ 			//不循环会数据错乱,出现生产2次消费1次或者生产1次消费2次
		 * 	obj.wait();
		 * }
		 * 改变flag
		 * notifyAll();				//用notify();的话有可能全部进程在等待状态
		 * 
		 */
		synchronized(g){
			for(int i = 0;!g.canSale;i++){					//先判断不能被消费，这里和前面都是要用while不能用if,不然唤醒和自己相同功能的线程的话，没有判断能不能被消费就直接去消费了
				try {										//下面用notifyAll()是为了怕唤醒的是和自己一样的线程 . 然后只有消费线程就进入死循环
					g.wait(100);							//生产和消费个数不同的就会进入死循环,设置i计数器来跳出死循环(用for代替while)
					if(i == 5)					
						break;								//固定模式   synchronized(obj){
				} catch (InterruptedException e) {			// 		while(flag){ wait();}
															//		改变flag 
					// TODO Auto-generated catch block		//		notifyAll();
					e.printStackTrace();					//	}	生产和消费都这样可以实现m个生产者和n个消费者 
				}											//生产1个消费一个
				canProduct = true;
				g.notifyAll();
			}
			//----线程被唤醒后执行的部分-------
			if(curNum<needNum){								//是取消这次消费,怎么推迟消费?,先判断如果为不可卖则等待,等待唤醒,
															//这里后面的代码不用else,等唤醒后顺序执行代码,就可以继续卖
				empty(g,needNum);
			}
			//----线程再次被唤醒后执行的部分-----
			if(curNum<needNum){								//if else 语句, 再空就不消费
				empty(g,needNum);
			}
			else{
				consumeGoods(g,needNum);
			}
		}
	}
	private void overflow(Godown g,int needNum){
			System.out.println(Thread.currentThread().getName()+" : 目前库存"+curNum+",要求生产"+needNum+"个商品,超过仓库储存上限"+MAX_NUM+",生产失败");
			g.notifyAll();									//先唤醒别的线程自己再等待
			canProduct = false;								//仓库已满了,不能再生产,如果再是生产线程,则跳过
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
		System.out.println(Thread.currentThread().getName()+" : 生产了"+needNum+"个商品,仓库共有"+curNum+"个商品");
		canSale = true;								//已经生产了,库存可能够用,可以尝试卖了
		canProduct = false;							//暂时不再生产
		//System.out.println("canProduct = "+canProduct+" ,canSale = "+canSale);	
	}
	private void empty(Godown g,int needNum){
		System.out.println(Thread.currentThread().getName()+" : 仓库库存剩余"+curNum+",要求消费商品"+needNum+",仓库库存不够,消费失败");
		canSale = false;
		canProduct = true;
		g.notifyAll();	
		//System.out.println("canProduct = "+canProduct+" ,canSale = "+canSale);
		try {
			g.wait(100);								//不加时间的话不会被唤醒，因为最后面可能都是wait()，生产已经结束,不能被唤醒						
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void consumeGoods(Godown g,int needNum){
		curNum = curNum - needNum;
		System.out.println(Thread.currentThread().getName()+" : 消费了"+needNum+"个商品,仓库还剩"+curNum+"个商品");
		canProduct = true;				//已经消费了,库存不满可以生产
										//这里没有canSale = false, 如果有的话就1生产1消费,  这里是1生产然后就是1~n消费
		//System.out.println("canProduct = "+canProduct+" ,canSale = "+canSale);		
	}
}
