package demo.basicDataTypeClass;

import demo.DemoInterface;

public class BasicDataTypeClass implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//demo1();

	}
	public void demo1(){
		/*
		 * �� java.lang.IntegerΪ��
		 */
		System.out.println("IntMax = "+Integer.MAX_VALUE+"   IntMin = "+Integer.MIN_VALUE);
		System.out.println(Integer.toString(233));//����233����ַ���"233"
		
		int num = Integer.parseInt("123");//�����"a123"���׳��쳣
		System.out.println("num+4 = "+(num+4));		
		
		System.out.println("��ʮ���Ƶ�60ת����ʮ������ ��60 :"+Integer.toHexString(60));		//ʮ����ת����16����String����
		System.out.println("��16���Ƶ�3cת����ʮ����\"��3c : "+Integer.parseInt("3c", 16));		//String,����(16���ƵĻ�����16)
	}
}
/*
 * ������������				������������(��)
 * byte					Byte
 * short				Short
 * int					Integer
 * long					Long
 * boolean				Boolean
 * float				Float
 * char					Character
 * 
 * �����������Ͱ�װ�����õ������ǣ��ѻ����������ͺ��ַ���֮���ת��
 * 1.����������  ת����  �ַ���
 * 		������������+"";
 * 		������������.toString(������������ֵ);
 * 2.�ַ��� ת���� ������������
 * 		parseInt(String s);//parse��ת������˼  ��̬����,��������
 * 		intValue(String s);//Ҫ�ö������
 * 		����Character ,���������������Ͷ���parseLong(String s),parseBoolean(String s)�ȷ���
 * 		parseBoolean(String s)��s Ϊ "true","false";
 */
