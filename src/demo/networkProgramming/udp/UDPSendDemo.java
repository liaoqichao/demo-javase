package demo.networkProgramming.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/*
		 * UDP���Ͷ�
		 * UDP�ķ��Ͷ˺ͽ��ն˶��Ƕ�������(��������)
		 * 
		 * ����UDP����ķ��Ͷ�˼·��
		 * 1.����UDP��Socket����
		 * 2.��Ҫ���͵����ݷ�װ�����ݱ�����
		 * 3.ͨ��UDP��socket����,�����ݰ����ͳ�ȥ
		 * 4.�ر�socket����
		 */
		
		//�����з��Ͷ˻��������н��ն˶�����(��Ϊ������)
		System.out.println("���Ͷ�����");
		
		//1,����UDPsocket����,ʹ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket();
		
		//�ĳɼ���¼��
		//2,��Ҫ���͵����ݷ�װ�����ݱ����С�
		//String str = "udp������ʾ:-_,-";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//��
		String str = null;
		while((str = br.readLine())!= null){
			if(str.equals( "over"))
				break;
			byte[] buf = str.getBytes();			
			DatagramPacket dp = 
					new DatagramPacket(buf,buf.length,InetAddress.getByName("localhost"),10000);
			//�ܶ��ֹ��췽��,��Ҫ��Ϊ���ڷ��͵����ݱ���(������IP,�˿ڵ�)�����ڽ��յ����ݱ���(����û��IP)
			
			//3,ͨ��udp��socket����,�����ݰ����ͳ�ȥ��ʹ��send������
			ds.send(dp);
		}
		
		//4,�ر�socket��Դ
		ds.close();
		
	}
}
