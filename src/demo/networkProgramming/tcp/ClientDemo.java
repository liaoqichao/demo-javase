package demo.networkProgramming.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * ���󣺿ͻ��˷����ݵ������
		 * TCP����ͻ��˽�����˼·��
		 * 1.����TCP�ͻ���socket����,ʹ��Socket����,����һ��������ȷҪ���ӵ�����
		 * 2.������ӽ����ɹ�,˵�����ݴ���ͨ��(socket��/����IO��)�ѽ�����
		 * 	 socket���ǵײ㽨����,���������������,��Ҫ��������������,������Socket��ȡ��(socket������getInputstream��getOutputSream����)
		 * 3.ʹ�������,д����д������(��������).���캯���Ѿ���ȷĿ����.
		 * 4.�ر���Դ
		 */
		
		try {
			//1.�����ͻ���socket����
			Socket socket = new Socket("192.168.1.104",10002);//��֪�������ľ�����ip��360
			//��������û���Ļ�,������������,�׳��쳣
			
			//2.��ȡsocket�������
			OutputStream os = socket.getOutputStream();
			
			//3.ʹ�������������д��ȥ
			os.write("tcp��ʾ,���˸���".getBytes());
			
			
			/*��ȡ�������˷��ص�����*/
			InputStream is = socket.getInputStream();
			byte[] buf = new byte[1024];		
			int len = is.read(buf);
			String text = new String(buf,0,len);
			System.out.println(text);
			
			//4.�ر���Դ
			socket.close();//os���Բ��ù�,��Ϊsocket�ر���,���ӶϿ�,û������
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
