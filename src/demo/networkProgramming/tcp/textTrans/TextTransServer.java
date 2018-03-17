package demo.networkProgramming.tcp.textTrans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TextTransServer {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * ת���������ˣ�
		 * ����
		 * 1.������������ServerSocket����
		 * 2.��ȡ���ӹ�����socket����
		 * 3.��ȡsocket������������Դ����ȡ�ͻ��˷�������Ҫת��������
		 * 4.Ŀ�ģ���ʾ�ڷ������˿���̨��
		 * 5.��ȡsocket�������������ת�ɴ�д,�����ͻ��ˡ�
		 */
		
		//1.
		ServerSocket ss = new ServerSocket(10004);
		
		//2.
		Socket s = ss.accept();
		//��ȡip
		String ip  = s.getLocalAddress().getHostAddress();
		System.out.println(ip+"... is connected");
		
		//3.��ȡsocket��������װ��
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//4.��ȡsocket�������װ��
		//PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//5.��ȡ������
		String line = null;
		while((line = bufIn.readLine()) != null){
			System.out.println(line);
			//out.println(line.toUpperCase());
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
		}
		s.close();
		ss.close();
	}

}
