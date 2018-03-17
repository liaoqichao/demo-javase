package demo.nio.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo{

	
	public static void main(String[] args) throws IOException {
//		demo1();
		demo2();
	}

	/**
	  * ��socketChannel������socketChannel���ر�socketChannel
	 * @throws IOException 
	  */
	 public static void demo1() throws IOException{
		 // 1. ��socketChannel
		 SocketChannel socketChannel = SocketChannel.open();
		 
		 // 2. ����SocketChannel
		 socketChannel.connect(new InetSocketAddress("localhost",9988));
		 
		 // 3. �ر�SocketChannel
		 socketChannel.close();
	 }
	 
	 /**
	  * ��socket��д����
	  * @throws IOException
	  */
	 public static void demo2() throws IOException{
		 // 1. ��SocketChannel
		 SocketChannel sc = SocketChannel.open();
		 
		 // 2. ����SocketChannel
		 sc.connect(new InetSocketAddress("localhost",9988));
		 
		 // 3. д����
		 String command = "qcl|buy|jsondata|timestamp";
		 ByteBuffer sendBuffer = ByteBuffer.wrap(command.getBytes("UTF-8"));
		 sc.write(sendBuffer);
		 
		 // 4. ��ȡ������Ϣ
		 ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
		 sc.read(receiveBuffer);
		 String msg = new String(receiveBuffer.array(),"UTF-8");
		 System.out.println(msg);
		 
		 // 5. �ر�socketChannel
		 sc.close();
	 }
}
