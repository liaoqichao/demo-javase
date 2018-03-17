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
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//背
			String str = null;
			while((str = br.readLine())!= null){
				byte[] buf = str.getBytes();			
				DatagramPacket dp = 
						new DatagramPacket(buf,buf.length,InetAddress.getByName(/*"localhost"*/ "192.168.1.255"),10001);
				//发送端只发送到loclhost或者1个ip地址192.168.1.102,所以只能1对1的聊天,不能群聊
				//发广播则可以群聊192.168.1.255
				
				ds.send(dp);
				if(str.equals( "over"))
					break;
			}
			ds.close();
		}catch(Exception e){
			
		}
	}

}
