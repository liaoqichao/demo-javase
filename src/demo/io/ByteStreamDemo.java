package demo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamDemo implements IO {

	/**
	 * 从CPU上看  读是input 写是output
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub

		//demo1_ByteStream();			//写
		//demo2_ByteStream();			//读
		//demo3_ByteStream();			//媒体文件复制
		//demo4_ByteStream();			//使用缓冲区媒体文件复制
		//demo5_ByteStream();			//键盘输入,显示到控制台Scanner
	}
	public void demo1_ByteStream() throws IOException{	//写
		
		//创建字节输出流对象,用于操作文件
		FileOutputStream fos = new FileOutputStream("E:\\Eclipse\\IO\\ByteStream\\demo1.txt");
		
		//写数据 ,字节流不需要临时存储缓冲.直接写入到目的地中。字节流不用flush(flush里面没代码,flush是缓冲区才用)
		fos.write("abcdefg".getBytes());
		
		//关闭资源
		fos.close();
	}
	public void demo2_ByteStream() throws IOException{	//读
		
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\IO\\ByteStream\\demo2.txt");
		byte[] bbuf = new byte[fis.available()];
		//fis.available();反文件正常读完时候的字节数,对于小文件可以这么用，大文件数组直接超过最大范围。
		//可以先读出总长度,然后分几段存入数组
		int len = 0;
		while((len = fis.read(bbuf))!=-1){
			System.out.print(new String(bbuf,0,len));
		}
		fis.close();
	}
	public void demo3_ByteStream() throws IOException{	//媒体文件的复制
		
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\IO\\ByteStream\\倉木麻衣-SAFEST PLACE.wma");
		FileOutputStream fos = new FileOutputStream("E:\\Eclipse\\IO\\ByteStream\\copy倉木麻衣-SAFEST PLACE.wma");
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = fis.read(buf))!= -1){
			fos.write(buf,0,len);
		}
		fis.close();
		fos.close();
	}
	public void demo4_ByteStream() throws IOException{	//使用缓冲区媒体文件复制
		
		/*
		 * 不能用字符流来复制非文本文件,因为非文本文件的编码方法和字符流的编码方法不一样.
		 * 用字符流,先得到字节,然后查表(ASCII,Unicode，UTF-8等)如果没查到 就会用未知字符来代替,源数据和目的数据就不一致.
		 * 就不能被图片编辑器解析
		 */
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\IO\\ByteStream\\倉木麻衣-SAFEST PLACE.wma");
		BufferedInputStream buffis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream("E:\\Eclipse\\IO\\ByteStream\\buffer copy倉木麻衣-SAFEST PLACE.wma");
		BufferedOutputStream buffos = new BufferedOutputStream(fos);
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = buffis.read(buf))!=-1){
			
			buffos.write(buf, 0, len);
			buffos.flush();					//这里要刷新，
			
		}
		/* 千万不要用,完全没效率
		while((len = buffis.read())!=-1){	//读一个字节写一个字节超级慢
			buffos.write(len);
			buffos.flush();					//读一个字节写一个字节还要刷一次的话更慢
		}*/
		buffis.close();
		buffos.close();
	}
	public void demo5_ByteStream(){		//键盘输入,显示到控制台Scanner
		
		/*
		 * 键盘不断输入, 直到单独一行为over时停止输入
		 * String(对象)的比较不是用"=="而是用equals,String实现Comparable的方法CompareTo()
		 */
		 Scanner scanner = new Scanner(System.in);
		 String s = null;
		 while(!(s=scanner.nextLine()).equals("over"))
		 //while((s=scanner.nextLine()).compareTo("over")!=0)
			 System.out.println(s);		 
		 /*
		 while(true){
			 s = scanner.nextLine();
			 if(s.compareTo("over")==0)
				 break;
			 System.out.println(s);
		 }*/
		 scanner.close();
	}
}
