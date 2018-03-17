package demo.networkProgramming.udp.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable {

	private DatagramSocket ds;
	
	public Rece(DatagramSocket ds){
		this.ds = ds;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			while(true){
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				ds.receive(dp);	//阻塞式,没有收到则等待
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(),0,dp.getLength());//数据报包最清楚数据(字节数组)的长度
				System.out.println(ip+":"+port+":"+text);
				if(text.equals("over")){
					System.out.println(ip+":"+port+":"+"退出了聊天室");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
