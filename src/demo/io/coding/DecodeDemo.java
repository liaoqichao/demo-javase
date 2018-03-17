package demo.io.coding;

import java.io.UnsupportedEncodingException;

public class DecodeDemo implements Coding {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
	}
	public void demo1() throws UnsupportedEncodingException{
		//GBK���  
		byte[] buf = {-60,-29,-70,-61};	//���
		String s1 = new String(buf);
		System.out.println(s1);
		//uft-8���
		byte[] buf1 = {-28,-67,-96,-27,-91,-67};
		String s2 = new String(buf1,"utf-8");
		System.out.println(s2);//���
	}
	public void demo2() throws UnsupportedEncodingException{
		//���ݿ��Ա����
		byte[] buf = {-60,-29,-70,-61};	//GBK��� ���
		String s = new String(buf,"iso8859-1");//��ŷ�����⺺�֣�Tomcat����������iso8859-1
		System.out.println(s);//????

		byte[] buf1 = s.getBytes("iso8859-1");	//���Ӳ�����Ĭ��GBK���(���ļ������ϵͳ)
		String s1 = new String(buf1,"GBK");
		System.out.println(s1);//���		
	}
	public void demo3() throws UnsupportedEncodingException{
		//���ݱ䲻����
		/*
		 * ��������"лл"��ʱ������Ա����,��ΪGBK"лл"��UTF-8��"�Ц�" (�ֽ����������û��)
		 * ��GBK"���"��UTF-8��???(��UTF-8���� -17-65-67 ����ʾ���е�δ֪���?),�����ֽ���������ݱ仯��,���ܱ�����
		 */
		byte[] buf = {-60,-29,-70,-61};	//GBK���  ���
		String s = new String(buf,"utf-8");
		System.out.println(s);//???
		
		byte[] buf1 = s.getBytes("UTF-8");	
		EncodeDemo.printBytes(buf1);//-17-65-67-17-65-67-17-65-67  ��Դ���ݲ�һ��
		String s1 = new String(buf1,"GBK");
		System.out.println(s1);//���?
	}

}
