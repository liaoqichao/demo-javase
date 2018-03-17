package demo.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo implements IO {
	/**
	 * PipedInputStream PipedOutputStream
	 * ����������������û��ֱ����ϵ,��Ҫһ��byte[] buf = new byte[1024]���ַ����飬int len��char ch������ϵ
	 * �ܵ�������Ӧ�����ӹܵ������,�ܵ��������ṩ�ܵ���������������ݡ����������û���ݸ���read()�ͻ��������״̬.���Խ�����̡߳�
	 * 1�����߳̽�������״̬,����һ���߳�д�˺�,�������ݿ��Զ�,�̻߳ص�����״̬
	 */

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
	}
	public void demo1() throws IOException{
		
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream();//new PipedInputStream(pos);Ҳ���Բ�����ϵ,����Ҫ��connect
		//��������ʱû��ϵ
		pis.connect(pos);//������ϵ
		
		//�����߳�
		Thread t1 = new Thread(new Input(pis));
		Thread t2 = new Thread(new Output(pos));
		t1.start();
		t2.start();
		
		/*
		 * s = hi!,�ܵ�����!
		 * 
		 * ���������������������
		 */
	}

}
class Input implements Runnable{

	private PipedInputStream in;
	Input(PipedInputStream in){
		this.in = in;
	}
	public void run() {
		try {
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String s = new String(buf,0,len);
			System.out.println("s = "+s);
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}

class Output implements Runnable{
	
	private PipedOutputStream out;
	Output(PipedOutputStream out){
		this.out = out ;
		
	}
	public void run(){
		try {
			Thread.sleep(5000);//�����sleep5��,����������û�����ݸ�������,��������״̬.����5��ʲô��û��Ӧ
			out.write("hi!,�ܵ�����!".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
