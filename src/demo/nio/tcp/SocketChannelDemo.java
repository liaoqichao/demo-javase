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
	  * 打开socketChannel、连接socketChannel、关闭socketChannel
	 * @throws IOException 
	  */
	 public static void demo1() throws IOException{
		 // 1. 打开socketChannel
		 SocketChannel socketChannel = SocketChannel.open();
		 
		 // 2. 连接SocketChannel
		 socketChannel.connect(new InetSocketAddress("localhost",9988));
		 
		 // 3. 关闭SocketChannel
		 socketChannel.close();
	 }
	 
	 /**
	  * 往socket中写数据
	  * @throws IOException
	  */
	 public static void demo2() throws IOException{
		 // 1. 打开SocketChannel
		 SocketChannel sc = SocketChannel.open();
		 
		 // 2. 连接SocketChannel
		 sc.connect(new InetSocketAddress("localhost",9988));
		 
		 // 3. 写数据
		 String command = "qcl|buy|jsondata|timestamp";
		 ByteBuffer sendBuffer = ByteBuffer.wrap(command.getBytes("UTF-8"));
		 sc.write(sendBuffer);
		 
		 // 4. 读取返回信息
		 ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
		 sc.read(receiveBuffer);
		 String msg = new String(receiveBuffer.array(),"UTF-8");
		 System.out.println(msg);
		 
		 // 5. 关闭socketChannel
		 sc.close();
	 }
}
