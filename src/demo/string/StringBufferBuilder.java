package demo.string;

import demo.DemoInterface;

public class StringBufferBuilder implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		/**
		 * 
		 * JDK 1.5 �����StringBuilder
		 * StringBuilder һ���ɱ���ַ�����,������Ʊ�����StringBuffer�ļ����滻
		 * 
		 * StringBuffer ���̰߳�ȫ�Ŀɱ��ַ����� ��StringBuilder�̲߳���ȫ
		 * ���߳���StringBuilder �����ж�ͬ����
		 * 
		 * JDK�����ķ��棺
		 * 1.���Ч��		�����StringBuffer,StringBuilder���Ч��
		 * 2.����д
		 * 3.��߰�ȫ��
		 */
		//demo1_String();
		//demo2_String();
		//demo3_String();
		//demo4_String();
		//demo5_String();
		//demo6_String();
		//demo7_String();
		//demo8_String();
		//demo1_StringBuffer();
		//demo2_StringBuffer();
		//demo3_StringBuffer();
		//demo4_StringBuffer();
		//demo5_StringBuffer();
		//demo6_StringBuffer();
		
	}

	public void demo1_StringBuffer() {			//��������String��ת��
		// TODO Auto-generated method stub
		//��ʼ������Ϊ�յĶ���
		//StringBuffer sb = new StringBuffer();
		//��ʼ�������ݵĶ���
		StringBuffer sb1 = new StringBuffer("abc");
		/*
		 * StringBuffer s = "abc"; //����,��ֵ���Ͳ�ƥ��
		 * StringBuffer û�м̳й�ϵ ����ǿת����
		 */
		
		/*
		 * String �� StringBuffer ֮���ת��
		 */
		System.out.println("StringBuffer -> String : "+sb1.toString());//StringBuffer -> String
		String s = "abc";
		StringBuffer sb2 = new StringBuffer("String -> StringBuffer : "+s);//String -> StringBuffer
		System.out.println(sb2);
		
	}

	public void demo2_StringBuffer() {			//StringBuffer�ĳ��÷���,��ĩβ��������
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abc");
		System.out.println("ԭStringBuffer���� �� "+sb);
		/*
		 * StringBuffer���еķ���ƫ���ڶ����ַ����ı仯
		 * public StringBuffer append(boolean b)
		 * ������׷�ӵ�StringBuffer����ĩβ
		 * ����boolean b, char[] str, ,int,double,float,Object,StringBuffer��
		 */
		sb.append("def");	
		System.out.println("append������ĩβ׷������ : "+sb);//abcdef
		
	}

	public void demo3_StringBuffer() {			//ɾ������
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abcdef");
		System.out.println("ԭStringBuffer���� �� "+sb);
		/*
		 * public StringBuffer deleteCharAt(int index)
		 * sb.deleteCharAt(3);����ֱ�Ӹ�s������.���Ƿ����µĶ���
		 * ɾ��ָ��λ�õ��ַ�
		 * public StrngBuffer delete(int start,int end)
		 * ���ַ���һ������start,������end ,��Ϊֻ��start�Ļ�, endĬ��ΪStringBuffer.lengt()
		 */
		StringBuffer sb1 =sb.deleteCharAt(3);
		System.out.println("deleteCharAt����ɾ��һ���ַ� �� "+sb1);
		StringBuffer sb2 =sb.delete(2, 4);
		System.out.println("delete(int start,int end)����ɾ��һ���ַ� �� "+sb2);
		
	}

	public void demo4_StringBuffer() {			//����
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abcdef");
		System.out.println("ԭStringBuffer���� �� "+sb);
		/*
		 * public StringBuffer insert(int index,);
		 */
		System.out.println("insert(λ��,����)�������� : "+sb.insert(3, "123"));
		
	}

	public void demo5_StringBuffer() {			//���ݷ�ת
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abcdef");
		System.out.println("ԭStringBuffer���� �� "+sb);
		/*
		 * public synchronized StringBuffer reverse();
		 * �����ݷ�ת
		 */
		sb.reverse();
		System.out.println("��reverse���������ݷ�ת : "+sb);
		
	}

	public void demo6_StringBuffer() {			//�޸����������ֵ
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abcdef");
		System.out.println("ԭStringBuffer���� �� "+sb);
		/*
		 * public synchronized StringBuffer setCharAt(int index,char ch);
		 */
		sb.setCharAt(3, 'D');
		System.out.println("��setCharAt(int index,char ch)�����޸�ֵ : "+sb);
		
	}

	public void demo1_String() {			//�ַ�������
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 0 : ����");
		
		String s0 = "abc";
		String s1 = "abc";
		String s2 = new String("abc");
		System.out.println(s0==s1);//true
		System.out.println(s1==s2);//false
		
		/*
		 * ���ִ�����ʽ
		 *
		 *	char[] ch = new char[]{'h','e','l','l','o'};
		 *	String a = new String();
		 *	String b = new String("abc");
		 *	String c = new String(ch);
		 *	String d = new String(ch,1,3);//��ch�ַ�����ӵ�һ����ʼ,3���ַ�����
		 *	//String e =new String(StringBuffer buffer);
		 * 
		 */
		
	}

	public void demo2_String() {			//�ַ�����ȡ
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 1 : ��ȡ");
		
		String a ="abcdefghijklmnabcdabccd";
		System.out.println("ԭ�ַ��� : "+a);	
		System.out.println("�ַ����ĳ���Ϊ"+a.length());//��ȡ�ַ�������
		char c = a.charAt(2);				//��char���ͻ��a�ַ����±�Ϊ2���ַ�
		System.out.println("��charAt(index)��ȡ�ַ����±�Ϊindex�ַ�,����Ϊchar �� "+c);
		String a1 = a.substring(3, 7); 		//���ַ���Ϊԭ�ַ����±�Ϊ3,4,5,6(������endindex)���
											//��Ϊa.substring(3<��ʼλ��>) == a.substring(3.a.length());
		System.out.println("��substring(beginIndex,endIndex)��ȡ�����ַ��� : "+a1);
		
		int index = a.indexOf("abc");		//�����ַ���ȡ���ַ����е�λ��,���߸������ַ�����ȡ���ַ�����һ���ַ���ԭ�ַ����е�λ��
		//int index = a.indexOf('a');���߰�'a'����ASCII���97��ȡһ���ַ���һ�γ��ֵ�λ�� 
		System.out.println("��indexOf(String s)��ȡ���ַ���\"abc\"��һ�γ�����ԭ�ַ����ĵ�һ��Ԫ�ص��±�Ϊ "+index);
		System.out.println("��indexOf(String s,int fromIndex)��ȡ���ַ���\"abc\"��fromindexλ�ÿ�ʼ��һ�γ�����ԭ�ַ����ĵ�һ��Ԫ�ص��±�Ϊ "+a.indexOf("abc", index+"abc".length()));
		a.lastIndexOf("abc", 6);
		System.out.println("��indexOf(String s,int fromIndex)��ȡ���ַ���\"abc\"��fromindexλ��λ�����һ�γ�����ԭ�ַ����ĵ�һ��Ԫ�ص��±�Ϊ"+a.lastIndexOf("abc", 22));
		
	}

	public void demo3_String() {			//�ַ����ж�
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 2 : �ж�");
		
		String a ="abcdefghijklmnabcdABCcd";
		System.out.println("ԭ�ַ��� : "+a);
		
		//a.equals(String) a.equalsIgnoreCase(String)
		String b ="abcdefghijklmnabcdabccd";
		//a.equalsIgnoreCase(b)���Դ�Сд
		if(a.equals(b)) System.out.println("�ַ���a���ַ���bһ��");
		else System.out.println("�ַ���a���ַ���b��һ��");
		
		//a.contains(String)
		if(a.contains("ijk")) System.out.println("�ַ���a����\"ijk\"");
		else System.out.println("�ַ���a������\"ijk\"");
		
		//a.startsWith(String) a.endsWith(String)
		if(a.startsWith("abc")) System.out.println("�ַ���a��\"abc\"��ͷ");
		else System.out.println("�ַ���a������\"abc\"��ͷ");
		if(a.endsWith("abc")) System.out.println("�ַ���a��\"abc\"��β");
		else System.out.println("�ַ���a������\"abc\"��β");
		
	}

	public void demo4_String() {			//�ַ����Ƚ�
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 3 : �Ƚ�");
		
		String a ="xyz";
		System.out.println("ԭ�ַ��� : "+a);
		
		/*
		 * ����ıȽ��õ��Ƿ��������equals(),compareTo()��,
		 * �����������͵ıȽ���>��<��=�ȷ������
		 * a.compareTo(String b)
		 * a.compareToIgnoreCase(String b)//���Դ�Сд
		 * ����ASCII��˳��Ƚϴ�С
		 * ��� a == b return 0;
		 * ��� a > b ����һ������0����
		 * ��� a < b ����һ��С��0����
		 */
		
		//"xy"��a��,��ǰ��"xy".length()���ַ���һ��,����a.length()-"xy".length()��ֵ
		System.out.println(a.compareTo("xy"));
		//"xyza"��a��,��ǰ��a.length()�ַ���һ��,����a.lengt()-"xyza".lengt()��ֵ
		System.out.println(a.compareTo("xyza"));
		/*
		 * �����ַ������Ȳ�ͬ,�ҽ϶̵��ַ���������һ���ַ���ǰ�治��ȫ��ͬ,��һ��һ���ַ��Ƚ�,����в���ͬ
		 * ���̷���,�������Ƚ���ȥ
		 */
		System.out.println(a.compareTo("xYza"));
		/*
		 * System.out.println(('x'-'x')+'y'-'Y'); 'x'��'x'һ��,���Ϊ0�����Ƚ�,
		 * 'y'��'Y'��32������32
		 */
		System.out.println(a.compareTo("ab"));
		//System.out.println(('x'-'a'));
		
	}

	public void demo5_String() {			//��Сдת��
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 4 : ��Сдת��");
		
		String a ="xYzAbC";
		System.out.println("ԭ�ַ��� : "+a);
		/*
		 * a.toLowerCase(Locale locale);
		 * Locale locale �Լ������Сд�Ķ�Ӧ��ϵ
		 */
		System.out.println("ת��ΪСд : "+a.toLowerCase());
		System.out.println("ת��Ϊ��д : "+a.toUpperCase());
		
	}
		
	public void demo6_String() {			//�ַ����ָ��������ʽ
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 5 : �ַ����ָ�");
		String a = "This is the test5.";
		System.out.println("ԭ�ַ��� : "+a);
		//���շָ�����ָ�,�����ַ�����
		String[] b = a.split(" ");		
		/*
		 *  "\\.","\\|"  *,+�ȶ�Ҫת��"\\+"
		 *  a.split(" ",2);��ʾ���ָ��2���ַ�������
		 *  ����ַ���0 This  �ַ���1 is the test5.
		 *  a.split(regex,limit);��һ��������������ʽ,�ڶ������Ʒָ����
		 */
		for(int i = 0 ; i<b.length;i++)
			System.out.println("�ַ���"+i+" : "+b[i]);
		
	}

	public void demo7_String() {			//�ַ����滻
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 6 : �ַ����滻");
		String a = "This is the test6,not the test5.";
		System.out.println("ԭ�ַ��� : "+a);
		/*
		 * ����a.replace("i","u");��,a����ԭ�ַ���
		 * replace(Charsequence old,Charsequence new);
		 * CharsequenceҲ�ܶ����ַ���,��Charsequence��ֵ�ɶ���д,��Stringֻ��
		 */
		//ȫ��i�滻��u
		String b = a.replace("the", "��");
		System.out.println("replace()ȫ���滻 �� "+b);
		
		//ֻ�滻��һ��i
		System.out.println("ֻ�滻��һ�� �� "+a.replaceFirst("i", "u"));
		//ȫ���滻
		System.out.println("replaceAll �� "+a.replaceAll("\\s", "--"));
		
	}

	public void demo8_String() {			//�����ַ����Ĺ淶����ʾ��ʽ
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 7 : �����ַ����Ĺ淶����ʾ��ʽ");
		/*
		 * ������Ч�ؼ��ٶ������ɺͳ�ʼ��ʱ�����ģ����ϵͳ������Ч��
		 */
		//String a = "ABC";//��������滹û��"ABC"
		//String b = "ABC";//����������Ѿ���"ABC"��,����a
		//intern();���ַ����ؽ��в���
		String s1 = new String("abc");
		String s2 = s1.intern();//���� String s2 = new String("abc"); s1��s2�ĵ�ַ��ͬ
		System.out.println("s2 = "+s2+"   "+s1==s2);
		
	}

}
