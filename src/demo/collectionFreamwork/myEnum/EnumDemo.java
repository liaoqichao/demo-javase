package demo.collectionFreamwork.myEnum;

import demo.collectionFreamwork.CollectionFreamwork;

public class EnumDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * �ؼ���enum	ö���ࡣjdk5.0��
		 * enum Color{
		 * 	RED,GREEN,YELLOW; //����3������Color����
		 * }
		 * ����
		 * class Color{
		 *  private Color(){}//����˽�л�
		 *  public static final Color RED = new Color();
		 *  public static final Color GREEN = new Color();
		 *  public static final Color YELLOW = new Color();
		 * }
		 * 
		 * ö��תArrayList  Collections.list(Enumeration<?> e); ����ArrayList
		 */
		demo1();		//ģ����̵�
	}
	public void demo1(){
		//�õ�ö�ٶ���
//		Color red = Color.RED;
//		Color green = Color.GREEN;
//		Color yellow = Color.YELLOW;
		//�õ�ö�ٵ�����
//		String name = red.name();
		//�õ�ö�ٵ��±�
//		int index = red.ordinal();//��0��ʼ
		Color color = Color.GREEN;
		
		int times = 60;
		while(times!=0){
			
//			switch(color){	//jdk1.6֮��,switch()���������Ƕ�����.֮ǰֻ��3����������
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
//			default:System.out.println("״����");
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
			setTime(15);		//������ﲻ��������ʱ��Ļ���3��ʵ����time����0,�����ֱ�ӻ���ת��״̬������time--
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

	};//����3������Color����
	private int time;//Ҫд��ö��ʵ���ĺ��档
	public int getTime() {
		return time;
	}
	public void setTime(int second){
		time = second;
	}
	private Color(int second){time = second;}	//enum�Ĺ��췽��һ����˽�еġ���������в���,��ôö�ٵĶ���Ҫ������
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
			System.out.println(name()+":"+getTime()+"����");
		}
	}
	//����ö�ٺ�д�˳��󷽷���,Ӧ����ÿ��ʵ����ʵ�ֳ��󷽷���
	public abstract Color turn();
}
/*
 * name():����ö�ٵ�����
 * ordinal():ö�ٵ��±� 
 * valueOf(Class<T> enumType,String name):����һ��ö�ٵĶ���
 * 
 * ����2�������ڱ����ʱ������
 * valueOf(String name) //ת��ö�ٶ���
 * values()//�������ö�ٶ������顣���Ը����±�õ�ö�ٶ���
 */
 