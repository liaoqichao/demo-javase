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
		
		System.out.println("请输入被除数和除数");
		Scanner scanner =new Scanner(System.in);
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		try{ devide(a,b); }
		catch(Exception e){										//有异常才执行
			System.out.println("除数不能为0");
		}
		finally{
			System.out.println("结束");							//无论有没有异常都会执行
			scanner.close();
		}
	}
	public static void devide(double a ,double b)throws Exception{//throw用于抛出异常对象,后面跟的是异常对象,写在函数里面
			  												//throws后面跟类名,写在函数上
		if(b==0)
		throw new Exception();								//异常上抛给调用者,让调用者解决异常
		double c = a/b;
		System.out.println(c);
	}
	public void demo2_exception(){
		
		System.out.println("请输入一个整数");
		Scanner scanner =new Scanner(System.in);
		try{
			int a = scanner.nextInt();
			System.out.println(a);
		}
		catch(Exception e){ System.out.println("输入错误,不是输入整数"); }
		finally {scanner.close();}
	}
	public void demo3_exception(){
		
		try{
			getDiagonal();								//有throws MyException,可能出现异常,
														//调用者(test3_Exception())一定要捕获异常									
		}
		catch(MyException e){
			System.out.println("方法调用者正在捕获异常");
			System.out.println("Exception is caught "+e);
		}
	}

	public static void getDiagonal() throws MyException{
		//求多边形的对角线数
		int n,total;
		System.out.println("请输入一个大于等于3的数字");
		Scanner scanner =new Scanner(System.in);
		n = scanner.nextInt();
		if(n<3){
			MyException e =new MyException();
			e.statement();
			scanner.close();
			throw e;		//方法声明没有throws MyException的话 ,无法使用throw
		}	
		total = n*(n-3)/2;
		System.out.println(total);
		scanner.close();
	}

}
class MyException extends Exception{				//自定义异常
	
	/**
	 * 求多边形的对角线数,多边形边数起码是3,输入的小于3
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyException(){									//构造函数
	}
	public void statement(){
		System.out.println("输入错误,默认n=3");
	}	
}
/*
 * 关键字：try catch finally throws throw
 * 
 * 如果抛出的是RuntimeException,函数上可以不用声明throws
 * 
 * throws Exception 声明在类上声明，别在方法声明
 * 
 * 格式
 * try{可能发生异常} catch(Exception e1){异常处理1} catch(Exception e2){异常处理2} ... finally{异常结束前的执行语句}
 * 如果找不到异常对应的catch语句,将执行缺省的异常处理
 * func(){try{func1},catch(Exception e){...}}   func1(){throw new Exception();}
 * 不断上抛给调用者
 * 
 * 
 * 异常捕获	捕获异常是指发生异常时，找异常对象做出相应处理，避免程序崩溃,处理后继续执行下面的语句,
 * 			如果没有找到异常对象JVM会中断应用程序的运行。
 * 异常抛出	若发生可处理的异常后，正在运行的程序将创建一个异常对象，该异常对象中记录了导致程序运行错误的原因和发生异常时程序的状态和信息。
 * 			程序执行到throw语句时立即停止不再继续.throw一直上抛给调用者,最后的调用者一定要用trycatch处理异常
 * 
 * 自定义异常步骤：
 * 1.定义异常类
 * Class MyException extends Exception{ ... }
 * 2.定义异常对象并抛出该对象
 * 方法1：throw new MyException(); 
 * 方法2：MyException e =new MyException();  throw e;
 * 
 * 异常处理的原则：
 * 1.函数内容如果抛出需要检测的异常,那么函数上必须声明
 * 	 否则必须在函数内用trycatch捕捉，否则便以失败
 * 2.如果调用了声明异常的函数,要么用trycatch要么用throws,否则编译失败
 * 3.什么时候用catch,什么时候用throws
 * 	 功能内容可以解决,用catch,解决不了,用throws告诉调用者,由调用者解决
 * 4.一个功能可能抛出多个异常,必须由对应多个catch进行针对的处理
 */
