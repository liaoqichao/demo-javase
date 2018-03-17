package demo.basicDataTypeClass;

import demo.DemoInterface;

public class BasicDataTypeClass implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//demo1();

	}
	public void demo1(){
		/*
		 * 以 java.lang.Integer为例
		 */
		System.out.println("IntMax = "+Integer.MAX_VALUE+"   IntMin = "+Integer.MIN_VALUE);
		System.out.println(Integer.toString(233));//整数233变成字符串"233"
		
		int num = Integer.parseInt("123");//如果是"a123"会抛出异常
		System.out.println("num+4 = "+(num+4));		
		
		System.out.println("把十进制的60转换到十六进制 ，60 :"+Integer.toHexString(60));		//十进制转化到16进制String类型
		System.out.println("把16进制的3c转换到十进制\"，3c : "+Integer.parseInt("3c", 16));		//String,基数(16进制的基数是16)
	}
}
/*
 * 基本数据类型				引用数据类型(类)
 * byte					Byte
 * short				Short
 * int					Integer
 * long					Long
 * boolean				Boolean
 * float				Float
 * char					Character
 * 
 * 基本数据类型包装类的最常用的作用是：把基本数据类型和字符串之间的转换
 * 1.基本数据类  转换到  字符串
 * 		基本数据类型+"";
 * 		基本数据类型.toString(基本数据类型值);
 * 2.字符串 转换到 基本数据类型
 * 		parseInt(String s);//parse是转换的意思  静态方法,类名调用
 * 		intValue(String s);//要用对象调用
 * 		处了Character ,其他基本数据类型都有parseLong(String s),parseBoolean(String s)等方法
 * 		parseBoolean(String s)的s 为 "true","false";
 */
