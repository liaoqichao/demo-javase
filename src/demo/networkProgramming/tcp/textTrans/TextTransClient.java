package demo.networkProgramming.tcp.textTrans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TextTransClient {

	/**
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		/*
		 * 客户端：
		 * 1.创建socket客户端对象
		 * 2.客户端的数据源：键盘
		 * 3.客户端的目的:socket
		 * 4.接收服务器端的数据。源：socket
		 * 5.将数据打印到控制台。目的：控制台
		 * 6.在这些流操作中的数据都是文本数据
		 * 
		 * 转换客户端:
		 * 1.创建socket客户端对象
		 * 2.获取键盘录入
		 * 3.将录入信息发送给socket输入流
		 * 4.socket输入流,读取服务端返回的大写数据
		 * 
		 * 阻塞式方法容易让客户端和服务器端都在等待状态 (缺少结束标记)
		 */
		
		//1.创建socket客户端对象
		Socket socket = new Socket("192.168.1.104",10004);
		
		//2.获取键盘录入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//读键盘
		
		//3.socket输出流
		PrintWriter out  = new PrintWriter(socket.getOutputStream(),true);//保持文本形式用这个97->"97"而不是a
																	//true自动刷新
		//4.socket输入流,读取服务端返回的大写数据
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));//读socket
		 
		String line = null;
		while((line = br.readLine())!= null){
			if("over".equals(line))
				break;		//break后运行socket.close 服务器端的bufIn为空结束循环
			out.println(line);//写到服务器端
			
			//读取服务器端发回的一行大写数据
			String upperStr = bufIn.readLine();
			System.out.println(upperStr);
		}
		
		//br可以不用关,因为是键盘
		socket.close();
	}
}
