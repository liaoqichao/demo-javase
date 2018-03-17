package demo.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import demo.DemoInterface;

public class RegexDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * ������ʽ���������ַ���
		 */
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();
		//demo7();
		//demo8();
		//demo9();
		//demo10();
	}
	public void demo1(){	//QQ��У��
		/*
		 * ����һ�����ܶ�QQ�Ž���У��
		 * ����:
		 * 1.����5~15λ
		 * 2.ֻ��������
		 * 3.����0��ͷ
		 */
		String qq = "421054153";
		System.out.println(checkQQ(qq));
		qq = "1234567890123466";
		System.out.println(checkQQ(qq));
	}
	public boolean checkQQ(String qq){
		
		if(qq.matches("[1-9][0-9]{4,14}"))
			return true;
		return false;

	}
	public void demo2(){	//������ʽ�ĳ�������
		
		/*
		 *  1.ͨ���  .
		 *  	t.n  ƥ�� ten tan t#n��
		 *  2.[] ��ʾ��Χ    
		 *  	t[aeiou]n ƥ�� tan ten tin ton tun ����ƥ��toon,����������ֻ��ʾ�����ַ�
		 *  3.|  ��,��С���ű�ʾ��Χ,������Ա�ʾ����ַ�
		 *  	t(a|e|i|o|oo)n ƥ��tan ten tin ton toon
		 *  4.��ʾƥ������ķ���
		 *  *		0�λ���
		 *  +		һ�λ���
		 *  ?		0�λ�1��
		 *  {n}		ǡ��n��
		 *  {n,m}	��n�ε�m��
		 *  [0-9]{3}\-[0-9]{2}\-[A-Z]{4} 	��ʾxxx-xx-xxxx
		 *  [0-9]{3}\-?[0-9]{2}\-?[A-Z]{4}	'-'����0�λ���1�ζ�����
		 *  [^x][a-z]						ƥ���һ���ַ�����x�ڶ�����a��z���ַ����ַ���
		 *  5.���÷���
		 *  \d		[0-9]
		 *  \D		[^0-9]
		 *  \w		[a-zA-Z0-9]
		 *  \W		[^A-Z0-9]
		 *  \s		[\t\n\r\f]	\t�Ʊ��	\n���з�	\r�س�	\f��ҳ��	\b���ʱ߽�
		 *  \S		[^\t\n\r\f]
		 *  \b		���ʱ߽�  private int	private int�еĿո���ǵ��ʱ߽�
		 *  \z		����Ľ�β  
		 */
		String s = "abbbbbcd";
		String regex1 = "ab?cd";
		String regex2 = "ab+cd";//s != regex2 ��Ϊ2�������ַ���,regex2������������ʽ
		String regex3 = "ab{4,7}cd";
		System.out.println(s.matches(regex1));
		System.out.println(s.matches(regex2));//�����regex2��������ʽ,Ҳ���ַ���
		System.out.println(s.matches(regex3));
		
	}
	public void demo3(){	//�ַ���ƥ��
		
		/*
		 * ƥ���ֻ������Ƿ���ȷ
		 */
		String regex = "1[358]\\d{9}";		
		//"\d"���ַ�����ת��,�������ַ���,������������ʽ,����Ҫ��"\\d"��ֹ�ַ���ת��,Ȼ�󴫲ε�ʱ�����������ʽ,��ת���\d����0-9������
		String phoneNum1 = "13579246801";
		String phoneNum2 = "12345678901";
		System.out.println(phoneNum1.matches(regex));
		System.out.println(phoneNum2.matches(regex));
		
	}
	public void demo4(){	//�ַ����и�
		
		/*
		 * ((A)(B(C)))
		 * �����飺�������ʽ
		 * ��һ��:((A)(B(C)))
		 * �ڶ���:\A
		 * ������(B(C))
		 * ������(C) 
		 */
		String str = "zhangsan@@@miao###miaolegemifffffluraraab";
		//�����ַ����ֳ���2�����и�
		//������ʽ����,�����\\1��(.)������  û������Ĭ�ϵ�0��
		String[] names = str.split("(.)\\1+");//ע�� "."��ͨ���,���Ҫ����"."�ָ�Ҫ "\\."
		for(String name : names){
			System.out.println(name);
		}
		
		
//		String s = "12#34##56###";
//		String regex ="(#)\\1+";		��#�ŵĵ�һ�����и�
//		��0��,�����ַ�������(#)+
//		��1��,(#(#))+		2��#����
//		�ڶ���,(#(#(#)))+	3��#����
//		String[] ss = s.split(regex);
//		for(String str : ss){
//			System.out.println(str);
//		}
		
	}
	public void demo5(){	//�ַ����滻
		/*
		 * String�� raplaceAll(String regex,String replacement)
		 */
		//�Ѷ��a���1��a,���b���1��b
		String s = "aaabbcdeeeefghijjjklmmn";
		String str = s.replaceAll("(.)\\1+", "$1");
		//$���ţ���ȡǰ���������ʽ   1��ʾ���
		System.out.println(str);
		
		/*
		 * 15800001111 -> 158****1111
		 */
		String tel = "13123001234";
		String cover = tel.replaceAll("(\\d{3})\\d{4}(\\d{3})", "$1****$2");
		System.out.println(cover);
	}
	public void demo6(){	//�ַ�����ȡ
		//������ʽ��װ�� java.util.regex����Pattern�� (û�й��캯��)
		
//		//�����������ж����װ
//		Pattern p = Pattern.compile("a*b");
//		//ͨ��matcher�������ַ�������,��ȡҪ���ַ���������ƥ�������Mather
//		Matcher m = p.matcher("aaaab");
//		//ͨ��Matherƥ��������ķ��������ַ����Ĳ���
//		boolean b = m.matches();//true
		
		//��ȡ�����ַ���ɵĵ���
		String str = "nv gan xiao tang tang zhu lai le ";
		//����ģʽ
		Pattern p = Pattern.compile("\\b[a-z]{3}\\b");//û�е��ʱ߽� tang ��ȡtan
		//��ȡƥ��������
		Matcher m = p.matcher(str);
		/*
		 * matches		�����������ģʽƥ��
		 * lookingAt	�������д�ͷ��ʼ�ڸ�ģʽƥ��
		 * find			ɨ�����������Բ������ģʽƥ�����һ������
		 * 
		 * group		��������ǰ����ƥ���������,�����������֮ǰҪʹ�ù�find()����
		 */
		while(m.find()){
			System.out.println(m.group());
			System.out.println(m.start()+" : "+m.end());//����start������end �൱���ַ�����IndexOf
		}
		
	}
	public void demo7(){	//��ϰ���οڳ�
		/*
		 * ��ϰ1���οڳԣ�������ħ��ʦ  ->��ħ��ʦ
		 */
		String str = "������������...����������������������������..�������ָ�����...�������������䡣";
		//1. ȥ��.�͡�
		str = str.replaceAll("[.��]", "");
		System.out.println(str);
		//2.ȥ������
		str = str.replaceAll("(.)\\1+", "$1");	//û�з��鲻����$
		System.out.println(str);
		
	}
	public void demo8(){	//��ϰ��ip����
		/*
		 * ��IP��ַ����
		 * ip : 192.167.1.100   3.3.3.3 1.0.0.1 255.255.255.255 108.155.12.56
		 */
		
		//1.Ϊ��IP���԰����ַ���˳��Ƚ�,ֻҪ��IPÿһ�ε�λ����ͬ�����Բ�0��ÿһ�β�2��0
		String ip = "192.167.1.100   3.3.3.3 1.0.0.1 255.255.255.255 108.155.12.56";
		ip = ip.replaceAll("(\\d+)", "00$1");
		
		//2.ÿһ�α���3λ
		ip = ip.replaceAll("0*(\\d{3})", "$1");

		//3.�и�IP��ַ
		String[] ips = ip.split("\\s+");
		
		//4.�Ž�������
		TreeSet<String> ts = new TreeSet<String>();
		for(String s : ips){
			ts.add(s);
		}
		//5.ȥ��0
		for(String s : ts){
			System.out.println(s.replaceAll("0*(\\d+)", "$1"));			
		}
	}
	public void demo9(){	//��ϰ�������ַУ��
		/*
		 * ���ʼ���ַУ��
		 */
		String mail = "abcde@sina.com.cn";
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]{1,4}){1,3}";
		System.out.println(mail.matches(regex));
		/*
		 * public boolean check(String mail){
		 * 	String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]{1,4}){1,3}" ;
		 * 	return mail.matches(regex);
		 * }
		 */
		
	}
	public void demo10() throws IOException{	//��ϰ����ҳ����
		/*
		 * ��ҳ����:һ���������ڻ������л�ȡ����ָ�����������
		 * ���ӣ������������ʼ��������
		 * ��ȡ�����ַ��
		 */
		/*�ӱ����ļ�������ַ
		List<String> list = getMail();
		for(Iterator<String> it = list.iterator() ; it.hasNext() ;){
			System.out.println(it.next());
		}
		*/
		List<String> list = getMailByWeb();
		for(Iterator<String> it = list.iterator() ; it.hasNext() ;){
			System.out.println(it.next());
		}
		
	}
	public List<String> getMail() throws IOException{
		
		//1.��ȡԴ�ļ�
		BufferedReader bf = new BufferedReader(new FileReader("E:\\Eclipse\\IO\\regex\\demo10.txt"));
		List<String> list = new ArrayList<String>();
		//2.�Զ�ȡ�����ݽ��й����ƥ��,���л�ȡ���Ϲ��������
		String mail_regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]{1,4}){1,3}";
		Pattern p = Pattern.compile(mail_regex);
		String line = null;
		while((line = bf.readLine())!=null){
			
			Matcher m = p.matcher(line);
			while(m.find()){
				String s = m.group();
				//3.�����Ϲ�������ݴ洢��������
				list.add(s);
			}
			
		}
		bf.close();
		return list;
		
	}
	
	public List<String> getMailByWeb() throws IOException{
		
		//1.����tomcat
		URL url = new URL("http://127.0.0.1:8080/myWeb/myWeb.html");
		BufferedReader buf = new BufferedReader(new InputStreamReader(url.openStream()));
		List<String> list = new ArrayList<String>();
		//2.�Զ�ȡ�����ݽ��й����ƥ��,���л�ȡ���Ϲ��������
		String mail_regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]{1,4}){1,3}";
		Pattern p = Pattern.compile(mail_regex);
		String line = null;
		while((line = buf.readLine())!=null){
			
			Matcher m = p.matcher(line);
			while(m.find()){
				String s = m.group();
				//3.�����Ϲ�������ݴ洢��������
				list.add(s);
			}
			
		}
		buf.close();
		return list;
		
	}

}
