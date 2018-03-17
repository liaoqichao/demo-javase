package demo.string;

import demo.DemoInterface;

public class StringBufferBuilder implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		/**
		 * 
		 * JDK 1.5 后出现StringBuilder
		 * StringBuilder 一个可变的字符序列,该类设计被用作StringBuffer的简易替换
		 * 
		 * StringBuffer 是线程安全的可变字符序列 而StringBuilder线程不安全
		 * 单线程用StringBuilder 不用判断同步锁
		 * 
		 * JDK升级的方面：
		 * 1.提高效率		相对于StringBuffer,StringBuilder提高效率
		 * 2.简化书写
		 * 3.提高安全性
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

	public void demo1_StringBuffer() {			//声明和与String的转换
		// TODO Auto-generated method stub
		//初始化内容为空的对象
		//StringBuffer sb = new StringBuffer();
		//初始化带内容的对象
		StringBuffer sb1 = new StringBuffer("abc");
		/*
		 * StringBuffer s = "abc"; //错误,赋值类型不匹配
		 * StringBuffer 没有继承关系 不能强转类型
		 */
		
		/*
		 * String 和 StringBuffer 之间的转换
		 */
		System.out.println("StringBuffer -> String : "+sb1.toString());//StringBuffer -> String
		String s = "abc";
		StringBuffer sb2 = new StringBuffer("String -> StringBuffer : "+s);//String -> StringBuffer
		System.out.println(sb2);
		
	}

	public void demo2_StringBuffer() {			//StringBuffer的常用方法,在末尾增加内容
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abc");
		System.out.println("原StringBuffer对象 ： "+sb);
		/*
		 * StringBuffer类中的方法偏重于对于字符串的变化
		 * public StringBuffer append(boolean b)
		 * 将内容追加到StringBuffer对象末尾
		 * 参数boolean b, char[] str, ,int,double,float,Object,StringBuffer等
		 */
		sb.append("def");	
		System.out.println("append方法在末尾追加内容 : "+sb);//abcdef
		
	}

	public void demo3_StringBuffer() {			//删除内容
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abcdef");
		System.out.println("原StringBuffer对象 ： "+sb);
		/*
		 * public StringBuffer deleteCharAt(int index)
		 * sb.deleteCharAt(3);后是直接改s的内容.不是返回新的对象
		 * 删除指定位置的字符
		 * public StrngBuffer delete(int start,int end)
		 * 和字符串一样包括start,不包括end ,因为只有start的话, end默认为StringBuffer.lengt()
		 */
		StringBuffer sb1 =sb.deleteCharAt(3);
		System.out.println("deleteCharAt方法删除一个字符 ： "+sb1);
		StringBuffer sb2 =sb.delete(2, 4);
		System.out.println("delete(int start,int end)方法删除一段字符 ： "+sb2);
		
	}

	public void demo4_StringBuffer() {			//插入
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abcdef");
		System.out.println("原StringBuffer对象 ： "+sb);
		/*
		 * public StringBuffer insert(int index,);
		 */
		System.out.println("insert(位置,内容)方法插入 : "+sb.insert(3, "123"));
		
	}

	public void demo5_StringBuffer() {			//内容反转
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abcdef");
		System.out.println("原StringBuffer对象 ： "+sb);
		/*
		 * public synchronized StringBuffer reverse();
		 * 将内容翻转
		 */
		sb.reverse();
		System.out.println("用reverse方法将内容反转 : "+sb);
		
	}

	public void demo6_StringBuffer() {			//修改索引对象的值
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abcdef");
		System.out.println("原StringBuffer对象 ： "+sb);
		/*
		 * public synchronized StringBuffer setCharAt(int index,char ch);
		 */
		sb.setCharAt(3, 'D');
		System.out.println("用setCharAt(int index,char ch)方法修改值 : "+sb);
		
	}

	public void demo1_String() {			//字符串声明
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 0 : 声明");
		
		String s0 = "abc";
		String s1 = "abc";
		String s2 = new String("abc");
		System.out.println(s0==s1);//true
		System.out.println(s1==s2);//false
		
		/*
		 * 五种创建方式
		 *
		 *	char[] ch = new char[]{'h','e','l','l','o'};
		 *	String a = new String();
		 *	String b = new String("abc");
		 *	String c = new String(ch);
		 *	String d = new String(ch,1,3);//从ch字符数组从第一个开始,3个字符创建
		 *	//String e =new String(StringBuffer buffer);
		 * 
		 */
		
	}

	public void demo2_String() {			//字符串获取
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 1 : 获取");
		
		String a ="abcdefghijklmnabcdabccd";
		System.out.println("原字符串 : "+a);	
		System.out.println("字符串的长度为"+a.length());//获取字符串长度
		char c = a.charAt(2);				//以char类型获得a字符串下标为2的字符
		System.out.println("用charAt(index)获取字符串下标为index字符,类型为char ： "+c);
		String a1 = a.substring(3, 7); 		//子字符串为原字符串下标为3,4,5,6(不包括endindex)组成
											//因为a.substring(3<开始位置>) == a.substring(3.a.length());
		System.out.println("用substring(beginIndex,endIndex)获取部分字符串 : "+a1);
		
		int index = a.indexOf("abc");		//根据字符获取在字符串中的位置,或者根据子字符串获取子字符串第一个字符在原字符串中的位置
		//int index = a.indexOf('a');或者把'a'换成ASCII码的97获取一个字符第一次出现的位置 
		System.out.println("用indexOf(String s)获取子字符串\"abc\"第一次出现在原字符串的第一个元素的下标为 "+index);
		System.out.println("用indexOf(String s,int fromIndex)获取子字符串\"abc\"从fromindex位置开始第一次出现在原字符串的第一个元素的下标为 "+a.indexOf("abc", index+"abc".length()));
		a.lastIndexOf("abc", 6);
		System.out.println("用indexOf(String s,int fromIndex)获取子字符串\"abc\"到fromindex位置位置最后一次出现在原字符串的第一个元素的下标为"+a.lastIndexOf("abc", 22));
		
	}

	public void demo3_String() {			//字符串判断
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 2 : 判断");
		
		String a ="abcdefghijklmnabcdABCcd";
		System.out.println("原字符串 : "+a);
		
		//a.equals(String) a.equalsIgnoreCase(String)
		String b ="abcdefghijklmnabcdabccd";
		//a.equalsIgnoreCase(b)忽略大小写
		if(a.equals(b)) System.out.println("字符串a和字符串b一样");
		else System.out.println("字符串a和字符串b不一样");
		
		//a.contains(String)
		if(a.contains("ijk")) System.out.println("字符串a包涵\"ijk\"");
		else System.out.println("字符串a不包涵\"ijk\"");
		
		//a.startsWith(String) a.endsWith(String)
		if(a.startsWith("abc")) System.out.println("字符串a以\"abc\"开头");
		else System.out.println("字符串a不是以\"abc\"开头");
		if(a.endsWith("abc")) System.out.println("字符串a以\"abc\"结尾");
		else System.out.println("字符串a不是以\"abc\"结尾");
		
	}

	public void demo4_String() {			//字符串比较
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 3 : 比较");
		
		String a ="xyz";
		System.out.println("原字符串 : "+a);
		
		/*
		 * 对象的比较用的是方法完成如equals(),compareTo()等,
		 * 基本数据类型的比较用>、<、=等符号完成
		 * a.compareTo(String b)
		 * a.compareToIgnoreCase(String b)//忽略大小写
		 * 按照ASCII码顺序比较大小
		 * 如果 a == b return 0;
		 * 如果 a > b 返回一个大于0的数
		 * 如果 a < b 返回一个小于0的数
		 */
		
		//"xy"比a短,且前面"xy".length()个字符都一样,返回a.length()-"xy".length()的值
		System.out.println(a.compareTo("xy"));
		//"xyza"比a长,且前面a.length()字符都一样,返回a.lengt()-"xyza".lengt()的值
		System.out.println(a.compareTo("xyza"));
		/*
		 * 两个字符串长度不同,且较短的字符串和另外一个字符串前面不完全相同,则一个一个字符比较,如果有不相同
		 * 立刻返回,不继续比较下去
		 */
		System.out.println(a.compareTo("xYza"));
		/*
		 * System.out.println(('x'-'x')+'y'-'Y'); 'x'和'x'一样,相减为0继续比较,
		 * 'y'比'Y'大32，返回32
		 */
		System.out.println(a.compareTo("ab"));
		//System.out.println(('x'-'a'));
		
	}

	public void demo5_String() {			//大小写转换
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 4 : 大小写转换");
		
		String a ="xYzAbC";
		System.out.println("原字符串 : "+a);
		/*
		 * a.toLowerCase(Locale locale);
		 * Locale locale 自己定义大小写的对应关系
		 */
		System.out.println("转换为小写 : "+a.toLowerCase());
		System.out.println("转换为大写 : "+a.toUpperCase());
		
	}
		
	public void demo6_String() {			//字符串分割和正则表达式
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 5 : 字符串分割");
		String a = "This is the test5.";
		System.out.println("原字符串 : "+a);
		//按照分割符来分割,存在字符数组
		String[] b = a.split(" ");		
		/*
		 *  "\\.","\\|"  *,+等都要转义"\\+"
		 *  a.split(" ",2);表示最多分割成2个字符串数组
		 *  输出字符串0 This  字符串1 is the test5.
		 *  a.split(regex,limit);第一个可以填正则表达式,第二个限制分割次数
		 */
		for(int i = 0 ; i<b.length;i++)
			System.out.println("字符串"+i+" : "+b[i]);
		
	}

	public void demo7_String() {			//字符串替换
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 6 : 字符串替换");
		String a = "This is the test6,not the test5.";
		System.out.println("原字符串 : "+a);
		/*
		 * 用了a.replace("i","u");后,a还是原字符串
		 * replace(Charsequence old,Charsequence new);
		 * Charsequence也能定义字符串,但Charsequence的值可读可写,而String只读
		 */
		//全部i替换成u
		String b = a.replace("the", "的");
		System.out.println("replace()全部替换 ： "+b);
		
		//只替换第一个i
		System.out.println("只替换第一个 ： "+a.replaceFirst("i", "u"));
		//全部替换
		System.out.println("replaceAll ： "+a.replaceAll("\\s", "--"));
		
	}

	public void demo8_String() {			//返回字符串的规范化表示形式
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Test 7 : 返回字符串的规范化表示形式");
		/*
		 * 可以有效地减少对象生成和初始化时的消耗，提高系统的运行效率
		 */
		//String a = "ABC";//对象池里面还没有"ABC"
		//String b = "ABC";//对象池里面已经有"ABC"了,就是a
		//intern();对字符串池进行操作
		String s1 = new String("abc");
		String s2 = s1.intern();//等于 String s2 = new String("abc"); s1和s2的地址不同
		System.out.println("s2 = "+s2+"   "+s1==s2);
		
	}

}
