package demo.singleton;

import demo.DemoInterface;

public class Singleton implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//test1();
		//test2();
		//test3();

	}
	public void test1(){
		
		SingleEHS s1 = SingleEHS.getInstance();
		SingleEHS s2 = SingleEHS.getInstance();
		s1.setNum(10);
		System.out.println("Demo1 : s1.getNum() = "+s1.getNum());
		System.out.println("Demo1 : s2.getNum() = "+s2.getNum());
		
	}
	public void test2(){
		
		SingleLHS s1 = SingleLHS.getInstance();
		SingleLHS s2 = SingleLHS.getInstance();
		
		s1.setNum(20);
		System.out.println("Demo2 : s1.getNum() = "+s1.getNum());
		System.out.println("Demo2 : s2.getNum() = "+s2.getNum());
		
	}
	public void test3(){
		
		SingleDoubleLock s1 = SingleDoubleLock.getInstance();
		SingleDoubleLock s2 = SingleDoubleLock.getInstance();
		SingleDoubleLock s3 = SingleDoubleLock.getInstance();
		SingleDoubleLock s4 = SingleDoubleLock.getInstance();
		s1.setNum(30);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		Thread t4 = new Thread(s4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
/*
 * 	模式设计：	人们的代码设计的经验的总结,普遍人都认为这样写可重用代码、让代码更容易被他人理解、保证代码可靠性
 * 	为什么要提倡模式设计？根本原因是提高代码复用,增加可维护性
 * 	java有23种模式设计
 * 	模式设计的原则
 * 	1."开——闭"原则
 * 		对拓展代码开放,对修改代码关闭,尽量少改原来的代码
 * 	2.里氏代换原则
 * 		如果调用父类的话,子类也能完全运行
 * 	3.合成复用原则
 * 		少用继承,多用合成关系来实现
 * 	4.依赖倒转原则
 * 		抽象不能依赖于细节,细节应该依赖于抽象。要针对接口编程,不要针对现实编程
 * 	5.接口隔离原则
 * 		使用多个专门的接口比使用单一的总接口要好。一个类对另外一个类的依赖性应当是建立在最小的接口上的
 * 	6.抽象类
 * 		好的继承关系,应该只有叶子节点是具体类,其他类都是抽象类
 * 	7.迪米特法则
 * 		一个对象应当对其他对象尽可能少的了解
 * 
 *	单例模式设计:一个类中只有1个对象(不能狂new对象)
 *	为了避免其他程序过多建立该类的对象,先控制进制其他程序建立该类对象
 *	为了其他程序可以访问到该类的对象,只好在本类自定义一个对象
 *	为了方便其他程序对该自定义对象的访问,可以提供一些访问方式
 *	实现：
 *	将构造函数私有化
 *	在类中创建一个本类的对象
 *	提供一个方法可以获取到该类对象
 *	形式：饿汉式,懒汉式,双重锁的形式
 *	
 *	饿汉式和懒汉式的区别
 *	饿汉式是线程安全的,在类创建好一个静态对象给系统使用时,以后不再改变
 *	懒汉式如果在创建实例对象时不加上synchronized,则会导致对象的访问不是线程安全的
 */
