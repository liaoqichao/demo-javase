package demo.networkProgramming.tcp.uploadText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadClient {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		//1.
		Socket socket = new Socket("192.168.1.104",10005);
		
		//2.
		BufferedReader br = new BufferedReader(new FileReader("E:\\Eclipse\\IO\\tcp\\Client\\upload.txt"));
		
		//3.
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		String line = null;
		while((line = br.readLine())!= null){	//���ѭ�����Խ���,�����Ǳ����ļ�
			out.println(line);
		}
//		out.println("over");//���ý������,�ڷ��������жϽ������,����ѭ���Ϳ��Ա���˫���ȴ�
//		���������ļ������е���һ��over.������ʱ���
		//���߷�������,�ͻ���д����
		socket.shutdownOutput();
		//4.
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String str = null;
		str = in.readLine();//����ʽ
		System.out.println(str);
		
		br.close();
		socket.close();
	}

}
