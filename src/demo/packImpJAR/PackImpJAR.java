package demo.packImpJAR;
/*
 * �ð���ԭ��1.����������	2.�������	3.ʵ�ַ�װ(public��protected��Ȩ��)
 * Ϊ�˲��������ظ�,����Ҳ�����ظ�������ʹ��url����ɶ���
 * ����	www.bilibili.tv
 * package tv.bilibili.Demo
 * package tv.bilibili.test.myTest
 */

import demo.DemoInterface;
import demo.packImpJAR.pack1.Pack1;//		Ϊ�˼���������д�� import ����.����
import demo.packImpJAR.pack2.Pack2;//		import myPack2.*; 	����myPack2�е�ȫ����
//��Ctrl + Shift + O ��Ҫ�������ȫ���Զ�����,������Զ�ɾ��
import static java.lang.System.out;//��̬����,out�Ǿ�̬�ġ�public final static PrintStream out = null;

public class PackImpJAR implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//demo1_package();
		//demo2_package();

	}

	public void demo1_package() {				//package myPack;����
		// TODO Auto-generated method stub
		out.println("Hello , package");
		
	}

	public void demo2_package() {				//��ͬ��֮��ĵ���,��import����
		// TODO Auto-generated method stub
		Pack1 p1 = new Pack1();						//��ֻ���ǹ����Ĳ�Ȼ���ܵ���
		p1.show();									//�������еķ���ҲҪ�ǹ����Ĳ��ܵ���
		p1.method();								//����Pack1�̳�Pack2�ķ���
		p1.p1Method();								//������Ե��ø���protected����,���ǲ�����p1.method();
													//����Pack2�е�protected����
		Pack2 p2 = new Pack2();						//import myPack2.Pack2;��Ϳ��Ե���Pack2
		p2.method();								//Ҳ���Ե���Pack2�ķ���,����Pack1�Ϳ��Բ��ü̳�Pack2,
													//ֱ���ڷ��ʲ�ͬ�����Ǹ�.java��ͷimport
	}

}
