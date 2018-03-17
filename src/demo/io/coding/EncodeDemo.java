package demo.io.coding;

import java.io.UnsupportedEncodingException;

public class EncodeDemo implements Coding {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();//��ͨ����
		//demo3();
	}
	public void demo1() throws UnsupportedEncodingException{
		/*
		 * "���"��GBK���� ��	-60-29-70-61
		 * "���"��UTF-8���룺	-28-67-96-27-91-67
		 * 
		 * ���������˽ⲻ��������������,�����,�п����оȡ�
		 */
		String s = "���";
		byte[] buf = s.getBytes("GBK");
		printBytes(buf);
		byte[] buf1 = s.getBytes("utf-8");
		printBytes(buf1);
	}
	public void demo2(){		//��ͨ����
		
		String s = "��ͨ";
		byte[] buf = s.getBytes();//GBK����
		printBytesBinary(buf);
		/*
		 * 11000001 10101010 11001101 10101000 
		 * 110 10		110	10
		 * �պ÷���UTF-8��2���ֽڵĹ淶,����TXT�������Ϊ��UTF-8����,�Ӷ���������
		 */
	}
	public void demo3() throws UnsupportedEncodingException{
		/*
		 * java��,�ַ���"ab���"���ַ���"abcd"�ַ�������һ��,�ֽڳ��Ȳ�һ����
		 * ����һ������,��������ֽ���ȡ�ִ���
		 * ����"ab���",���ȡ3��,"��"��һ��ͱ�ȡ����,��ô�����Ҫ��������ȡ4���ֽ�"ab��"��ȡ5���ֽڻ���"ab��"
		 * ���������ĸ��������,���ֶ��Ǹ���(����GBK����Щ���������ģ�����"�i"bei -84 105  ���Ƕ��Ǹ������������),���ǵ�UTF-8����3����
		 */

		String s = "ab���CDлл";
		int len = s.getBytes("GBK").length;
		System.out.println(len);
		for(int i = 0;i<len;i++){
			
			String subs = cutStringByBytesByGBK(s,i+1);
			System.out.println("��ȡ"+(i+1)+"���ֽڵĽ�� : "+subs);
		}
		
		int len1 = s.getBytes("utf-8").length;
		for(int i = 0;i<len1;i++){
			
			String subs = cutStringByBytesByU8(s,i+1);
			System.out.println("��ȡ"+(i+1)+"���ֽڵĽ�� : "+subs);
		}
	}
	private String cutStringByBytesByU8(String s, int len) throws UnsupportedEncodingException {
		byte[] buf = s.getBytes("UTF-8");
		int count = 0;
		for(int i = len-1 ; i>=0 ; i--){
			if(buf[i]<0)
				count++;
			else
				break;
		}
		if(count%3==0)
			return new String(buf,0,len,"UTF-8");
		else if(count%3==1)
			return new String(buf,0,len-1,"UTF-8");
		else
			return new String(buf,0,len-2,"UTF-8");
	}
	public String cutStringByBytesByGBK(String s,int len) throws UnsupportedEncodingException {

		byte[] buf = s.getBytes("GBK");
		int count = 0;
		for(int i = len-1 ; i>=0 ; i--){
			if(buf[i]<0)
				count++;
			else
				break;
		}
		if(count%2==0)
			return new String(buf,0,len,"GBK");
		return new String(buf,0,len-1,"GBK");
	}
	public static void printBytes(byte[] buf) {
		for(byte b : buf){
			System.out.print(b);
		}
		System.out.println();
	}
	public static void printBytesBinary(byte[] buf){
		for(byte b : buf){
			System.out.print(Integer.toBinaryString(b&255)+" ");//��255,�����8���ֽ�
		}
		System.out.println();
	}

}
