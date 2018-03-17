package demo.networkProgramming.udp.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {

	private DatagramSocket ds;
	
	public Send(DatagramSocket ds){
		this.ds = ds;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//��
			String str = null;
			while((str = br.readLine())!= null){
				byte[] buf = str.getBytes();			
				DatagramPacket dp = 
						new DatagramPacket(buf,buf.length,InetAddress.getByName(/*"localhost"*/ "192.168.1.255"),10001);
				//���Ͷ�ֻ���͵�loclhost����1��ip��ַ192.168.1.102,����ֻ��1��1������,����Ⱥ��
				//���㲥�����Ⱥ��192.168.1.255
				
				ds.send(dp);
				if(str.equals( "over"))
					break;
			}
			ds.close();
		}catch(Exception e){
			
		}
	}

}
