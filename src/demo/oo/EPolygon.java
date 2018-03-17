package demo.oo;

import java.text.DecimalFormat;

public class EPolygon extends Graph {

	
	private int edge ;									//private后子类不能访问,protected可以访问,
	private double length;								//可以通过getEdge()方法来间接访问
	
	DecimalFormat df =new DecimalFormat("######0.00");	//设置十进制数的格式,0.00表示保留两位小数,###代表数字
														//df.format(double);返回的是String类型
	//{ System.out.println("运行构造代码块");}				//构造代码块,可以给所有对象进行初始化,所有对象都会代码块里面的相同操作,
														//每个对象都运行一次
	//static { System.out.println("运行静态代码块");}		//实例化两个对象但只运行一次,new Epolygon()的时候就加载。
														//第二次new的时候已经加载过不再加载
														//用于给类初始化

	public final int getEdge() {
		return edge;
	}
	public final void setEdge(int edge) {
		this.edge = edge;
	}
	public final double getLength() {
		return length;
	}
	public final void setLength(double length) {
		this.length = length;
	}
	EPolygon(){											//构造函数,给对应的对象进行针对性的初始化,为什么里面不能EPolygon(3,1)?
		this(3,1);										//构造函数调用重载的构造函数
	}
	EPolygon(int edge,double length){					//构造函数重载
		this.edge =edge;
		this.length = length;
	}
	
	public int getDiagonal(){
		return edge*(edge-3)/2;
	}
	
	@Override
	public String getPerimeter() {
		// TODO Auto-generated method stub
		{}												//{}局部代码块,用来控制局部变量的生命周期
		return df.format(edge*length);
	}

	@Override
	public String getArea() {
		// TODO Auto-generated method stub
		/*
		 * 正多边形面积公式：(边数*边长*边长)/(4*Math.tan((180/边数)*Math.PI/180))
		 * 各个定点链接到正多边形中心,形成n个全等的等腰三角形,角度为360/n,计算每个三角形的面积然后*n得到正多边形面积
		 * tan(double) 里面的是弧度值.  弧度 = 角度 *π/180	角度 =(弧度/π)*180
		 */
		double area = (edge*length*length)/(4*Math.tan(Math.PI/edge));
		return df.format(area);
	}

}
