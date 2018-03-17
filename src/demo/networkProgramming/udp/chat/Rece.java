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
				ds.receive(dp);	//����ʽ,û���յ���ȴ�
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(),0,dp.getLength());//���ݱ������������(�ֽ�����)�ĳ���
				System.out.println(ip+":"+port+":"+text);
				if(text.equals("over")){
					System.out.println(ip+":"+port+":"+"�˳���������");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
