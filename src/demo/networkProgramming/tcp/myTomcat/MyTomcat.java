package demo.networkProgramming.tcp.myTomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTomcat {		//�Զ�������� 
	//û��TomcatҪ��װIIS���ܴ�localhost
	//IIS�ڿ������\���п��������\������ �е�IIS(����6.0)
	//���ఴ��Сͼ����й�����,��Ȼ�Ҳ���
	//Ϊʲô360�����Դ�localhost��IE���Դ�localhost
	
	//MyBrowser����ƵԴ����

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1.���������������ӿڣ������ض���
		/*
		 * ����ϵͳ�����������ʹ��1~1023������ϵͳ���ܻ���Ҫ�õ�1~1023��������������ϵͳ��
		 * ����˿�Ϊ0��ʾ�ɲ���ϵͳ��Ϊ����������һ��������õĶ˿�.�ɲ���ϵͳ����Ķ˿�Ҳ��Ϊ�����˿�. 
		 * ���ڶ���������, ��ʹ����ȷ�Ķ˿�, ������ʹ�������˿ڡ� 
		 */
		ServerSocket ss = new ServerSocket(9090);
		
		/*
		 * 2.���������������ȡ��һ���ͻ�����������
		 * ���������û����������, accept() �����ͻ�һֱ�ȴ�, ֱ�����յ�����������ŷ���
		 */
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+" is connected");
		
		//3.
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.print(text);
		
		
		//4.���ͻ��˷�����Ϣ
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("<font color ='red' size='7'>��ӭ����</font>");//���Է����ڴ���Ϣ,�ļ���Ϣ,��վ��
		s.close();
		ss.close();
	}

}
//127.0.0.1 is connected

//�ٶ�HTTPЭ��Ŀͻ���(�����)��������,������Ϣͷ,��������
//			 �������˷��ظ��ͻ��˵ĵ�Ӧ����,Ӧ����Ϣͷ,Ӧ������(ҳ��)
//HTTPЭ����������,��Ϣ��ͷ,�����������	
//-----HTTPЭ��(����ƪ)��������
//GET / HTTP/1.1				<---������ ����ʽ  �������Դ·��httpЭ��汾
//---��������Ϣͷ,������������ֵ(Properties)
//Accept: text/html, application/xhtml+xml, */*		//����ʲôӦ�ó���������?
//Accept-Language: zh-CN							//֧������
//User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0)	//�û�����
//UA-CPU: AMD64
//Accept-Encoding: gzip, deflate					//֧�ֵ�ѹ����ʽ(�������˽���������ѹ��,��Ȼ��һ���ܴ����ҳҪ�򿪰���,���͸��ͻ��˽�ѹ��)
//Host: localhost:9090
//Connection: Keep-Alive			Keep-Alive��˼������һ�������ΪHTTP����״̬Э�顣������̶Ͽ��Ļ�,��������Ҫ�������ӡ�
//									��Ϊҳ����һ������,ҳ�����ͼƬҲ�ǵ�����һ������,��һ����ҳ��ʵ�������ɴ������,��������̶Ͽ��ͺ��˷ѡ�
//									��Keep-Alive�Ϳ���һ�����ӿ�����Ӧ�������
									//HTTPЭ������״̬Э�顣Э���״̬��ָ��һ�δ�����ԡ���ס����δ�����Ϣ��������
//									http�ǲ���Ϊ����һ�����Ӷ�ά������������������Ϣ,Ϊ�˱�֤�������ڴ档
//									����һ����վ��,HTTPЭ��ͶϿ���,����һֱ�����˷��������ε�����ҳ��Ҳ������ʧ
//									�򵥵�˵����״̬����������Ӧ��ͶϿ�����״̬����һֱ������,��һ������͵ڶ�������֪�����㷢�ġ�FTPЭ�������״̬�ġ�

//����
//---������(�����к�������Ҫ�п���)
