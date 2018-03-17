package demo.networkProgramming.tcp.textTrans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TextTransClient {

	/**
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		/*
		 * �ͻ��ˣ�
		 * 1.����socket�ͻ��˶���
		 * 2.�ͻ��˵�����Դ������
		 * 3.�ͻ��˵�Ŀ��:socket
		 * 4.���շ������˵����ݡ�Դ��socket
		 * 5.�����ݴ�ӡ������̨��Ŀ�ģ�����̨
		 * 6.����Щ�������е����ݶ����ı�����
		 * 
		 * ת���ͻ���:
		 * 1.����socket�ͻ��˶���
		 * 2.��ȡ����¼��
		 * 3.��¼����Ϣ���͸�socket������
		 * 4.socket������,��ȡ����˷��صĴ�д����
		 * 
		 * ����ʽ���������ÿͻ��˺ͷ������˶��ڵȴ�״̬ (ȱ�ٽ������)
		 */
		
		//1.����socket�ͻ��˶���
		Socket socket = new Socket("192.168.1.104",10004);
		
		//2.��ȡ����¼��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//������
		
		//3.socket�����
		PrintWriter out  = new PrintWriter(socket.getOutputStream(),true);//�����ı���ʽ�����97->"97"������a
																	//true�Զ�ˢ��
		//4.socket������,��ȡ����˷��صĴ�д����
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));//��socket
		 
		String line = null;
		while((line = br.readLine())!= null){
			if("over".equals(line))
				break;		//break������socket.close �������˵�bufInΪ�ս���ѭ��
			out.println(line);//д����������
			
			//��ȡ�������˷��ص�һ�д�д����
			String upperStr = bufIn.readLine();
			System.out.println(upperStr);
		}
		
		//br���Բ��ù�,��Ϊ�Ǽ���
		socket.close();
	}
}
