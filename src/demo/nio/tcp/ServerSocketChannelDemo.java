package demo.nio.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * demo12
 * @author LQC
 *
 */
public class ServerSocketChannelDemo {

	public static void main(String[] args) throws Exception{

//		demo1();
//		demo2();
//		demo3();
		demo4();
	}
	
	/**
	 * 打开ServerSocketChannel、绑定端口号、关闭ServerSocketChannel
	 * @throws IOException
	 */
	public static void demo1() throws IOException{
		// 1. 打开ServerSocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		// 2. 绑定端口号
		serverSocketChannel.socket().bind(new InetSocketAddress("localhost",9988));
		
		// 3. 关闭ServerSocketChannel
		serverSocketChannel.close();
	}
	
	/**
	 * 阻塞地监听新进来的连接
	 * @throws IOException
	 */
	public static void demo2() throws IOException {
		// 1. 打开ServerSocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		// 2. 绑定端口号
		serverSocketChannel.socket().bind(new InetSocketAddress("localhost",9988));
		
		// 3. 监听新进来的连接 —— 阻塞
		while(true){
			System.out.println("准备阻塞地监听新进来的连接...");
			SocketChannel socketChannel = serverSocketChannel.accept();
			System.out.println("有新连接进来..."+socketChannel.isConnected());
		}
	}
	
	/**
	 * 非阻塞地监听新进来的连接
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void demo3() throws IOException, InterruptedException {
		// 1. 打开ServerSocketChannel
		ServerSocketChannel ssc = ServerSocketChannel.open();
		
		// 2. 绑定端口
		ssc.socket().bind(new InetSocketAddress("localhost",9988));
		
		// 3. 设置为非阻塞模式
		ssc.configureBlocking(false); 
		
		// 4. 监听事件
		while(true){
			SocketChannel sc = ssc.accept();
			if(sc != null){
				System.out.println("有新连接进来..."+sc.isConnected() +","+sc.isBlocking());
			}
			System.out.println("没连接我照样执行...");
			Thread.sleep(2000);
		}
	}
	
	/**
	 * 接收数据，返回信息
	 * @throws Exception
	 */
	public static void demo4() throws Exception {
		// 1. 打开ServerSocketChannel
		ServerSocketChannel ssc = ServerSocketChannel.open();
		
		// 2. 绑定地址端口
		ssc.socket().bind(new InetSocketAddress("localhost",9988));
		
		// 3. 设置为非阻塞模式
		ssc.configureBlocking(false);
		
		// 4. 监听连接
		while(true){
			SocketChannel sc = ssc.accept();
			if(sc != null){
				// 5. 读取数据
				ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
				sc.read(receiveBuffer);
				String commond = new String(receiveBuffer.array(),"UTF-8");
				System.out.println(commond);
				
				// 6. 写数据
				String sendMsg = "";
				String[] msg = commond.split("\\|");
				if(msg.length == 4){
					sendMsg = "success";
				} else{
					sendMsg = "fail";
				}
				ByteBuffer sendBuffer = ByteBuffer.wrap(sendMsg.getBytes("UTF-8"));
				sc.write(sendBuffer);
			}
			Thread.sleep(1000);
			System.out.println("没有连接我照样执行...");
		}
	}

}
