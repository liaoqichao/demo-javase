package demo.ifNlogicalOperator;

import demo.DemoInterface;


public class IfNLO implements DemoInterface{

	public void demo(){
		
		//demo1_switch();
		//demo1_logicalOperator();
	}
	public void demo1_switch(){
		int x =0;
		while(x<20){
			switch(x+1){
			case 1:	x++ ;System.out.println("����case1 ,x = "+x); break;
			case 2: x=x*2;System.out.println("����case2 ,x = "+x); break;
			case 3: x=x+2; System.out.println("����case3 ,x = "+x); break;
			case 4: x=x-1; System.out.println("����case4 ,x = "+x); break;
			case 5: x++; System.out.println("����case5 ,x = "+x); break;
			case 6: x=x+2; System.out.println("����case6 ,x = "+x); break;
			case 7: x=x+3; System.out.println("����case7 ,x = "+x); break;
			case 8: x++; System.out.println("����case8 ,x = "+x); break;
			case 9: x=x-2; System.out.println("����case9 ,x = "+x); break;
			case 10:x=x+10; System.out.println("����case10,x = "+x); break;
			default:x=x+100; System.out.println("case1~10����,x = "+x); break;
			}
		}
		System.out.println("����ѭ��,x = "+x);
	}
	/*
	 * ^: ��� ��ͬ���Ϊ�٣���ͬ���Ϊ��
	 * true ^ true = false //����ͻ�||)��һ���������ͻ�һ��
	 * true ^ false = true
	 * false ^ true = true
	 * false ^ false = false
	 * 
	 * !(a^b): ͬ�� : ���ȡ�� �� ͬ���Ϊ�棬��ͬ���Ϊ��
	 * 
	 * a&b: ��a��b��ɶ����ƽ���������,���Ϊ��ʱ�ұ�Ҳ����
	 * a&&b: 2�߲���ͬʱΪ��ʱ�����Ϊ�棬����Ϊ�٣����Ϊ��ʱ�������ұ�
	 * a&b,a&&b������һ��
	 * a|b,a||bͬ��
	 */
	public void demo1_logicalOperator(){
		boolean x =true, y =false, z = true;
		int a=1;
		int b=0;
		System.out.println(x^z||!(y^z)?a:b);
	}
}

