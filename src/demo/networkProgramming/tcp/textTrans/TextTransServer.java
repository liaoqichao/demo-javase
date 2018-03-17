package demo.networkProgramming.tcp.textTrans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TextTransServer {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 转换服务器端：
		 * 分析
		 * 1.创建服务器端ServerSocket对象
		 * 2.获取连接过来的socket对象
		 * 3.获取socket对象的输出流。源：读取客户端发过来需要转换的数据
		 * 4.目的：显示在服务器端控制台上
		 * 5.获取socket输出流。将数据转成大写,发给客户端。
		 */
		
		//1.
		ServerSocket ss = new ServerSocket(10004);
		
		//2.
		Socket s = ss.accept();
		//获取ip
		String ip  = s.getLocalAddress().getHostAddress();
		System.out.println(ip+"... is connected");
		
		//3.获取socket输入流并装饰
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//4.获取socket输出流并装饰
		//PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//5.读取输入流
		String line = null;
		while((line = bufIn.readLine()) != null){
			System.out.println(line);
			//out.println(line.toUpperCase());
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
		}
		s.close();
		ss.close();
	}

}
