package demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintDemo implements IO {

	/**
	 * 打印流
	 * 可以直接操作输入流和文件
	 * 打印流只负责目的(内存->硬盘)输出
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
	}
	public void demo1() throws FileNotFoundException{
		
		/*
		 * PrintStream
		 * 1.不抛IOException
		 * 构造函数：字符串路径,File对象,字节输出流
		 */
		PrintStream out = new PrintStream("E:\\Eclipse\\IO\\Print\\demo1.txt");
		/*
		 * write(int或byte数组<起点,重点>)
		 * write(97);97是原始字节,是代表a ；write("97"); 输出的是97
		 * 只取最低8位字节。  00000000 00000000 00000000 01100001 只取后面8位  然后记事本解析后输出是a
		 *  00000000 00000000 11111111 01100001	还是a
		 * print(97); 记事本输出的是97	
		 * print保持了原来的表现形式97就是97不是a,但不保持原来的大小。"97"2个字节，97 1个字节
		 */
		out.write(12);
		out.print(97);//先把97变成字符串97,然后再调用write("97");
		out.close();
		
	}
	public void demo2() throws IOException{
		/*
		 * 字符打印流PrintWriter
		 * 构造函数
		 * 1.路径
		 * 2.file
		 * 3.字节输出流OutputStream
		 * 4.字符输出流Writer
		 */
		File file = new File("E:\\Eclipse\\IO\\Print\\demo2.txt");
		if(!file.exists())
			file.createNewFile();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//键盘输入
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		PrintWriter out = new PrintWriter(bw,true);//是否自动刷新true为真
		String s = null;
		while((s = br.readLine())!= null){
			if(s.equals("over"))
				break;
			out.println(s.toUpperCase());//println换行-_,-
			//out.flush();有自动刷新这个可以不写。在这里有刷新的话则输入1行txt输出显示一行。
			//没有刷新的话,直到out.close(),才把缓冲区全部的输入写到txt再刷新
		}
		br.close();
		out.close();
	}
}
