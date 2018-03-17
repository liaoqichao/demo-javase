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
	 * ��ServerSocketChannel���󶨶˿ںš��ر�ServerSocketChannel
	 * @throws IOException
	 */
	public static void demo1() throws IOException{
		// 1. ��ServerSocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		// 2. �󶨶˿ں�
		serverSocketChannel.socket().bind(new InetSocketAddress("localhost",9988));
		
		// 3. �ر�ServerSocketChannel
		serverSocketChannel.close();
	}
	
	/**
	 * �����ؼ����½���������
	 * @throws IOException
	 */
	public static void demo2() throws IOException {
		// 1. ��ServerSocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		// 2. �󶨶˿ں�
		serverSocketChannel.socket().bind(new InetSocketAddress("localhost",9988));
		
		// 3. �����½��������� ���� ����
		while(true){
			System.out.println("׼�������ؼ����½���������...");
			SocketChannel socketChannel = serverSocketChannel.accept();
			System.out.println("�������ӽ���..."+socketChannel.isConnected());
		}
	}
	
	/**
	 * �������ؼ����½���������
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void demo3() throws IOException, InterruptedException {
		// 1. ��ServerSocketChannel
		ServerSocketChannel ssc = ServerSocketChannel.open();
		
		// 2. �󶨶˿�
		ssc.socket().bind(new InetSocketAddress("localhost",9988));
		
		// 3. ����Ϊ������ģʽ
		ssc.configureBlocking(false); 
		
		// 4. �����¼�
		while(true){
			SocketChannel sc = ssc.accept();
			if(sc != null){
				System.out.println("�������ӽ���..."+sc.isConnected() +","+sc.isBlocking());
			}
			System.out.println("û����������ִ��...");
			Thread.sleep(2000);
		}
	}
	
	/**
	 * �������ݣ�������Ϣ
	 * @throws Exception
	 */
	public static void demo4() throws Exception {
		// 1. ��ServerSocketChannel
		ServerSocketChannel ssc = ServerSocketChannel.open();
		
		// 2. �󶨵�ַ�˿�
		ssc.socket().bind(new InetSocketAddress("localhost",9988));
		
		// 3. ����Ϊ������ģʽ
		ssc.configureBlocking(false);
		
		// 4. ��������
		while(true){
			SocketChannel sc = ssc.accept();
			if(sc != null){
				// 5. ��ȡ����
				ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
				sc.read(receiveBuffer);
				String commond = new String(receiveBuffer.array(),"UTF-8");
				System.out.println(commond);
				
				// 6. д����
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
			System.out.println("û������������ִ��...");
		}
	}

}
