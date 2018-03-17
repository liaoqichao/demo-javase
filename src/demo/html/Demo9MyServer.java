package demo.html;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo9MyServer {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1
		ServerSocket ss = new ServerSocket(9090);
		
		//2
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress() +" is connected");
		
		//3
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		//4
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//不要用out.write() write是直接继承父类的方法
		
//		问题主要集中在，为什么客户端调用了write()和flush()后，服务器端依然read不到数据。
//		因为socket.getOutputStream()取到的实现类是java.net.SocketOutputStream，这个类并没有覆写flush方法，
//		它的父类java.io.FileOutputStream也没有覆写，于是最终就调到了最顶层java.io.OutputStream的flush()方法，这就恶心了，
//		这个方法是空的。于是...
//		因此，还是使用Reader.readLine()和Writer.println()来处理socket吧
		out.println("<font color='green' size=7 />注册成功</font>");
		
		s.close();
		ss.close();
	}

}
