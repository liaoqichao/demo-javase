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
		 * 正则表达式用来操作字符串
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
	public void demo1(){	//QQ号校验
		/*
		 * 定义一个功能对QQ号进行校验
		 * 需求:
		 * 1.长度5~15位
		 * 2.只能是数字
		 * 3.不能0开头
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
	public void demo2(){	//正则表达式的常见规则
		
		/*
		 *  1.通配符  .
		 *  	t.n  匹配 ten tan t#n等
		 *  2.[] 表示范围    
		 *  	t[aeiou]n 匹配 tan ten tin ton tun 但不匹配toon,中括号里面只表示单个字符
		 *  3.|  或,用小括号表示范围,里面可以表示多个字符
		 *  	t(a|e|i|o|oo)n 匹配tan ten tin ton toon
		 *  4.表示匹配次数的符号
		 *  *		0次或多次
		 *  +		一次或多次
		 *  ?		0次或1次
		 *  {n}		恰好n次
		 *  {n,m}	从n次到m次
		 *  [0-9]{3}\-[0-9]{2}\-[A-Z]{4} 	表示xxx-xx-xxxx
		 *  [0-9]{3}\-?[0-9]{2}\-?[A-Z]{4}	'-'出现0次或者1次都可以
		 *  [^x][a-z]						匹配第一个字符不是x第二个是a到z的字符的字符串
		 *  5.常用符号
		 *  \d		[0-9]
		 *  \D		[^0-9]
		 *  \w		[a-zA-Z0-9]
		 *  \W		[^A-Z0-9]
		 *  \s		[\t\n\r\f]	\t制表符	\n换行符	\r回车	\f换页符	\b单词边界
		 *  \S		[^\t\n\r\f]
		 *  \b		单词边界  private int	private int中的空格就是单词边界
		 *  \z		输入的结尾  
		 */
		String s = "abbbbbcd";
		String regex1 = "ab?cd";
		String regex2 = "ab+cd";//s != regex2 因为2个都是字符串,regex2还不是正则表达式
		String regex3 = "ab{4,7}cd";
		System.out.println(s.matches(regex1));
		System.out.println(s.matches(regex2));//这里的regex2是正则表达式,也是字符串
		System.out.println(s.matches(regex3));
		
	}
	public void demo3(){	//字符串匹配
		
		/*
		 * 匹配手机号码是否正确
		 */
		String regex = "1[358]\\d{9}";		
		//"\d"是字符串的转义,他还是字符串,还不是正则表达式,所以要用"\\d"防止字符串转义,然后传参的时候才是正则表达式,才转义成\d代表0-9的数字
		String phoneNum1 = "13579246801";
		String phoneNum2 = "12345678901";
		System.out.println(phoneNum1.matches(regex));
		System.out.println(phoneNum2.matches(regex));
		
	}
	public void demo4(){	//字符串切割
		
		/*
		 * ((A)(B(C)))
		 * 第零组：整个表达式
		 * 第一组:((A)(B(C)))
		 * 第二组:\A
		 * 第三组(B(C))
		 * 第四组(C) 
		 */
		String str = "zhangsan@@@miao###miaolegemifffffluraraab";
		//任意字符出现超过2次则切割
		//正则表达式分组,这里的\\1是(.)的组标号  没有括号默认第0组
		String[] names = str.split("(.)\\1+");//注意 "."是通配符,如果要按照"."分割要 "\\."
		for(String name : names){
			System.out.println(name);
		}
		
		
//		String s = "12#34##56###";
//		String regex ="(#)\\1+";		按#号的第一组来切割
//		第0组,整个字符串就是(#)+
//		第1组,(#(#))+		2个#以上
//		第二组,(#(#(#)))+	3个#以上
//		String[] ss = s.split(regex);
//		for(String str : ss){
//			System.out.println(str);
//		}
		
	}
	public void demo5(){	//字符串替换
		/*
		 * String的 raplaceAll(String regex,String replacement)
		 */
		//把多个a变成1个a,多个b变成1个b
		String s = "aaabbcdeeeefghijjjklmmn";
		String str = s.replaceAll("(.)\\1+", "$1");
		//$符号：获取前面的正则表达式   1表示组号
		System.out.println(str);
		
		/*
		 * 15800001111 -> 158****1111
		 */
		String tel = "13123001234";
		String cover = tel.replaceAll("(\\d{3})\\d{4}(\\d{3})", "$1****$2");
		System.out.println(cover);
	}
	public void demo6(){	//字符串获取
		//正则表达式封装成 java.util.regex包的Pattern类 (没有构造函数)
		
//		//将正则规则进行对象封装
//		Pattern p = Pattern.compile("a*b");
//		//通过matcher方法和字符串关联,获取要对字符串操作的匹配其对象Mather
//		Matcher m = p.matcher("aaaab");
//		//通过Mather匹配器对象的方法进行字符串的操作
//		boolean b = m.matches();//true
		
		//获取三个字符组成的单词
		String str = "nv gan xiao tang tang zhu lai le ";
		//定义模式
		Pattern p = Pattern.compile("\\b[a-z]{3}\\b");//没有单词边界 tang 会取tan
		//获取匹配器对象
		Matcher m = p.matcher(str);
		/*
		 * matches		输入序列与该模式匹配
		 * lookingAt	输入序列从头开始于该模式匹配
		 * find			扫描输入序列以查找与该模式匹配的下一子序列
		 * 
		 * group		返回由以前操作匹配的子序列,在用这个方法之前要使用过find()方法
		 */
		while(m.find()){
			System.out.println(m.group());
			System.out.println(m.start()+" : "+m.end());//包括start不包括end 相当于字符串的IndexOf
		}
		
	}
	public void demo7(){	//练习：治口吃
		/*
		 * 练习1：治口吃：我我我魔法师  ->我魔法师
		 */
		String str = "我我我我我我...喵喵喵喵喵喵喵喵。。喵喵喵喵..乐乐乐乐个咪咪...咪咪咪咪咪咪咪。";
		//1. 去掉.和。
		str = str.replaceAll("[.。]", "");
		System.out.println(str);
		//2.去掉叠词
		str = str.replaceAll("(.)\\1+", "$1");	//没有分组不能用$
		System.out.println(str);
		
	}
	public void demo8(){	//练习：ip排序
		/*
		 * 对IP地址排序
		 * ip : 192.167.1.100   3.3.3.3 1.0.0.1 255.255.255.255 108.155.12.56
		 */
		
		//1.为了IP可以按照字符串顺序比较,只要让IP每一段的位数相同，所以补0。每一段补2个0
		String ip = "192.167.1.100   3.3.3.3 1.0.0.1 255.255.255.255 108.155.12.56";
		ip = ip.replaceAll("(\\d+)", "00$1");
		
		//2.每一段保留3位
		ip = ip.replaceAll("0*(\\d{3})", "$1");

		//3.切割IP地址
		String[] ips = ip.split("\\s+");
		
		//4.放进树排序
		TreeSet<String> ts = new TreeSet<String>();
		for(String s : ips){
			ts.add(s);
		}
		//5.去掉0
		for(String s : ts){
			System.out.println(s.replaceAll("0*(\\d+)", "$1"));			
		}
	}
	public void demo9(){	//练习：邮箱地址校验
		/*
		 * 对邮件地址校验
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
	public void demo10() throws IOException{	//练习：网页爬虫
		/*
		 * 网页爬虫:一个程序用于互联网中获取符合指定规则的数据
		 * 例子：大量发垃圾邮件垃圾广告
		 * 爬取邮箱地址。
		 */
		/*从本地文件搜索网址
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
		
		//1.读取源文件
		BufferedReader bf = new BufferedReader(new FileReader("E:\\Eclipse\\IO\\regex\\demo10.txt"));
		List<String> list = new ArrayList<String>();
		//2.对读取的数据进行规则的匹配,从中获取符合规则的数据
		String mail_regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]{1,4}){1,3}";
		Pattern p = Pattern.compile(mail_regex);
		String line = null;
		while((line = bf.readLine())!=null){
			
			Matcher m = p.matcher(line);
			while(m.find()){
				String s = m.group();
				//3.将符合规则的数据存储到集合中
				list.add(s);
			}
			
		}
		bf.close();
		return list;
		
	}
	
	public List<String> getMailByWeb() throws IOException{
		
		//1.启动tomcat
		URL url = new URL("http://127.0.0.1:8080/myWeb/myWeb.html");
		BufferedReader buf = new BufferedReader(new InputStreamReader(url.openStream()));
		List<String> list = new ArrayList<String>();
		//2.对读取的数据进行规则的匹配,从中获取符合规则的数据
		String mail_regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]{1,4}){1,3}";
		Pattern p = Pattern.compile(mail_regex);
		String line = null;
		while((line = buf.readLine())!=null){
			
			Matcher m = p.matcher(line);
			while(m.find()){
				String s = m.group();
				//3.将符合规则的数据存储到集合中
				list.add(s);
			}
			
		}
		buf.close();
		return list;
		
	}

}
