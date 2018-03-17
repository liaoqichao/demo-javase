package demo.networkProgramming.udp.chat;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatDemo {

	/*
	 * 1.���ݱ�������Ķ˿�Ҫ�ͽ���DatagramSocket����Ķ˿�һ��
	 * 2.Ҫʵ��Ⱥ��,���ݱ�����IP��ַ,����Ǹ��㲥��ַ(�����255)
	 * 3.���ձ߷��Ļ�Ҫʵ�ֶ��߳�
	 * 4.ÿ��������Ҫ�з��Ͷ˺ͽ��ն�
	 * 5.UDPֻ�ַ��Ͷ˺ͽ��ն�,û�пͻ��˺ͷ�������
	 */
	public static void main(String args[]){
		try {
			DatagramSocket send = new DatagramSocket();
			DatagramSocket rece = new DatagramSocket(10001);
			Thread sendThread = new Thread(new Send(send));
			Thread receThread = new Thread(new Rece(rece));
			receThread.setDaemon(true);
			sendThread.start();
			receThread.start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
