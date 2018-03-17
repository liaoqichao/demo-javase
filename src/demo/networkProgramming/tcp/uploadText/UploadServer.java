package demo.networkProgramming.tcp.uploadText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1.
		ServerSocket ss = new ServerSocket(10005);
		
		//2.
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+" is connected");
		
		//3.
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Eclipse\\IO\\tcp\\Server\\upload.txt"));
		String line = null;
		while((line = bufIn.readLine())!= null){	//˫���ȴ�,���ѭ���������ˡ�(�����Ƿ���ȱ�ٽ������)
//			��Ȼ��������,����socket����֪�������ı�ʶ,����bufIn.readLine()�ڵȴ�(����ʽ)��
//			��������-1,����û��д��ȥ(д"�ϴ��ɹ�"��ȥ),���Կͻ���in.readLine()�ڵȴ�
//			���¿ͻ��˺ͷ�������˫�����ڵȴ��Է�
//			if(line.equals("over"))	//���յ��ͻ��˷��͹����Ľ������,���������
//				break;
			bw.write(line);
			bw.newLine();
			bw.flush();//���ﲻˢ��,˫���ȴ�,Server\\upload.txtҲ������,�����8K(��������СĬ��8K)����8K��ˢ��һ��,�ڶ���û��8K��ûˢ��
		}
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("�ϴ��ɹ�");
		
		bw.close();
		s.close();
		ss.close();
	}

}
