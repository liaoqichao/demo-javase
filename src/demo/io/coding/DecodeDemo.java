package demo.io.coding;

import java.io.UnsupportedEncodingException;

public class DecodeDemo implements Coding {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
	}
	public void demo1() throws UnsupportedEncodingException{
		//GBK码表  
		byte[] buf = {-60,-29,-70,-61};	//你好
		String s1 = new String(buf);
		System.out.println(s1);
		//uft-8码表
		byte[] buf1 = {-28,-67,-96,-27,-91,-67};
		String s2 = new String(buf1,"utf-8");
		System.out.println(s2);//你好
	}
	public void demo2() throws UnsupportedEncodingException{
		//数据可以变回来
		byte[] buf = {-60,-29,-70,-61};	//GBK码表 你好
		String s = new String(buf,"iso8859-1");//拿欧洲码表解汉字，Tomcat内置码表就是iso8859-1
		System.out.println(s);//????

		byte[] buf1 = s.getBytes("iso8859-1");	//不加参数会默认GBK码表(中文简体操作系统)
		String s1 = new String(buf1,"GBK");
		System.out.println(s1);//你好		
	}
	public void demo3() throws UnsupportedEncodingException{
		//数据变不回来
		/*
		 * 当数据是"谢谢"的时候则可以变回来,因为GBK"谢谢"到UTF-8是"ππ" (字节数组的内容没变)
		 * 而GBK"你好"到UTF-8是???(而UTF-8是用 -17-65-67 来表示所有的未知情况?),所以字节数组的内容变化了,不能变回你好
		 */
		byte[] buf = {-60,-29,-70,-61};	//GBK码表  你好
		String s = new String(buf,"utf-8");
		System.out.println(s);//???
		
		byte[] buf1 = s.getBytes("UTF-8");	
		EncodeDemo.printBytes(buf1);//-17-65-67-17-65-67-17-65-67  和源数据不一样
		String s1 = new String(buf1,"GBK");
		System.out.println(s1);//锟斤拷锟?
	}

}
