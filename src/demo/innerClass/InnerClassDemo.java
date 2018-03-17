package demo.innerClass;

import demo.DemoInterface;

public class InnerClassDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 当事物内部还有事物时,用内部类来描述内部的事物
		 * 内部类可以作为外部类的成员,也可以作为外部类成员方法的一个局部内部类,但在局部不能被static,private等修饰
		 */
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
	}

	public void demo1(){		//内部类
		/*
		 * 内部类访问规则：
		 * 1.内部类可以访问外部类的成员(包括私有)
		 * 2.外部类访问内部类必须建立内部类对象
		 */
		Outer out = new Outer();
		out.show();	//Outer : 3
		out.showInner();//Inner : 4
		
		/*
		 * 直接访问内部类的成员
		 * 但是通常都不会这样写,因为通常内部类都被私有修饰,只能被外部类访问
		 * private class Inner{}
		 * 只有内部类能被私有
		 */
		Outer.Inner in = new Outer().new Inner();
		in.show();//Inner : 4
		in.showOuter();//Outer.this.x = Inner : 3		//this.x = Inner : 5
		
	}
	public void demo2(){		//静态内部类
		/*
		 * 内部类只能访问外部类的静态成员
		 * 注意:
		 * 1.当内部类中定义了静态成员,该内部类必须是静态的
		 * 2.外部类静态方法访问内部类时,内部类也必须是静态的,但内部类成员可以不是静态
		 */
		//直接访问静态内部类
		new Outer.Inner2().show();//因为show方法不是静态的,所以要用对象调用
		Outer.Inner2.show2();
		Outer.method();//Inner.x = 5   , Inner.y = 4
	}
	public void demo3(){		//局部内部类
		/*
		 * 局部内部类不能被成员修饰符修饰(staic,private等)
		 */
		Outer out = new Outer();
		out.method1();
	}
	public void demo4(){		//匿名内部类
		/* 
		 * 1.匿名内部类就是内部类的简写格式
		 * 2.匿名内部类的前提：必须继承一个类(GUI中WindowAdapter继承了WindowListener)或者实现一个类的接口
		 * 3.匿名对象的方法只能调用一次
		 * 4.写匿名函数就是为了简化书写,实现接口,实现或覆盖父类的方法。一般不会新增自己的方法
		 * 如果父类或者接口的抽象方法特别多,不建议匿名内部类,要写一大串。所以WindowListener的方法都不是抽象的(抽象类有非抽象方法).
		 * 5.创建匿名内部类格式：
		 * new 父类或接口(构造函数需要的参数){ 定义子类的内容(实现抽象方法) }
		 * 6.调用匿名内部类的方法
		 * new 父类或接口(构造函数需要的参数){ 定义子类的内容(实现抽象方法或者自己新增的方法) a(){} }.a();
		 */
		Outer out = new Outer();
		out.method2();
	}
	public void demo5(){			//匿名内部类练习
		Demo5Test.function().show();
		//function是Demo5Test的一个静态方法,
		//返回类型是Inter类型的对象(接口类型或者父类类型)
		//然后调用覆盖或者实现的show方法
		
		//常见用法如frame中addWindowListener(WindowAdapter(){实现}) { ...}
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
	 * 当外部成员,内部成员,内部局部变量都有的时候
	 * 有局部变量就调用局部变量,没有就调用内部成员,再没有就代用外部成员
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
//			show();//调用的是内部类的show
		}
		void showOuter(){
			//内部类持有外部类对象的引用 格式: 外部类名.this
			System.out.println("Inner : "+Outer.this.x);//打印外部类的x
		}
	}
	static class Inner2{
		private int y = 4;
		private int x = 5;
		void show(){
			System.out.println("Inner.x = "+x+"   , Inner.y = "+y);
			//不能访问外部类的x,因为x非静态
		}
		static void show2(){			//一般不会这么写
			System.out.println("访问静态内部类的静态成员");
		}
	}
	static void method(){		
		//外部类静态方法访问内部类时,内部类也必须是静态的,但内部类成员可以不是静态
		new Outer.Inner2().show();
	}
	
	void method1(){
		int x = 5;
		class Inner3{
			void show(){
				System.out.println("Inner3 is showed.");
				System.out.println("局部变量要fianl修饰,局部内部类才能访问 :"+x);//为什么不用final也keyi?
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