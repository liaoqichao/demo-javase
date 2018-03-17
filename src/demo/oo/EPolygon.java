package demo.oo;

import java.text.DecimalFormat;

public class EPolygon extends Graph {

	
	private int edge ;									//private�����಻�ܷ���,protected���Է���,
	private double length;								//����ͨ��getEdge()��������ӷ���
	
	DecimalFormat df =new DecimalFormat("######0.00");	//����ʮ�������ĸ�ʽ,0.00��ʾ������λС��,###��������
														//df.format(double);���ص���String����
	//{ System.out.println("���й�������");}				//��������,���Ը����ж�����г�ʼ��,���ж��󶼻������������ͬ����,
														//ÿ����������һ��
	//static { System.out.println("���о�̬�����");}		//ʵ������������ֻ����һ��,new Epolygon()��ʱ��ͼ��ء�
														//�ڶ���new��ʱ���Ѿ����ع����ټ���
														//���ڸ����ʼ��

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
	EPolygon(){											//���캯��,����Ӧ�Ķ����������Եĳ�ʼ��,Ϊʲô���治��EPolygon(3,1)?
		this(3,1);										//���캯���������صĹ��캯��
	}
	EPolygon(int edge,double length){					//���캯������
		this.edge =edge;
		this.length = length;
	}
	
	public int getDiagonal(){
		return edge*(edge-3)/2;
	}
	
	@Override
	public String getPerimeter() {
		// TODO Auto-generated method stub
		{}												//{}�ֲ������,�������ƾֲ���������������
		return df.format(edge*length);
	}

	@Override
	public String getArea() {
		// TODO Auto-generated method stub
		/*
		 * ������������ʽ��(����*�߳�*�߳�)/(4*Math.tan((180/����)*Math.PI/180))
		 * �����������ӵ������������,�γ�n��ȫ�ȵĵ���������,�Ƕ�Ϊ360/n,����ÿ�������ε����Ȼ��*n�õ�����������
		 * tan(double) ������ǻ���ֵ.  ���� = �Ƕ� *��/180	�Ƕ� =(����/��)*180
		 */
		double area = (edge*length*length)/(4*Math.tan(Math.PI/edge));
		return df.format(area);
	}

}
