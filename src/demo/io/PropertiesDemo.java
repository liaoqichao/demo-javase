package demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo implements IO {

	/**
	 * util.Map->Hashtable->Properties
	 * Properties��ʾһ���־õ����Լ������Ա��������л������м���
	 * �ص㣺
	 * 1.�ü����еļ���ֵ�����ַ�������
	 * 2.�����е����ݿ��Ա��������л������м���
	 * 
	 * ͨ���ü������ڲ����Լ�ֵ����ʽ���ڵ������ļ�
	 * �������ݵ���ʽ��	1.����Ϣ��ֵ��		2.������Ϣ��xml		3.�ܶ���Ϣ�����ݿ�
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
		//demo4();
	}
	public void demo1(){		//Properties�Ĵ��ȡ��list
		
		Properties prop = new Properties();
		
		//�洢Ԫ��
		prop.setProperty("��", "ţ");
		prop.setProperty("��", "è");
		prop.setProperty("��", "��");
		prop.setProperty("߹", "Ѽ");
		prop.setProperty("Ŷ", "��");
		
		//ȡԪ��
		Set<String> set = prop.stringPropertyNames(); //��ȡ����
		for(Iterator<String> it = set.iterator() ; it.hasNext() ;){
			String key = it.next();
			String value = prop.getProperty(key);
			System.out.println(key+"="+value);
		}
		
		//list(PrintStream ps);  System.out ��PrintStream����,�˷���һ�����ڵ���
		prop.list(System.out);
		/*
		-- listing properties --
		߹=Ѽ
		Ŷ=��
		��=è
		��=ţ
		��=��
		*/
		
	}
	public void demo2() throws IOException{		//store����,�־û�
		/*
		 *  �־û�����Properties�������Ϣ��������(���浽Ӳ��)�����´�ʹ��
		 *  void store(OutputStream����Writer out,String comments)throws IOException
		 *  comments�����б������
		 */
		
		Properties prop = new Properties();
		
		prop.setProperty("ţ", "��");
		prop.setProperty("è", "��");
		prop.setProperty("��", "��");
		prop.setProperty("Ѽ", "߹");
		prop.setProperty("��", "Ŷ");
		
		FileWriter fw = new FileWriter("E:\\Eclipse\\IO\\Properties\\CryOfAnimals.ini");
		BufferedWriter bw = new BufferedWriter(fw);
		
		prop.store(bw, "Cry of Animals");//comments��д����, �����  #\u8DA3\u39AD  \\u����unicode��,4λ16���ƴ洢
		bw.close();
		
	}
	public void demo3() throws IOException{		//�޸�������Ϣ
		
		/*
		 * Properties���Ա��浽���д����л�ȡ
		 * �����е�����������һ���ļ�
		 * ��֤�ļ��е������Ǽ�ֵ��
		 * ��Ҫ��ȡ������� load(�ַ������ֽ���)
		 */
		Properties prop = new Properties();
		File file = new File("E:\\Eclipse\\IO\\Properties\\CryOfAnimals.ini");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//�����ļ�������(ֻ�ܼ��ؼ�ֵ��)��Properties������
		
		if(!file.exists())
			file.createNewFile();
		prop.load(br);
		
		//�޸�
		prop.setProperty("è", "���˸��������˸���");//��ô������ֵ��û����?��Ϊnew FileWriter��ʱ��ظ��ǵ�֮ǰ���ļ�

		//д���ļ�
		//����һ���¶���,ԭ�����ļ������½���һ��(���ǵ�֮ǰ������).����Ҫ��load���غ�Ŵ���bw����
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		prop.store(bw, "Modified Cry of Animals");//д��ʱ����ȫ��д,����ָд���޸ĵĲ���
		br.close();
		bw.close();
	}
	public void demo4() throws IOException{
		/*
		 * ��ȡ�������д���,�������5��,����ʹ�ô����ѵ���ע��(��������)����ʾ������Ҫ�����г���
		 */

		runCode();
	}
	private void runCode() throws IOException {
		// TODO Auto-generated method stub
		if(canRun()){
			System.out.println("Running...");
		}	
	}
	private boolean canRun() throws IOException{
		File file = new File("E:\\Eclipse\\IO\\Properties\\demo4.ini");
		Properties prop = new Properties();
		//�ж��ļ��Ƿ����
		if(!file.exists()){
			file.createNewFile();
		}
		//�����ļ���Ϣ
		BufferedReader br = new BufferedReader(new FileReader(file));
		prop.load(br);
		//�жϼ��Ƿ����
		String value = prop.getProperty("time");
		if(value == null){			//���������½���ֵ��
			prop.setProperty("time", "4");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			prop.store(bw, "demo7");
			System.out.println("ʣ��4�����ô���,�빺�����");
			bw.close();
			br.close();
			return true;
		}
		else{						//�������ȡ��ֵ�Ե�ֵ
			Integer uses = Integer.valueOf(prop.getProperty("time"));
			if(uses <= 0){			//ֵС�ڵ���0���޷�ʹ�����
				System.out.println("����޷�����,ʣ�����ô���Ϊ0,�빺�����");
				return false;
			}
			else{					//�������ʹ�����
				uses--;
				prop.setProperty("time", uses.toString());
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				prop.store(bw, "");
				System.out.println("ʣ��"+(uses)+"��ʹ��,�빺�����");
				bw.close();
				return true;
			}
		}
	}
}

