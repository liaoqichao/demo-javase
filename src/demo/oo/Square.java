package demo.oo;

import java.text.DecimalFormat;

public class Square extends EPolygon {

	private static final int edge = 4;
	Square(){
		this(1);
	}
	Square(double length){
		super(edge,length);
	}
	public String getArea(){			//覆盖父类方法,子类方法权限public>=父类方法public,可以覆盖
		DecimalFormat df =new DecimalFormat("######0.00");
		double area = super.getLength()*super.getLength();	
		return df.format(area);			//return String.valueOf(area);
	}
}

/*
 * 继承提高了代码的复用性
 * 继承让类与类之间产生关系,给多态提供了前提
 * 
 * 覆盖的注意事项：
 * 1.子类方法覆盖方法时,子类权限必须大于等于父类的权限 public>protected>default(friendly)>private
 * 	 如果父类方法时private的时候子类根本就用不了,不叫覆盖
 * 2.覆盖和被覆盖的方法可以同时为为static,但不能其中一个为static,另外一个非static。
 * 	 静态方法只能覆盖静态方法,或者静态方法只能被静态方法覆盖
 * 
 * 什么时候使用覆盖？
 * 1.当一个类进行子类的扩展时,子类需要保留父类的功能声明,但是要定义子类中该功能的特有内容时,就使用覆盖操作来完成,
 * 	这样可以减少对代码的修改.如程序的版本升级
 * 
 * 子类隐藏成员变量或者成员方法时(子类和父类有同名的变量或者函数),有时候还需要用到父类的成员变量和成员方法,可以用super.length来调用
 * 父类的成员变量或成员方法
 * super相当于this,this是本类对象的引用,super是父类的对象的引用。如果子类和父类都有func(),那么super.func();调用的是父类的函数,
 * 没加super调用的是本类的函数
 * 
 * 
 * 多态
 * 一个对象对应不同的类型：如a是动物,a是动物类的一个实例,a是猫,a也是猫类的一个实例
 * 多态存在的必要条件
 * 1.要有继承
 * 2.要有重写
 * 3.父类引用指向子类对象
 * func1(Graph g){ g.funcXX(); }  
 * func(){ Circle c;func1(c); }
 * 
 * 多态的作用
 * 提高代码的扩展性,便于以后维护,前期的代码(一开始写的)可以使用后期的代码(更新,升级,内容拓展的)
 * 限定子类的功能
 * 多态的局限性
 * 前期定义的内容不能使用后期子类特有的内容
 * 
 * 多态的特点
 * 1.成员变量
 * 	Class A{ int x=3; }
 * 	Class B extends A{ int x=4;int y=5; }
 * B b =new B();  x = 4;
 * A a =new B();  x = 3; y 编译错误 , 父类没有y
 *  编译和运行(x的值)都只看左边 引用型变量(a,b)所属的类中(最左边的A,B) 是否有该成员变量
 *  
 * 2.成员函数
 *  Class A				{  x(){sop("aa");}       }
 *  Class B extends A	{  x(){sop("bb");}  y(); }
 *	A a =new B(); //a.x(); 调用子类方法 sop("bb");  a.y();报错,A类中没有y()方法;
 *	编译看左边A 运行(调用函数)看右边B
 *
 * 3.静态成员
 *	编译和运行都看左边
 */ 

