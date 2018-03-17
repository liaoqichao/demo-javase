package demo.networkProgramming.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPRecDemo {
	
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/*
		 * ����UPD���ն˵�˼·��
		 * 1.����Socket����
		 * 2.�������ݱ������ڴ洢���յ�������,���������ݱ������󷽷�������Щ����
		 * 3.ʹ��socket�����receive���������յ������ݴ洢�����ݱ�����
		 * 4.ͨ�����ݱ����ķ����������ݱ���������
		 * 5.�ر���Դ
		 */
		
		System.out.println("���ն�����");
		
		//1,����Socket����
		@SuppressWarnings("resource")
		DatagramSocket ds = new DatagramSocket(10000);//���ն�һ��Ҫָ���˿�,���ն˿ںͷ��Ͷ˿ڿ��Բ�һ��(�˿���������ʶ���̵�)
		//���Ͷ˵ķ��͵�Ŀ��IP��ַҪ�ͽ��ն�IP��ַһ��,���Ͷ˶˿�Ҫ�ͽ��ն˶˿�һ��
		//���Ͷ˵�packet�Ķ˿�Ҫ�ͽ��ն˵�ds�˿�һ��
		
		while(true){
		//2,�������ݱ���
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		
		//��3��4���ĳ���ѭ��,���ùر�ѭ��,���Ͷ˸ĳɼ���¼��,�ͱ���������
			//3,ʹ�ý��շ��������ݴ洢�����ݱ�����
			ds.receive(dp);	//����ʽ,û���յ���ȴ�
			
			//4,ͨ�����ݱ�������ķ����������е����ݡ����磺��ַ���˿ڣ���������
//			String ip = dp.getAddress().getHostAddress();
//			int port = dp.getPort();//port = 65475; ���Ͷ�û����ȷ�˿�(�������),�����õ��Ƿ��Ͷ˵Ķ˿�
			String text = new String(dp.getData(),0,dp.getLength());//���ݱ������������(�ֽ�����)�ĳ���
			
			System.out.println(text);
//			System.out.println("���Ͷ�ip = "+ip);
//			System.out.println("���Ͷ�port = "+port);
//			System.out.println("text = "+text);
		}
	
		//5,�ر���Դ
		//ds.close();
		
		
	}

}
