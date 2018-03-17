package demo.oo;

import demo.oo.Sector;

import java.text.DecimalFormat;


public final class Circle extends Sector{				//final
														
	private double radius;								

	DecimalFormat df =new DecimalFormat("######0.00");
	Circle(double radius ){
		super(radius,360);
		this.radius = radius;
	}
	Circle(){
		this(1);
	}
	
	public String getPerimeter() {
		return df.format(2*Math.PI*radius);
	}
	public String getArea() {
		return df.format(Math.PI*radius*radius);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
/*
 * final修饰类
 * 被final修饰的类不能当父类,不能被继承
 * 
 * final修饰方法
 * 类的private方法会被隐式的被指定为final
 * 使用final的原因：把方法锁定,以防任何子类修改它的含义
 * 
 * final修饰变量
 * 被final修饰的基本数据类型变量不能更改 final int x = 0;  x = 1; error
 * 被final修饰的引用类型变量,被初始化后不能再指向另外一个对象 
 * final Object obj =new Object();  obj = new Object();//error 
 * 虽然不能重新指向新的Object, 但是obj的内容时可以改变的
 */