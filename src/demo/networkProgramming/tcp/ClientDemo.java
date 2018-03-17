package demo.networkProgramming.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 需求：客户端发数据到服务端
		 * TCP传输客户端建立的思路：
		 * 1.创建TCP客户端socket服务,使用Socket对象,建议一创建就明确要连接的主机
		 * 2.如果连接建立成功,说明数据传输通道(socket流/网络IO流)已建立。
		 * 	 socket流是底层建立的,既有输入又有输出,想要输入或输出流对象,可以找Socket获取。(socket里面有getInputstream和getOutputSream方法)
		 * 3.使用输出流,写数据写到网络(服务器端).构造函数已经明确目的了.
		 * 4.关闭资源
		 */
		
		try {
			//1.创建客户端socket服务
			Socket socket = new Socket("192.168.1.104",10002);//不知道本机的局域网ip找360
			//服务器端没开的话,建立不了连接,抛出异常
			
			//2.获取socket的输出流
			OutputStream os = socket.getOutputStream();
			
			//3.使用输出流将数据写出去
			os.write("tcp演示,喵了个咪".getBytes());
			
			
			/*读取服务器端返回的数据*/
			InputStream is = socket.getInputStream();
			byte[] buf = new byte[1024];		
			int len = is.read(buf);
			String text = new String(buf,0,len);
			System.out.println(text);
			
			//4.关闭资源
			socket.close();//os可以不用关,因为socket关闭了,连接断开,没有流了
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
