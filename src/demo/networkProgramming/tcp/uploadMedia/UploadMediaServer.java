package demo.networkProgramming.tcp.uploadMedia;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadMediaServer {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//1.
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(10006);
		
		while(true){	//ʵ�ֶ��߳�
			//2.
			Socket s = ss.accept();
//			String ip = s.getInetAddress().getHostAddress();
//			System.out.println(ip+" is connected");
			
			
			new Thread(new UploadTask(s)).start();
			//�ظ������ݷŵ�UploadTask�����run��������
			
		}
		//ȥ��whileѭ�����½��߳̾��ǵ��߳�
//		//3.
//		BufferedInputStream in = new BufferedInputStream(s.getInputStream());
//		
//		//4.��ȡ�����ݴ洢���ļ�����
//		
//		FileOutputStream fos = new FileOutputStream(
//				"E:\\Eclipse\\IO\\tcp\\Server\\"+ip+"�}ľ����-SAFEST PLACE.wma");
//		
//		byte[] buf = new byte[1024];
//		int len = 0;
//		while((len = in.read(buf))!= -1){
//			fos.write(buf,0,len);
//		}
//		
//		//5.���ͻ��˷����ϴ��ɹ���Ϣ
//		OutputStream out = s.getOutputStream();
//		out.write("�ϴ��ɹ�".getBytes());
//		
//		//6.
//		fos.close();
//		s.close();
//		ss.close();
		
	}

}
