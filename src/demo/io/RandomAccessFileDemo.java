package demo.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo implements IO {

	/**
	 * RandomAccessFile
	 * �ص㣺
	 * 1. ���ܶ�����д
	 * 2. �ö����ڲ�ά����һ��byte����,��ͨ��ָ��(�±�)���Բ��������е�Ԫ��.����������ӳ�
	 * 3. ����ͨ��getFilePointer������ȡָ���λ��,��ͨ��seek��������ָ���λ��
	 * 4. ��ʵ���ǽ��ֽ����������ֽ��������װ�ɶ���
	 * 
	 * ���췽��
	 * RandomAccessFile(File file,String mode)
	 * RandomAccessFile(String ·��,String mode)
	 * mode ���ļ��ķ���ģʽ
	 * "r"		ֻ����,�Զ������write���׳�IOException
	 * "rw"		���Զ�����д,�ļ����ڻ����Լ�����
	 * "rws"	���Զ�д,�����ļ������ݻ�Ԫ���ݵ�ÿ������ͬ��д�뵽�ײ��豸
	 * "rwd"	���Զ�д,�����ļ������ݵ�ÿ������ͬ��д���ײ��豸
	 * Ԫ���ݣ��������ݵ�����,����Properties��¼������
	 * 
	 * ͨ�����ڶ��߳�д��
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		demo3();
	}
	public void demo1() throws IOException {
		File file = new File("E:\\Eclipse\\IO\\RandomAccessFile\\demo1.txt");
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		raf.write("����".getBytes());
		raf.writeInt(97);			//   a   3���ո�1��aһ��4���ֽ�,���ǲ���ֻȡ���8λ
		//raf.write("97".getBytes());//����97���±��������a
		//raf.write("609".getBytes());//����609���±��������a,ֻȡ�����8λ��������,���8λ����97
		//raf.writeInt(609);			//  a   2���ո�1�����⸺��1��aһ��4���ֽ�
		raf.write("Сǿ".getBytes());	
		raf.writeInt(99);	
		//ʵ�����ֲ�û�иı�97����97..ֻ�Ǽ��±���97������a
		raf.close();
	}
	public void demo2() throws IOException{		//��ȡ,�����ȡ
		/*
		 * ������ʣ�����Ķ��ʹ��Ķ��� ͨ��seek()����ָ��
		 * ����������ļ�һ�����ݶ��й���.��Ȼ�������Ķ���4���ֽڣ������Ҫ6���ֽھͲ�֪����ôȡ
		 * ����������8������16���ֽ�,�������4���ֽ�,ǰ��12���ֽ��ÿ��ֽڲ�,����4���ֽڹ̶�.
		 * ����ÿ���˵�����+����һ��20���ֽ�,ÿ��ȡ20���ֽھ���ȡ1�����ݡ�����д���ݷ����ȡ
		 */
		File file = new File("E:\\Eclipse\\IO\\RandomAccessFile\\demo1.txt");
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		byte[] buf = new byte[4];// ������4���ֽ�  ����  ���ġ�����
		raf.read(buf);
		String name = new String(buf);
		System.out.println("name = "+name);//name = ����
		int age  = raf.readInt();
		System.out.println("age = "+age);//age = 97
		//int stringage = raf.readInt();
		//System.out.println("stringage = "+stringage);//stringage = 959919664 �ַ���"97"��Ӧ������
		System.out.println("pos : "+raf.getFilePointer());//pos : 8;
		//ͨ��seek����ָ��λ��,�����ȡ
		raf.seek(0);
		raf.read(buf);
		String name1 =new String(buf);
		System.out.println("name = "+name1);//name = ����
		raf.seek(8);//��һ��4���ֽ� ����, �ڶ���4���ֽ�97  ָ��ָ��8,�ٶ�����Сǿ
		raf.read(buf);
		String name2 =new String(buf);
		System.out.println("name = "+name2);//name = Сǿ

		raf.close();
	}
	public void demo3() throws IOException{		//д��,���д��
		/*
		 * ���֪���ļ���С(400�ֽ�)
		 * ���Խ���4���߳�ͬʱд,T1��0-100,T2:101-200;T3:201-300;T4:301-400
		 */
		File file = new File("E:\\Eclipse\\IO\\RandomAccessFile\\demo1.txt");
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		//���д��(ָ��λ��д��)
		raf.seek(16);//û��ָ��λ�þͻ��0�Ǳ꿪ʼд
		//���raf.seek(24);�Ļ�  ��3��8���ֽ�û������,���±��������4���ո�
		raf.write("����".getBytes());
		raf.writeInt(102);
		raf.write("����".getBytes());
		raf.writeInt(111);
		raf.close();
	}

}
