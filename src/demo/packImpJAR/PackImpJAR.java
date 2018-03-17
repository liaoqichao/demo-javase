package demo.packImpJAR;
/*
 * 用包的原因：1.避免类重名	2.方便管理	3.实现封装(public，protected等权限)
 * 为了不让类名重复,包名也不能重复，建议使用url来完成定义
 * 例如	www.bilibili.tv
 * package tv.bilibili.Demo
 * package tv.bilibili.test.myTest
 */

import demo.DemoInterface;
import demo.packImpJAR.pack1.Pack1;//		为了简化类名的书写。 import 包名.类名
import demo.packImpJAR.pack2.Pack2;//		import myPack2.*; 	导入myPack2中的全部类
//按Ctrl + Shift + O 需要导入的类全部自动导入,多余的自动删除
import static java.lang.System.out;//静态导入,out是静态的。public final static PrintStream out = null;

public class PackImpJAR implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//demo1_package();
		//demo2_package();

	}

	public void demo1_package() {				//package myPack;建包
		// TODO Auto-generated method stub
		out.println("Hello , package");
		
	}

	public void demo2_package() {				//不同包之间的调用,用import导入
		// TODO Auto-generated method stub
		Pack1 p1 = new Pack1();						//类只能是公共的不然不能调用
		p1.show();									//公共类中的方法也要是公共的才能调用
		p1.method();								//调用Pack1继承Pack2的方法
		p1.p1Method();								//子类可以调用父类protected方法,但是不能用p1.method();
													//调用Pack2中的protected方法
		Pack2 p2 = new Pack2();						//import myPack2.Pack2;后就可以调用Pack2
		p2.method();								//也可以调用Pack2的方法,这样Pack1就可以不用继承Pack2,
													//直接在访问不同包的那个.java开头import
	}

}
