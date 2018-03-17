package demo.networkProgramming.udp.chat;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatDemo {

	/*
	 * 1.数据报包对象的端口要和接收DatagramSocket对象的端口一样
	 * 2.要实现群聊,数据报包的IP地址,变成那个广播地址(最后变成255)
	 * 3.边收边发的话要实现多线程
	 * 4.每个主机都要有发送端和接收端
	 * 5.UDP只分发送端和接收端,没有客户端和服务器端
	 */
	public static void main(String args[]){
		try {
			DatagramSocket send = new DatagramSocket();
			DatagramSocket rece = new DatagramSocket(10001);
			Thread sendThread = new Thread(new Send(send));
			Thread receThread = new Thread(new Rece(rece));
			receThread.setDaemon(true);
			sendThread.start();
			receThread.start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
