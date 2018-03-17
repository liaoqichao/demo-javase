package demo.networkProgramming.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 需求：服务器端收到客户端的信息,并打印到控制台上
		 * TCP传输服务器建立的思路：
		 * 1.创建服务器端socket服务,创建ServerSocket对象
		 * 2.服务器端必须对外提供一个端口,否则只能连接到IP对应的主机,不能连接那个主机的对用的应用程序(进程)
		 * 3.获取连接过来的客户端对象(socket对象)
		 * 4.通过客户端对象的方法,读取(getInputStream)客户端发来的数据,并打印在控制台上
		 * 5.关闭资源。关闭客户端资源和关闭服务器端资源
		 */
		
		try {
			//1.创建服务器端对象
			ServerSocket ss = new ServerSocket(10002);//这里服务器端的端口要和客户端的端口一致
			
			//2.获取连接过来的客户端对象
			Socket s = ss.accept();//要记住哦！阻塞式
			String ip = s.getInetAddress().getHostAddress();
			
			//3.通过socket对象获取输入流,读取客户端发来的数据
			InputStream is = s.getInputStream();
			
			
			//4.通过客户端对象的方法读取数据
			byte[] buf = new byte[1024];
			
//			int len = is.read(buf);
//			String text = new String(buf,0,len);
//			System.out.println(ip + ":" + text);
			
			/*使用客户端socket对象的输出流给客户端返回数据*/
			/*
			 * 为什么用while((len = is.read(buf)!=-1)循环,len的值一直是16,不会到-1
			 */
			OutputStream out = s.getOutputStream();
			int len = 0;
			while((len = is.read(buf))!= -1){
				String text = new String(buf,0,len);
				System.out.println(ip+":"+text);
				out.write("收到".getBytes());						
			}
//			out.write("收到".getBytes());						
			
			s.close();
			ss.close();//服务器端一般是不关闭的
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
