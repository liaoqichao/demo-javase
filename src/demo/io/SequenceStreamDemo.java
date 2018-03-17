package demo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

public class SequenceStreamDemo implements IO {

	/**
	 * ������
	 * �Զ�������кϲ�
	 * ������ֵ����Դ(Ӳ��->�ڴ�)����
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();		
		//demo4();
	}
	public void demo1() throws IOException{
		/*
		 * SequenceInputStream ��ʾ�������������߼��������ֽ�����һ���ܺϲ��ı����ܺϲ�������ʽ�ļ�
		 * ����ֻ����2���ֽ������ֽ���������   ���� �ֽ������ֽ����������ö��
		 * ��ΪҪ��ö������ֻ����vector��������
		 * ���󣺽�1.txt,2.txt,3.txt�����ݺϲ���һ���ļ���
		 */
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(new FileInputStream("E:\\Eclipse\\IO\\Sequence\\1.txt"));
		v.add(new FileInputStream("E:\\Eclipse\\IO\\Sequence\\2.txt"));
		v.add(new FileInputStream("E:\\Eclipse\\IO\\Sequence\\3.txt"));
		Enumeration<FileInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);//InputStream������
		File demo1 = new File("E:\\Eclipse\\IO\\Sequence\\demo1.txt");
		//FileOutputStream fos = new FileOutputStream(demo1);
		BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(demo1));
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = sis.read(buf))!=-1){
			bos.write(buf, 0, len);
			bos.flush();
		}
		bos.close();
		sis.close();
	}
	public void demo2() throws IOException{
		/*
		 * ���󣺽�1.txt,2.txt,3.txt�����ݺϲ���һ���ļ��С�
		 * Ȼ��VectorЧ�ʵͣ����á�������ArrayList�� Ȼ���õ���������ö�١�
		 */
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int i = 1 ; i<=3 ;i++){
			al.add(new FileInputStream("E:\\Eclipse\\IO\\Sequence\\"+i+".txt"));
		}
		Enumeration<FileInputStream> en = Collections.enumeration(al);//�����ע��Ϊԭ��
		
		SequenceInputStream sis = new SequenceInputStream(en);
		
		BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("E:\\Eclipse\\IO\\Sequence\\demo2.txt"));
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = sis.read(buf)) != -1){
			bw.write(buf, 0, len);
			bw.flush();
		}
		sis.close();
		bw.close();
		//final Iterator<FileInputStream> it = al.iterator();//��Ϊ�����ڲ�������Ҫ��final
		/*
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>(){//�����ڲ���

			@Override
			public boolean hasMoreElements() {
				// TODO Auto-generated method stub
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				// TODO Auto-generated method stub
				return it.next();
			}
		};//�ڲ�������зֺ�
		*/
	}
	public void demo3() throws IOException{			//�ļ��и�
		File file = new File("E:\\Eclipse\\IO\\Sequence\\�}ľ����-SAFEST PLACE.wma");
		File dir = new File("E:\\Eclipse\\IO\\Sequence");
		int n = 1;
		splitFile(file , dir, n);
	}
	public void splitFile(File file,File dir,int n) throws IOException {
		//�ö�ȡ������Դ�ļ�
		BufferedInputStream  bis = new BufferedInputStream(new FileInputStream(file));
		//���建������С
		final int SIZE = n*1048576;//1024*1024 = 1MB
		byte[] buf = new byte[SIZE];
		
		//����Ŀ��
		File destdir = new File(dir.getAbsolutePath()+"\\splitFile");//��ָ��Ŀ¼�½����ļ���,�ѷָ��ļ��浽�ļ�����
		if(!destdir.exists())
			destdir.mkdir();
		//��¼������Ϣ
		FileOutputStream propfos = new FileOutputStream(new File(destdir,"Properties.properties"));
		Properties prop = new Properties();
		prop.setProperty("filename", file.getName());
		//�и�
		FileOutputStream fos = null;
		int len;
		int count = 1;
		while((len = bis.read(buf))!= -1){
			//��Ƭ�ļ����и��һ�㲻��ֱ���Ķ�,�����ı����Լ�������չ��
			//����д��Ҳ������Ϊ�����Ĳ���, new fos(new File(dir,(count++)+".part");
			fos = new FileOutputStream(new File(destdir,"splitFile"+count+".part"));
			prop.setProperty("part"+count, "splitFile"+count+".part");
			count++;
			fos.write(buf, 0, len);
		}
		count --;
		Integer c = Integer.valueOf(count);
		prop.setProperty("partcount",c.toString());
		prop.store(propfos, "save file info");
		propfos.close();
		fos.close();
		bis.close();
	}
	public void demo4() throws IOException{		//���и��ļ��ĺϲ�
		File dir = new File("E:\\Eclipse\\IO\\Sequence\\splitFile");
		mergeFile(dir);
	}
	public void mergeFile(File dir) throws IOException{
		/*
		 * Ӧ��ÿ�����ܶ���Ϊһ������
		 * 1.��ȡ������Ϣ
		 * 2.��ȡ��Ƭ�ļ�,����list������
		 * 3.�ϲ���ʱ����
		 * 4.д�ϲ����ļ�
		 */
		//��ȡ������Ϣ
		File properties = new File(dir,"Properties.properties");
		if(!properties.exists()){
			System.out.println(dir+",��Ŀ¼��û�������ļ�");
			throw new RuntimeException();	//�Զ��������쳣Ҳ����
		}
		FileReader fr  = new FileReader(properties); 
		Properties prop = new Properties();
		prop.load(fr);
		//
		//File[] files = dir.listFiles();
		List<FileInputStream> list = new ArrayList<FileInputStream>();//����FileInputStream����File
		/*
		for(File file : files){
			if(file.getName().endsWith(".part"))//����������ʵ��filenameFilterҲ����
			list.add(new FileInputStream(file));
		}*/
		//��ȡ��Ƭ�ļ�
		int count = Integer.valueOf(prop.getProperty("partcount"));
		//��׳���ж�
		File[] parts = dir.listFiles(new SuffixFilter(".part"));//ǰ��д�ĺ�׺��������
		if(parts.length!=count){
			System.out.println("��Ƭ�ļ���Ŀ�������ļ���Ϣ��ƥ��,Ӧ����"+count+"��");
			throw new RuntimeException();
		}
		for(int i = 1 ; i<=count;i++){
			list.add(new FileInputStream(new File(dir,prop.getProperty("part"+i))));
		}
		Enumeration<FileInputStream> en = Collections.enumeration(list);//�����б�
		SequenceInputStream sis = new SequenceInputStream(en);//����ö��
		//���������
		FileOutputStream fos = new FileOutputStream(new File(dir.getParent(),"merge_"+prop.getProperty("filename")));
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = sis.read(buf))!= -1){
			fos.write(buf, 0, len);
		}
		sis.close();
		fos.close();
	}
}
