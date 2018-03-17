package demo.hexConversion;

import demo.DemoInterface;

public class HexConversion implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//调用函数
		//decimaltoOther();
		//octaltoOther();
		//hexadecimaltoOther();
		//binarytoOther();
		//查表法。结果用数组存储

	}
	/*
	 * 一个字节8位，log2(16)=4,4位表示一位十六进制,3位表示8进制，1位表示2进制,(4位表示一个十进制数？)
	 * JAVA中int类型长度为四个字节，可以表示8位十六进制数
	 * 
	 * 
	 * 进制转换前都是int类型
	 * 进制转换后都是String类型
	 * 
	 * 
	 * 声明十进制	int a=233;
	 * 声明八进制	int b=0123;int 012345; 前面加1个0就够
	 * 声明十六进制	int c=0xd2f; 前面加0x
	 * 声明二进制	int d=0b10101; 前面加0b
	 * JAVA不能输出二进制数，例如输出int d=0b10101,System.out.println(d)会变成21;
	 * 
	 * 
	 * 直接输出别的进制的话，会输出该进制的十进制值，要用System.out.printf("%o"(八进制)/"%x"(十六进制),a);输出
	 * 
	 * 
	 * Integer.toString(int a,int b);把a转换成b进制用字符串表示.b>36怎么办?大于36会按照十进制输出。不会按照b进制输出
	 * 
	 * Integer.toHexString,.toOctalString,.toBinaryString(int a);把整形a转换成十进制
	 * 
	 * Integer.valueOf(int a/String s/String s,int a).toSting,.toHexString,.toOctalString,
	 * .toBinaryString.
	 * int a,返回a值得Integer实例??
	 * String s表示将字符串按照十进制变成整数，String s,int a 表示将字符串按照a进制变成整数
	 * String a=123;，int b=8;
	 * 例如Integer.valueOf(a,b)把字符串123变成以8进制表示的123，则十进制的值为83，
	 * 若b=16，字符串a变成以十六进制表示表示的123，则十进制的值为291
	 */
	public void decimaltoOther(){	//十进制转换到其他进制
		int a = 233;
		System.out.println("十进制: "+a);
		//十进制转换到十六进制
		String a10to16 =Integer.toHexString(a);
		System.out.println("十六进制: "+a10to16);
		//十进制转换到八进制
		String a10to8 =Integer.toOctalString(a);
		System.out.println("八进制： "+a10to8);
		//十进制转换到二进制
		String a10to2 =Integer.toBinaryString(a);
		System.out.println("二进制： "+a10to2);
		System.out.println();
	}
	public void octaltoOther(){		//八进制转换到其他进制,这里给出三种转换方法
		int b =0123;//int b=0123(八进制) == int b=83(十进制)，输出结果都是十进制
		System.out.printf("八进制: "+"%o", b);//用printf，不然输出的结果为十进制的83
		System.out.println();
		//八进制转换到十进制
		//String b8to10 = Integer.toString(b, 10);
		String b8to10 =Integer.valueOf(b).toString();
		System.out.println("十进制: "+b8to10);
		//八进制转换到十六进制
		//String b8to16 =Integer.toString(b, 16); //1
		//String b8to16 = Integer.toHexString(b); //2
		@SuppressWarnings("static-access")
		String b8to16 =Integer.valueOf(b).toHexString(b);//3
		System.out.println("十六进制: "+b8to16);	
		//八进制转换到二进制
		//String b8to2 = Integer.toString(b, 2); 	//1
		//String b8to2 = Integer.toBinaryString(b);	//2
		@SuppressWarnings("static-access")
		String b8to2 =Integer.valueOf(b).toBinaryString(b);//3
		System.out.println("二进制: "+b8to2);
		System.out.println();
	}
	public void hexadecimaltoOther(){	//十六进制转换到其他进制
		int c = 0x0D2F;//最高为为字母时候前面加0，强调是数字，不加也可以。0xcdf结果一样
		System.out.printf("十六进制："+ "%x", c);
		System.out.println();
		//十六进制转换到十进制
		String c16to10 =Integer.toString(c, 10);
		System.out.println("十进制： "+c16to10);
		//十六进制转换到八进制
		String c16to8 =Integer.toString(c, 8);
		System.out.println("八进制： "+c16to8);
		//十六进制转换到二进制
		String c16to2 =Integer.toString(c, 2);
		System.out.println("二进制： "+c16to2);
		System.out.println();
	}
	public void binarytoOther(){	//二进制转换到其他进制
		String d ="1011101"; //JAVA不能输出二进制数
		System.out.println("二进制： "+d);
		//二进制转换到十进制
		String d2to10 =Integer.valueOf(d,2).toString();
		System.out.println("十进制: "+d2to10);
		//二进制转换到八进制
		String d2to8 =Integer.toOctalString(Integer.valueOf(d,2));
		System.out.println("八进制： "+d2to8);
		//二进制换换到十六进制
		String d2to16 =Integer.toHexString(Integer.valueOf(d,2));
		System.out.println("十六进制： "+d2to16);
		System.out.println();
	}

}
