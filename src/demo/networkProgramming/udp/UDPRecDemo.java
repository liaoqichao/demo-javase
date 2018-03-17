package demo.networkProgramming.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPRecDemo {
	
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/*
		 * 建立UPD接收端的思路：
		 * 1.建立Socket服务
		 * 2.建立数据报包用于存储接收到的数据,方便用数据报包对象方法解析这些数据
		 * 3.使用socket服务的receive方法将接收到的数据存储到数据报包中
		 * 4.通过数据报包的方法解析数据报包的数据
		 * 5.关闭资源
		 */
		
		System.out.println("接收端启动");
		
		//1,建立Socket服务
		@SuppressWarnings("resource")
		DatagramSocket ds = new DatagramSocket(10000);//接收端一定要指定端口,接收端口和发送端口可以不一样(端口是用来标识进程的)
		//发送端的发送的目的IP地址要和接收端IP地址一样,发送端端口要和接收端端口一样
		//发送端的packet的端口要和接收端的ds端口一样
		
		while(true){
		//2,建立数据报包
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		
		//把3，4步改成死循环,不用关闭循环,发送端改成键盘录入,就变成聊天程序
			//3,使用接收方法将数据存储到数据报包中
			ds.receive(dp);	//阻塞式,没有收到则等待
			
			//4,通过数据报包对象的方法解析其中的数据。比如：地址，端口，数据内容
//			String ip = dp.getAddress().getHostAddress();
//			int port = dp.getPort();//port = 65475; 发送端没有明确端口(随机产生),这里获得的是发送端的端口
			String text = new String(dp.getData(),0,dp.getLength());//数据报包最清楚数据(字节数组)的长度
			
			System.out.println(text);
//			System.out.println("发送端ip = "+ip);
//			System.out.println("发送端port = "+port);
//			System.out.println("text = "+text);
		}
	
		//5,关闭资源
		//ds.close();
		
		
	}

}
