package demo.hexConversion;

import demo.DemoInterface;

public class HexConversion implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//���ú���
		//decimaltoOther();
		//octaltoOther();
		//hexadecimaltoOther();
		//binarytoOther();
		//��������������洢

	}
	/*
	 * һ���ֽ�8λ��log2(16)=4,4λ��ʾһλʮ������,3λ��ʾ8���ƣ�1λ��ʾ2����,(4λ��ʾһ��ʮ��������)
	 * JAVA��int���ͳ���Ϊ�ĸ��ֽڣ����Ա�ʾ8λʮ��������
	 * 
	 * 
	 * ����ת��ǰ����int����
	 * ����ת������String����
	 * 
	 * 
	 * ����ʮ����	int a=233;
	 * �����˽���	int b=0123;int 012345; ǰ���1��0�͹�
	 * ����ʮ������	int c=0xd2f; ǰ���0x
	 * ����������	int d=0b10101; ǰ���0b
	 * JAVA������������������������int d=0b10101,System.out.println(d)����21;
	 * 
	 * 
	 * ֱ�������Ľ��ƵĻ���������ý��Ƶ�ʮ����ֵ��Ҫ��System.out.printf("%o"(�˽���)/"%x"(ʮ������),a);���
	 * 
	 * 
	 * Integer.toString(int a,int b);��aת����b�������ַ�����ʾ.b>36��ô��?����36�ᰴ��ʮ������������ᰴ��b�������
	 * 
	 * Integer.toHexString,.toOctalString,.toBinaryString(int a);������aת����ʮ����
	 * 
	 * Integer.valueOf(int a/String s/String s,int a).toSting,.toHexString,.toOctalString,
	 * .toBinaryString.
	 * int a,����aֵ��Integerʵ��??
	 * String s��ʾ���ַ�������ʮ���Ʊ��������String s,int a ��ʾ���ַ�������a���Ʊ������
	 * String a=123;��int b=8;
	 * ����Integer.valueOf(a,b)���ַ���123�����8���Ʊ�ʾ��123����ʮ���Ƶ�ֵΪ83��
	 * ��b=16���ַ���a�����ʮ�����Ʊ�ʾ��ʾ��123����ʮ���Ƶ�ֵΪ291
	 */
	public void decimaltoOther(){	//ʮ����ת������������
		int a = 233;
		System.out.println("ʮ����: "+a);
		//ʮ����ת����ʮ������
		String a10to16 =Integer.toHexString(a);
		System.out.println("ʮ������: "+a10to16);
		//ʮ����ת�����˽���
		String a10to8 =Integer.toOctalString(a);
		System.out.println("�˽��ƣ� "+a10to8);
		//ʮ����ת����������
		String a10to2 =Integer.toBinaryString(a);
		System.out.println("�����ƣ� "+a10to2);
		System.out.println();
	}
	public void octaltoOther(){		//�˽���ת������������,�����������ת������
		int b =0123;//int b=0123(�˽���) == int b=83(ʮ����)������������ʮ����
		System.out.printf("�˽���: "+"%o", b);//��printf����Ȼ����Ľ��Ϊʮ���Ƶ�83
		System.out.println();
		//�˽���ת����ʮ����
		//String b8to10 = Integer.toString(b, 10);
		String b8to10 =Integer.valueOf(b).toString();
		System.out.println("ʮ����: "+b8to10);
		//�˽���ת����ʮ������
		//String b8to16 =Integer.toString(b, 16); //1
		//String b8to16 = Integer.toHexString(b); //2
		@SuppressWarnings("static-access")
		String b8to16 =Integer.valueOf(b).toHexString(b);//3
		System.out.println("ʮ������: "+b8to16);	
		//�˽���ת����������
		//String b8to2 = Integer.toString(b, 2); 	//1
		//String b8to2 = Integer.toBinaryString(b);	//2
		@SuppressWarnings("static-access")
		String b8to2 =Integer.valueOf(b).toBinaryString(b);//3
		System.out.println("������: "+b8to2);
		System.out.println();
	}
	public void hexadecimaltoOther(){	//ʮ������ת������������
		int c = 0x0D2F;//���ΪΪ��ĸʱ��ǰ���0��ǿ�������֣�����Ҳ���ԡ�0xcdf���һ��
		System.out.printf("ʮ�����ƣ�"+ "%x", c);
		System.out.println();
		//ʮ������ת����ʮ����
		String c16to10 =Integer.toString(c, 10);
		System.out.println("ʮ���ƣ� "+c16to10);
		//ʮ������ת�����˽���
		String c16to8 =Integer.toString(c, 8);
		System.out.println("�˽��ƣ� "+c16to8);
		//ʮ������ת����������
		String c16to2 =Integer.toString(c, 2);
		System.out.println("�����ƣ� "+c16to2);
		System.out.println();
	}
	public void binarytoOther(){	//������ת������������
		String d ="1011101"; //JAVA���������������
		System.out.println("�����ƣ� "+d);
		//������ת����ʮ����
		String d2to10 =Integer.valueOf(d,2).toString();
		System.out.println("ʮ����: "+d2to10);
		//������ת�����˽���
		String d2to8 =Integer.toOctalString(Integer.valueOf(d,2));
		System.out.println("�˽��ƣ� "+d2to8);
		//�����ƻ�����ʮ������
		String d2to16 =Integer.toHexString(Integer.valueOf(d,2));
		System.out.println("ʮ�����ƣ� "+d2to16);
		System.out.println();
	}

}
