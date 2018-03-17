package demo.networkProgramming.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/*
		 * UDP发送端
		 * UDP的发送端和接收端都是独立运行(有主函数)
		 * 
		 * 创建UDP传输的发送端思路：
		 * 1.建立UDP的Socket服务
		 * 2.将要发送的数据封装到数据报包中
		 * 3.通过UDP的socket服务,将数据包发送出去
		 * 4.关闭socket服务
		 */
		
		//先运行发送端或者先运行接收端都可以(因为无连接)
		System.out.println("发送端启动");
		
		//1,建立UDPsocket服务,使用DatagramSocket对象。
		DatagramSocket ds = new DatagramSocket();
		
		//改成键盘录入
		//2,将要发送的数据封装到数据报包中。
		//String str = "udp传输演示:-_,-";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//背
		String str = null;
		while((str = br.readLine())!= null){
			if(str.equals( "over"))
				break;
			byte[] buf = str.getBytes();			
			DatagramPacket dp = 
					new DatagramPacket(buf,buf.length,InetAddress.getByName("localhost"),10000);
			//很多种构造方法,主要分为用于发送的数据报包(参数有IP,端口等)和用于接收的数据报包(参数没有IP)
			
			//3,通过udp的socket服务,将数据包发送出去。使用send方法。
			ds.send(dp);
		}
		
		//4,关闭socket资源
		ds.close();
		
	}
}
