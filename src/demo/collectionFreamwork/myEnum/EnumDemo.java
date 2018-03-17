package demo.collectionFreamwork.myEnum;

import demo.collectionFreamwork.CollectionFreamwork;

public class EnumDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 关键字enum	枚举类。jdk5.0后
		 * enum Color{
		 * 	RED,GREEN,YELLOW; //它们3个都是Color类型
		 * }
		 * 等于
		 * class Color{
		 *  private Color(){}//构造私有化
		 *  public static final Color RED = new Color();
		 *  public static final Color GREEN = new Color();
		 *  public static final Color YELLOW = new Color();
		 * }
		 * 
		 * 枚举转ArrayList  Collections.list(Enumeration<?> e); 返回ArrayList
		 */
		demo1();		//模拟红绿灯
	}
	public void demo1(){
		//得到枚举对象
//		Color red = Color.RED;
//		Color green = Color.GREEN;
//		Color yellow = Color.YELLOW;
		//得到枚举的名称
//		String name = red.name();
		//得到枚举的下标
//		int index = red.ordinal();//从0开始
		Color color = Color.GREEN;
		
		int times = 60;
		while(times!=0){
			
//			switch(color){	//jdk1.6之后,switch()参数可以是对象了.之前只有3个数据类型
//			case RED:	color.runtime();
//						if(color.getTime()==0)
//							color = color.turn();
//						break;
//			case GREEN:	color.runtime();
//						if(color.getTime()==0)
//							color = color.turn();
//						break;
//			case YELLOW:color.runtime();
//						if(color.getTime()==0)
//							color = color.turn();
//						break;
//			default:System.out.println("状况外");
//			}
			color.runtime();
			if(color.getTime()==0)
				color = color.turn();
			times--;
		}
	}

}
enum Color{
	RED(15) {
		@Override
		public Color turn() {
			// TODO Auto-generated method stub
			setTime(15);		//如果这里不重新设置时间的话。3个实例的time都到0,后面就直接互相转换状态。不用time--
			return valueOf("GREEN");
		}

	},GREEN(10) {
		@Override
		public Color turn() {
			// TODO Auto-generated method stub
			setTime(10);
			return valueOf("YELLOW");
		}

	},YELLOW(5) {
		@Override
		public Color turn() {
			// TODO Auto-generated method stub
			setTime(5);
			return valueOf("RED");
		}

	};//它们3个都是Color类型
	private int time;//要写在枚举实例的后面。
	public int getTime() {
		return time;
	}
	public void setTime(int second){
		time = second;
	}
	private Color(int second){time = second;}	//enum的构造方法一定是私有的。如果里面有参数,那么枚举的对象都要带参数
	public void runtime(){
		if(time>0){
			try {
				print();
				time--;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		else if(time==0){
//			turn();
//		}
	}
		
	public void print(){
		if(time>3)
			System.out.println(name()+":"+getTime());
		else{			
			System.out.println(name()+":"+getTime()+"我闪");
		}
	}
	//当在枚举后写了抽象方法后,应该在每个实例都实现抽象方法。
	public abstract Color turn();
}
/*
 * name():返回枚举的名称
 * ordinal():枚举的下标 
 * valueOf(Class<T> enumType,String name):返回一个枚举的对象
 * 
 * 下面2个方法在编译的时候生成
 * valueOf(String name) //转换枚举对象。
 * values()//获得所有枚举对象数组。可以根据下标得到枚举对象
 */
 