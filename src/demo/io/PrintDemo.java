package demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintDemo implements IO {

	/**
	 * ��ӡ��
	 * ����ֱ�Ӳ������������ļ�
	 * ��ӡ��ֻ����Ŀ��(�ڴ�->Ӳ��)���
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
	}
	public void demo1() throws FileNotFoundException{
		
		/*
		 * PrintStream
		 * 1.����IOException
		 * ���캯�����ַ���·��,File����,�ֽ������
		 */
		PrintStream out = new PrintStream("E:\\Eclipse\\IO\\Print\\demo1.txt");
		/*
		 * write(int��byte����<���,�ص�>)
		 * write(97);97��ԭʼ�ֽ�,�Ǵ���a ��write("97"); �������97
		 * ֻȡ���8λ�ֽڡ�  00000000 00000000 00000000 01100001 ֻȡ����8λ  Ȼ����±������������a
		 *  00000000 00000000 11111111 01100001	����a
		 * print(97); ���±��������97	
		 * print������ԭ���ı�����ʽ97����97����a,��������ԭ���Ĵ�С��"97"2���ֽڣ�97 1���ֽ�
		 */
		out.write(12);
		out.print(97);//�Ȱ�97����ַ���97,Ȼ���ٵ���write("97");
		out.close();
		
	}
	public void demo2() throws IOException{
		/*
		 * �ַ���ӡ��PrintWriter
		 * ���캯��
		 * 1.·��
		 * 2.file
		 * 3.�ֽ������OutputStream
		 * 4.�ַ������Writer
		 */
		File file = new File("E:\\Eclipse\\IO\\Print\\demo2.txt");
		if(!file.exists())
			file.createNewFile();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//��������
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		PrintWriter out = new PrintWriter(bw,true);//�Ƿ��Զ�ˢ��trueΪ��
		String s = null;
		while((s = br.readLine())!= null){
			if(s.equals("over"))
				break;
			out.println(s.toUpperCase());//println����-_,-
			//out.flush();���Զ�ˢ��������Բ�д����������ˢ�µĻ�������1��txt�����ʾһ�С�
			//û��ˢ�µĻ�,ֱ��out.close(),�Űѻ�����ȫ��������д��txt��ˢ��
		}
		br.close();
		out.close();
	}
}
