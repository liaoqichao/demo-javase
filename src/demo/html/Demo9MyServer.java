package demo.html;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo9MyServer {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1
		ServerSocket ss = new ServerSocket(9090);
		
		//2
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress() +" is connected");
		
		//3
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		//4
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//��Ҫ��out.write() write��ֱ�Ӽ̳и���ķ���
		
//		������Ҫ�����ڣ�Ϊʲô�ͻ��˵�����write()��flush()�󣬷���������Ȼread�������ݡ�
//		��Ϊsocket.getOutputStream()ȡ����ʵ������java.net.SocketOutputStream������ಢû�и�дflush������
//		���ĸ���java.io.FileOutputStreamҲû�и�д���������վ͵��������java.io.OutputStream��flush()��������Ͷ����ˣ�
//		��������ǿյġ�����...
//		��ˣ�����ʹ��Reader.readLine()��Writer.println()������socket��
		out.println("<font color='green' size=7 />ע��ɹ�</font>");
		
		s.close();
		ss.close();
	}

}
