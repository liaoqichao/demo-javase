package demo.oo;


public abstract class Graph {						//�����಻��ʵ��������

	 Graph(){}
	 public abstract String getPerimeter();
	 public abstract String getArea();
	 public void statement(){ System.out.println("���ó�����ķǳ��󷽷�"); }
}
/*
 * ע�⣺
 * 1.������ķ�����һ��ȫ�����ǳ��󷽷�
 * 2.���������������Ƿǳ�����,����һ��Ҫʵ�����и����еĳ��󷽷�;��������������Ҳ�ǳ�����,����ֻʵ��һ���ֳ��󷽷�
 * 
 * ����������ã�
 * 1.���Խ�����������,�������һ��̶��ĳ�������,������̶����������������������ʵ�ַ�ʽ
 * 2.ͨ������������,Ҳ������չ��ģ�����Ϊ���ܡ���������ʵ�ֿ��Źر�ԭ��(Open-Closed Principle)�Ĺؼ���
 * 	���Źر�ԭ��(Open-Closed Principle)
 * 		����չ����  : ģ�����Ϊ���Ա���չ�Ӷ������µ�����
 * 		���޸Ĺر� : �������޸�ģ���Դ���롣�����߾���ʹ�޸���С����
 * 3.������������������������������з���������еó��ĳ������Ƕ�һϵ�п���ȥ��ͬ�����Ǳ�������ͬ�ľ������ĳ���
 * 
 * 
 */ 