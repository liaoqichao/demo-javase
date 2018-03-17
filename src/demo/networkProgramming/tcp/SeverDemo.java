package demo.networkProgramming.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ���󣺷��������յ��ͻ��˵���Ϣ,����ӡ������̨��
		 * TCP���������������˼·��
		 * 1.������������socket����,����ServerSocket����
		 * 2.�������˱�������ṩһ���˿�,����ֻ�����ӵ�IP��Ӧ������,���������Ǹ������Ķ��õ�Ӧ�ó���(����)
		 * 3.��ȡ���ӹ����Ŀͻ��˶���(socket����)
		 * 4.ͨ���ͻ��˶���ķ���,��ȡ(getInputStream)�ͻ��˷���������,����ӡ�ڿ���̨��
		 * 5.�ر���Դ���رտͻ�����Դ�͹رշ���������Դ
		 */
		
		try {
			//1.�����������˶���
			ServerSocket ss = new ServerSocket(10002);//����������˵Ķ˿�Ҫ�Ϳͻ��˵Ķ˿�һ��
			
			//2.��ȡ���ӹ����Ŀͻ��˶���
			Socket s = ss.accept();//Ҫ��סŶ������ʽ
			String ip = s.getInetAddress().getHostAddress();
			
			//3.ͨ��socket�����ȡ������,��ȡ�ͻ��˷���������
			InputStream is = s.getInputStream();
			
			
			//4.ͨ���ͻ��˶���ķ�����ȡ����
			byte[] buf = new byte[1024];
			
//			int len = is.read(buf);
//			String text = new String(buf,0,len);
//			System.out.println(ip + ":" + text);
			
			/*ʹ�ÿͻ���socket�������������ͻ��˷�������*/
			/*
			 * Ϊʲô��while((len = is.read(buf)!=-1)ѭ��,len��ֵһֱ��16,���ᵽ-1
			 */
			OutputStream out = s.getOutputStream();
			int len = 0;
			while((len = is.read(buf))!= -1){
				String text = new String(buf,0,len);
				System.out.println(ip+":"+text);
				out.write("�յ�".getBytes());						
			}
//			out.write("�յ�".getBytes());						
			
			s.close();
			ss.close();//��������һ���ǲ��رյ�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
