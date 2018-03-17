package demo.exception;


import java.util.Scanner;

import demo.DemoInterface;

public class ExceptionCaptureThrow implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//demo1_exception();
		//demo2_exception();
		//demo3_exception();

	}
	public void demo1_exception(){
		
		System.out.println("�����뱻�����ͳ���");
		Scanner scanner =new Scanner(System.in);
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		try{ devide(a,b); }
		catch(Exception e){										//���쳣��ִ��
			System.out.println("��������Ϊ0");
		}
		finally{
			System.out.println("����");							//������û���쳣����ִ��
			scanner.close();
		}
	}
	public static void devide(double a ,double b)throws Exception{//throw�����׳��쳣����,����������쳣����,д�ں�������
			  												//throws���������,д�ں�����
		if(b==0)
		throw new Exception();								//�쳣���׸�������,�õ����߽���쳣
		double c = a/b;
		System.out.println(c);
	}
	public void demo2_exception(){
		
		System.out.println("������һ������");
		Scanner scanner =new Scanner(System.in);
		try{
			int a = scanner.nextInt();
			System.out.println(a);
		}
		catch(Exception e){ System.out.println("�������,������������"); }
		finally {scanner.close();}
	}
	public void demo3_exception(){
		
		try{
			getDiagonal();								//��throws MyException,���ܳ����쳣,
														//������(test3_Exception())һ��Ҫ�����쳣									
		}
		catch(MyException e){
			System.out.println("�������������ڲ����쳣");
			System.out.println("Exception is caught "+e);
		}
	}

	public static void getDiagonal() throws MyException{
		//�����εĶԽ�����
		int n,total;
		System.out.println("������һ�����ڵ���3������");
		Scanner scanner =new Scanner(System.in);
		n = scanner.nextInt();
		if(n<3){
			MyException e =new MyException();
			e.statement();
			scanner.close();
			throw e;		//��������û��throws MyException�Ļ� ,�޷�ʹ��throw
		}	
		total = n*(n-3)/2;
		System.out.println(total);
		scanner.close();
	}

}
class MyException extends Exception{				//�Զ����쳣
	
	/**
	 * �����εĶԽ�����,����α���������3,�����С��3
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyException(){									//���캯��
	}
	public void statement(){
		System.out.println("�������,Ĭ��n=3");
	}	
}
/*
 * �ؼ��֣�try catch finally throws throw
 * 
 * ����׳�����RuntimeException,�����Ͽ��Բ�������throws
 * 
 * throws Exception �������������������ڷ�������
 * 
 * ��ʽ
 * try{���ܷ����쳣} catch(Exception e1){�쳣����1} catch(Exception e2){�쳣����2} ... finally{�쳣����ǰ��ִ�����}
 * ����Ҳ����쳣��Ӧ��catch���,��ִ��ȱʡ���쳣����
 * func(){try{func1},catch(Exception e){...}}   func1(){throw new Exception();}
 * �������׸�������
 * 
 * 
 * �쳣����	�����쳣��ָ�����쳣ʱ�����쳣����������Ӧ��������������,��������ִ����������,
 * 			���û���ҵ��쳣����JVM���ж�Ӧ�ó�������С�
 * �쳣�׳�	�������ɴ�����쳣���������еĳ��򽫴���һ���쳣���󣬸��쳣�����м�¼�˵��³������д����ԭ��ͷ����쳣ʱ�����״̬����Ϣ��
 * 			����ִ�е�throw���ʱ����ֹͣ���ټ���.throwһֱ���׸�������,���ĵ�����һ��Ҫ��trycatch�����쳣
 * 
 * �Զ����쳣���裺
 * 1.�����쳣��
 * Class MyException extends Exception{ ... }
 * 2.�����쳣�����׳��ö���
 * ����1��throw new MyException(); 
 * ����2��MyException e =new MyException();  throw e;
 * 
 * �쳣�����ԭ��
 * 1.������������׳���Ҫ�����쳣,��ô�����ϱ�������
 * 	 ��������ں�������trycatch��׽���������ʧ��
 * 2.��������������쳣�ĺ���,Ҫô��trycatchҪô��throws,�������ʧ��
 * 3.ʲôʱ����catch,ʲôʱ����throws
 * 	 �������ݿ��Խ��,��catch,�������,��throws���ߵ�����,�ɵ����߽��
 * 4.һ�����ܿ����׳�����쳣,�����ɶ�Ӧ���catch������ԵĴ���
 */
