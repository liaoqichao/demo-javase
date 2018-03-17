package demo.function;

import java.util.Scanner;

import demo.DemoInterface;

public class Function implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub

		//demo1_function();
		//demo2_function();
		//demo3_function();
	}
	
	/*
	 * 1.明确函数功能是什么？明确函数的返回值类型
	 * 	  打印到控制台或者输入到文件中的用void型,不需要把运算结果返回给函数调用者
	 * 2.明确这个功能实现的过程中是否需要一些未知(不确定)的内容参与运算？明确函数参数的类型和参数的个数
	 * 
	 * 函数重载：<在同一个类中>，允许函数名相同，只要它的<参数个数> 或 <参数类型>不同即可
	 * 函数重载体现面向对象程序设计语言的多态性
	 * 函数重载功能相似,代码可能重复,有时可以调用功能更强大的函数,如打印乘法表
	 * print(int num){ // 打印num * num的乘法表 }
	 * print(){ print(9) } 不加参数则默认打印九九乘法表
	 * 个数的问题(如2位加法和n位加法,n*n乘法表和九九乘法表)通常可以复用代码,但是类型问题通常不可以复用代码
	 * 
	 * 静态函数或者类前面没有public,protected,private修饰则默认为default(friendly,同类或同包(package)可以访问,
	 * 子类不可以访问,java中没有friendly关键字)
	 */
	
	
	public void demo1_function(){					//求两个整形数的和
		int a , b;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入两个加数: ");
		a = in.nextInt();
		b = in.nextInt();
		int sum;
		sum = demo1_function(a,b);
		System.out.println(a+" + "+b+" = "+sum);
		in.close();
	}
	public int demo1_function(int a,int b){			
		return a+b;	
	}
	
	public void demo2_function(){					//求两个整数较大的数
		int a ,b;
		char d ,e ;
		String s = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入两个整数: ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		int c = demo2_function(a,b);
		System.out.println(c);
		
		System.out.println("请输入两个字符: ");
		s = scanner.next();
		d = s.charAt(0);
		s = scanner.next();
		e = s.charAt(0);
		char g = demo2_function(d,e);
		System.out.println(g);
		scanner.close();
	}
	public int demo2_function(int a,int b){			//同一个类,同一函数名,参数个数不同,函数重载
		return a>b?a:b;								//三目运算符运算后有结果a或b,if else不一定有结果
	}
	public char demo2_function(char a,char b){		//同一个类,同一函数名,参数个数相同,但参数类型不同,函数重载
		return a>b?a:b;
	}
	
	public void demo3_function(){					//在控制台打印长方形
		int a ,b;
		String s =null;
		char c;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入长方形的长和宽和边的形状: ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		s = scanner.next();
		c = s.charAt(0);
		demo3_function(a,b,c);
		scanner.close();
	}
	public void demo3_function(int row,int col,char c){
		for(int i=0;i<row;i++){
				if(i == 0 || i==row-1){
					for(int j=0;j<col;j++)
						System.out.print(c+" ");
				}
				else{
					for(int j=0;j<col;j++)
						if(j==0 || j== col-1)
							System.out.print(c+" ");
						else
							System.out.print("  ");					
				}
				System.out.println();
		}
	}	

}
