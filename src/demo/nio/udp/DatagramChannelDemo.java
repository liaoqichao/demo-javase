package demo.nio.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class DatagramChannelDemo {

	public static void main(String[] args) throws IOException {
		demo1();
	}
	
	public static void demo1() throws IOException{
		// 1. 打开DatagramChannel
		DatagramChannel dc = DatagramChannel.open();
		
		// 2. 绑定地址和端口
		dc.bind(new InetSocketAddress("localhost",9989));
		
		dc.connect(new InetSocketAddress("localhost",9989));
		// 3. 设为非阻塞
		dc.configureBlocking(false);
		
		while(true){
			// 4. 发送数据
			Scanner scanner = new Scanner(System.in); // 键盘输入
			String line = scanner.nextLine();
			while(!"over".equals(line)){
				ByteBuffer sendBuffer = ByteBuffer.wrap(scanner.nextLine().getBytes("UTF-8"));
				dc.write(sendBuffer);
			}
			
			// 4. 接收数据
			ByteBuffer receBuffer = ByteBuffer.allocate(1024);
			while(dc.read(receBuffer) != -1){
				String str = new String(receBuffer.array(),"UTF-8");
				System.out.println(str);
				receBuffer.clear();
			}
		}
		
		// 5. 关闭DatagramChannel
//		dc.close();
	}
	

	

}
