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
 * final������
 * ��final���ε��಻�ܵ�����,���ܱ��̳�
 * 
 * final���η���
 * ���private�����ᱻ��ʽ�ı�ָ��Ϊfinal
 * ʹ��final��ԭ�򣺰ѷ�������,�Է��κ������޸����ĺ���
 * 
 * final���α���
 * ��final���εĻ����������ͱ������ܸ��� final int x = 0;  x = 1; error
 * ��final���ε��������ͱ���,����ʼ��������ָ������һ������ 
 * final Object obj =new Object();  obj = new Object();//error 
 * ��Ȼ��������ָ���µ�Object, ����obj������ʱ���Ըı��
 */