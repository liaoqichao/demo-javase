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
			case 1:	x++ ;System.out.println("到达case1 ,x = "+x); break;
			case 2: x=x*2;System.out.println("到达case2 ,x = "+x); break;
			case 3: x=x+2; System.out.println("到达case3 ,x = "+x); break;
			case 4: x=x-1; System.out.println("到达case4 ,x = "+x); break;
			case 5: x++; System.out.println("到达case5 ,x = "+x); break;
			case 6: x=x+2; System.out.println("到达case6 ,x = "+x); break;
			case 7: x=x+3; System.out.println("到达case7 ,x = "+x); break;
			case 8: x++; System.out.println("到达case8 ,x = "+x); break;
			case 9: x=x-2; System.out.println("到达case9 ,x = "+x); break;
			case 10:x=x+10; System.out.println("到达case10,x = "+x); break;
			default:x=x+100; System.out.println("case1~10以外,x = "+x); break;
			}
		}
		System.out.println("跳出循环,x = "+x);
	}
	/*
	 * ^: 异或 ：同真假为假，不同真假为真
	 * true ^ true = false //这个和或（||)不一样，其他和或一样
	 * true ^ false = true
	 * false ^ true = true
	 * false ^ false = false
	 * 
	 * !(a^b): 同或 : 异或取反 ， 同真假为真，不同真假为假
	 * 
	 * a&b: 把a和b变成二进制进行与运算,左边为假时右边也运算
	 * a&&b: 2边操作同时为真时，结果为真，其他为假；左边为假时不运算右边
	 * a&b,a&&b运算结果一样
	 * a|b,a||b同理
	 */
	public void demo1_logicalOperator(){
		boolean x =true, y =false, z = true;
		int a=1;
		int b=0;
		System.out.println(x^z||!(y^z)?a:b);
	}
}

