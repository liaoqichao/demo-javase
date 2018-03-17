package demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConversionFlowDemo implements IO {

	/**
	 * 什么时候使用转换流?
	 * 1.源和目的对应的设备是字节流,操作的却是文本数据,可以使用转换流作为桥梁
	 * 2.一旦操作文本涉及到具体制定编码表时,必须使用转换流
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
	}

	public void demo1() throws IOException {	//InputStreamReader 键盘输入,显示到控制台 字节流转字符流

		/*
		 * 因为有一些时候只有字节流而没有字符流,所以需要字节流转换到字符流。如Socket的getInputStream()
		 * System.in 标准输入流：键盘
		 * System.out 标准输出流：控制台
		 * InputStreamReader ：转换流 。 字节流->字符流的桥梁	编码	文件里的字符读到内存(电脑只认识0/1)
		 * OutputStreamWriter:转换流 。  字符流->字节流的桥梁     解码	内存把(0/1)写到文件,但是打开文件的是字符不是0/1
		 * InputStream:字节流		Reader:字符流
		 * InputStreamReader isr = new InputStreamReader(字节流,编码表);
		 * 
		 * OutputStreamWriter同理
		 * 
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//键盘输入
		 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	//控制台输出
		 */
		
		//InputStream in = System.in //System.in返回的是字节流
		InputStreamReader isr = new InputStreamReader(System.in);	//字节流边字符流
		BufferedReader br = new BufferedReader(isr);				
		
		OutputStreamWriter osr = new OutputStreamWriter(System.out);//字节流变字符流
		BufferedWriter bw = new BufferedWriter(osr);				
		
		String line = null;
		while((line = br.readLine())!=null){						
			if(line.equals("over"))
				break;
			bw.write(line);											
			bw.newLine();
			bw.flush();			//没有刷新则不能输出到控制台,一直在缓冲区
			line = "";
		}
	}

	public void demo2() throws IOException {

		/*
		 *	键盘录入,输出到demo7.txt,over终止(over不写到demo.txt)
		 *	源和目的都可以改变
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Eclipse\\IO\\ConversionFlow\\demo1.txt",true));
		
		String s = null;
		while((s=br.readLine())!=null){
			if(s.equals("over"))
				break;
			bw.write(s);
			bw.newLine();
			bw.flush();
			s = "";
		}
		bw.close();
	}
	
	public void demo3() throws IOException{		//转换编码表
		/*
		 * 转换编码表
		 * 编码和解码要用一个码表  用UTF-8编码,用GBK解码,这样输入和输出就不一样
		 */
		//FileWriter用的是默认码表(虚拟机获取系统的码表),不能改变;OutputStreamWriter可以改变
		//FileReader用的是默认码表(虚拟机获取系统的码表),不能改变;InputStreamReader可以改变
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\Eclipse\\IO\\ConversionFlow\\demo3.txt"),"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("你好");//GBK码表4个字节，UTF-8码表6个字节
		bw.flush();
		bw.close();
		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\Eclipse\\IO\\ConversionFlow\\demo3_1.txt"),"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);	//こんにちは			?こんにちは
										//(●''∇'')ﾊﾛｰ♪		(●''?'')????

		}
		br.close();
	}	

}
