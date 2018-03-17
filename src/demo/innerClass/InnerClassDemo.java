package demo.innerClass;

import demo.DemoInterface;

public class InnerClassDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * �������ڲ���������ʱ,���ڲ����������ڲ�������
		 * �ڲ��������Ϊ�ⲿ��ĳ�Ա,Ҳ������Ϊ�ⲿ���Ա������һ���ֲ��ڲ���,���ھֲ����ܱ�static,private������
		 */
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
	}

	public void demo1(){		//�ڲ���
		/*
		 * �ڲ�����ʹ���
		 * 1.�ڲ�����Է����ⲿ��ĳ�Ա(����˽��)
		 * 2.�ⲿ������ڲ�����뽨���ڲ������
		 */
		Outer out = new Outer();
		out.show();	//Outer : 3
		out.showInner();//Inner : 4
		
		/*
		 * ֱ�ӷ����ڲ���ĳ�Ա
		 * ����ͨ������������д,��Ϊͨ���ڲ��඼��˽������,ֻ�ܱ��ⲿ�����
		 * private class Inner{}
		 * ֻ���ڲ����ܱ�˽��
		 */
		Outer.Inner in = new Outer().new Inner();
		in.show();//Inner : 4
		in.showOuter();//Outer.this.x = Inner : 3		//this.x = Inner : 5
		
	}
	public void demo2(){		//��̬�ڲ���
		/*
		 * �ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա
		 * ע��:
		 * 1.���ڲ����ж����˾�̬��Ա,���ڲ�������Ǿ�̬��
		 * 2.�ⲿ�ྲ̬���������ڲ���ʱ,�ڲ���Ҳ�����Ǿ�̬��,���ڲ����Ա���Բ��Ǿ�̬
		 */
		//ֱ�ӷ��ʾ�̬�ڲ���
		new Outer.Inner2().show();//��Ϊshow�������Ǿ�̬��,����Ҫ�ö������
		Outer.Inner2.show2();
		Outer.method();//Inner.x = 5   , Inner.y = 4
	}
	public void demo3(){		//�ֲ��ڲ���
		/*
		 * �ֲ��ڲ��಻�ܱ���Ա���η�����(staic,private��)
		 */
		Outer out = new Outer();
		out.method1();
	}
	public void demo4(){		//�����ڲ���
		/* 
		 * 1.�����ڲ�������ڲ���ļ�д��ʽ
		 * 2.�����ڲ����ǰ�᣺����̳�һ����(GUI��WindowAdapter�̳���WindowListener)����ʵ��һ����Ľӿ�
		 * 3.��������ķ���ֻ�ܵ���һ��
		 * 4.д������������Ϊ�˼���д,ʵ�ֽӿ�,ʵ�ֻ򸲸Ǹ���ķ�����һ�㲻�������Լ��ķ���
		 * ���������߽ӿڵĳ��󷽷��ر��,�����������ڲ���,Ҫдһ�󴮡�����WindowListener�ķ��������ǳ����(�������зǳ��󷽷�).
		 * 5.���������ڲ����ʽ��
		 * new �����ӿ�(���캯����Ҫ�Ĳ���){ �������������(ʵ�ֳ��󷽷�) }
		 * 6.���������ڲ���ķ���
		 * new �����ӿ�(���캯����Ҫ�Ĳ���){ �������������(ʵ�ֳ��󷽷������Լ������ķ���) a(){} }.a();
		 */
		Outer out = new Outer();
		out.method2();
	}
	public void demo5(){			//�����ڲ�����ϰ
		Demo5Test.function().show();
		//function��Demo5Test��һ����̬����,
		//����������Inter���͵Ķ���(�ӿ����ͻ��߸�������)
		//Ȼ����ø��ǻ���ʵ�ֵ�show����
		
		//�����÷���frame��addWindowListener(WindowAdapter(){ʵ��}) { ...}
		new Outer().demo5test(new Inter(){

			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("demo5,test2");
			}
			
		});
	}
}
class Outer{
	/*
	 * ���ⲿ��Ա,�ڲ���Ա,�ڲ��ֲ��������е�ʱ��
	 * �оֲ������͵��þֲ�����,û�о͵����ڲ���Ա,��û�оʹ����ⲿ��Ա
	 */
	private  final int x = 3;
	void show(){
		System.out.println("Outer : "+x);
	}
	void showInner(){
		Inner in = new Inner();
		in.show();
	}
	/*private*/ class Inner{
		private final int y = 4;
//		private final int x = 5;
		void show(){
			System.out.println("Inner : "+y);
//			show();//���õ����ڲ����show
		}
		void showOuter(){
			//�ڲ�������ⲿ���������� ��ʽ: �ⲿ����.this
			System.out.println("Inner : "+Outer.this.x);//��ӡ�ⲿ���x
		}
	}
	static class Inner2{
		private int y = 4;
		private int x = 5;
		void show(){
			System.out.println("Inner.x = "+x+"   , Inner.y = "+y);
			//���ܷ����ⲿ���x,��Ϊx�Ǿ�̬
		}
		static void show2(){			//һ�㲻����ôд
			System.out.println("���ʾ�̬�ڲ���ľ�̬��Ա");
		}
	}
	static void method(){		
		//�ⲿ�ྲ̬���������ڲ���ʱ,�ڲ���Ҳ�����Ǿ�̬��,���ڲ����Ա���Բ��Ǿ�̬
		new Outer.Inner2().show();
	}
	
	void method1(){
		int x = 5;
		class Inner3{
			void show(){
				System.out.println("Inner3 is showed.");
				System.out.println("�ֲ�����Ҫfianl����,�ֲ��ڲ�����ܷ��� :"+x);//Ϊʲô����finalҲkeyi?
			}
		}
		new Inner3().show();
	}
	void method2(){
		new AbstractClass(){

			@Override
			void abMethod() {
				// TODO Auto-generated method stub
				System.out.println("Inner4 extends AbstractClass");
				System.out.println("Outer.x = "+x);
			}
			
		}.abMethod();
	}
	public void demo5test(Inter i){
		i.show();
	}
	
}

abstract class AbstractClass{
	abstract void abMethod();
}

class Demo5Test{
	public static Inter function(){
		return new Inter(){
			public void show(){
				System.out.println("demo5");
			}
		};
	}
}
interface Inter{
	public abstract void show();
}