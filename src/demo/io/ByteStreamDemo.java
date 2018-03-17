package demo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamDemo implements IO {

	/**
	 * ��CPU�Ͽ�  ����input д��output
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub

		//demo1_ByteStream();			//д
		//demo2_ByteStream();			//��
		//demo3_ByteStream();			//ý���ļ�����
		//demo4_ByteStream();			//ʹ�û�����ý���ļ�����
		//demo5_ByteStream();			//��������,��ʾ������̨Scanner
	}
	public void demo1_ByteStream() throws IOException{	//д
		
		//�����ֽ����������,���ڲ����ļ�
		FileOutputStream fos = new FileOutputStream("E:\\Eclipse\\IO\\ByteStream\\demo1.txt");
		
		//д���� ,�ֽ�������Ҫ��ʱ�洢����.ֱ��д�뵽Ŀ�ĵ��С��ֽ�������flush(flush����û����,flush�ǻ���������)
		fos.write("abcdefg".getBytes());
		
		//�ر���Դ
		fos.close();
	}
	public void demo2_ByteStream() throws IOException{	//��
		
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\IO\\ByteStream\\demo2.txt");
		byte[] bbuf = new byte[fis.available()];
		//fis.available();���ļ���������ʱ����ֽ���,����С�ļ�������ô�ã����ļ�����ֱ�ӳ������Χ��
		//�����ȶ����ܳ���,Ȼ��ּ��δ�������
		int len = 0;
		while((len = fis.read(bbuf))!=-1){
			System.out.print(new String(bbuf,0,len));
		}
		fis.close();
	}
	public void demo3_ByteStream() throws IOException{	//ý���ļ��ĸ���
		
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\IO\\ByteStream\\�}ľ����-SAFEST PLACE.wma");
		FileOutputStream fos = new FileOutputStream("E:\\Eclipse\\IO\\ByteStream\\copy�}ľ����-SAFEST PLACE.wma");
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = fis.read(buf))!= -1){
			fos.write(buf,0,len);
		}
		fis.close();
		fos.close();
	}
	public void demo4_ByteStream() throws IOException{	//ʹ�û�����ý���ļ�����
		
		/*
		 * �������ַ��������Ʒ��ı��ļ�,��Ϊ���ı��ļ��ı��뷽�����ַ����ı��뷽����һ��.
		 * ���ַ���,�ȵõ��ֽ�,Ȼ����(ASCII,Unicode��UTF-8��)���û�鵽 �ͻ���δ֪�ַ�������,Դ���ݺ�Ŀ�����ݾͲ�һ��.
		 * �Ͳ��ܱ�ͼƬ�༭������
		 */
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\IO\\ByteStream\\�}ľ����-SAFEST PLACE.wma");
		BufferedInputStream buffis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream("E:\\Eclipse\\IO\\ByteStream\\buffer copy�}ľ����-SAFEST PLACE.wma");
		BufferedOutputStream buffos = new BufferedOutputStream(fos);
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = buffis.read(buf))!=-1){
			
			buffos.write(buf, 0, len);
			buffos.flush();					//����Ҫˢ�£�
			
		}
		/* ǧ��Ҫ��,��ȫûЧ��
		while((len = buffis.read())!=-1){	//��һ���ֽ�дһ���ֽڳ�����
			buffos.write(len);
			buffos.flush();					//��һ���ֽ�дһ���ֽڻ�Ҫˢһ�εĻ�����
		}*/
		buffis.close();
		buffos.close();
	}
	public void demo5_ByteStream(){		//��������,��ʾ������̨Scanner
		
		/*
		 * ���̲�������, ֱ������һ��Ϊoverʱֹͣ����
		 * String(����)�ıȽϲ�����"=="������equals,Stringʵ��Comparable�ķ���CompareTo()
		 */
		 Scanner scanner = new Scanner(System.in);
		 String s = null;
		 while(!(s=scanner.nextLine()).equals("over"))
		 //while((s=scanner.nextLine()).compareTo("over")!=0)
			 System.out.println(s);		 
		 /*
		 while(true){
			 s = scanner.nextLine();
			 if(s.compareTo("over")==0)
				 break;
			 System.out.println(s);
		 }*/
		 scanner.close();
	}
}
