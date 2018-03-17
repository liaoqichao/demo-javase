package demo.api;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;

import demo.DemoInterface;

public class APIDemo implements DemoInterface {

	ExampleforObject e = new ExampleforObject();
	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//demo1_Calendar();
		//demo2_Calendar();
		//demo3_Calendar();
		//demo1_Date();			//Date->String
		//demo2_Date();
		//demo3_Date();			//String->Date	
		//demo4_Date();			//求两个日期间隔多少天
		//demo1_Math();
		//demo1_Object();		//Object类的方法往往需要覆盖
		//demo2_Object();
		//demo3_Object();
		//demo4_Object();
		//demo1_Runtime();		//单例模式,没有构造方法,除了一个其他都不是是静态方法。只有一个静态方法返回Runtime对象
		//demo2_Runtime();
		//demo1_System();		//System的方法都是静态的
		//demo2_System();
		//demo3_System();
		//demo4_System();
		//demo5_System();		//重点
		//demo6_System();

	}

	public void demo1_System() {			//System.gc() 垃圾回收器
		// TODO Auto-generated method stub
		/*
		 * 内存泄露：申请内存空间但是没有控制释放,你不用了别人也用不了那块内存空间
		 * 程序员通过 Object obj = new Object(); new关键字的创建对象, 通过 obj = null;  null来回收对象
		 * 不建议使用。程序会自动调用System.gc()方法用来回收不可达对象的空间,不需要程序员调用
		 * 不可达不可用：变量作用域结束时,gc会帮我们回收,而C++不会
		 * 不可用可达：这种情况可能会存在内存泄露
		 * 
		 * 不可用可达,就是我们自己没有将其对象,
		 * 	   举个例子:
		 * 	在这个例子中，我们循环申请Object对象，并将所申请的对象放入一个Vector中，如果我们仅仅释放引用本身，那么Vector仍然引用该对象，所以这个对象对GC来说是不可回收的。因此，如果对象加入到Vector后，还必须从Vector中删除，最简单的方法就是将Vector对象设置为null
		 * 	Vector v=new Vector(10);
		 * 	for (int i=1;i<100; i++)
		 * 	{
		 * 		Object o=new Object();
		 * 		v.add(o);
		 * 		o=null;	
		 * 	} 
		 * 	
		 * 	//此时，所有的Object对象都没有被释放，因为变量v引用这些对象。 
		 * 	这时候这些Object就是不可用可达的对象,GC不会帮我们清理的, 这就存在了内存泄露了
		 * 可用可达：正常使用	
		 */
		//System.gc();
		
	}

	public void demo2_System() {			//System.currentTimeMillis() ,获取系统当前时间,获取程序运行时间
		// TODO Auto-generated method stub
		//System.currentTimeMillis() 返回当前时间与1970年1月1日0点,时间差,单位为毫秒
		//TimeZone.setDefault(TimeZone.getTimeZone("China/Beijing")); 如果加了这句,时间不正确(早了8小时)
		Date nowTime = new Date(System.currentTimeMillis());
		/*
		 * yyyy-MM-dd HH:mm:ss:SSS
		 *  年         月     日     时     分     秒     毫秒
		 */
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		System.out.println(retStrFormatNowDate);
		
		//-------------------程序运行时间-----------------
		long start = System.currentTimeMillis();
		long a = 0;
		for(long i = 0 ;i < 10000000; i++){
			
			a =  a + i;
			
		}
		System.out.println(a);
		long end = System.currentTimeMillis();
		TimeZone.setDefault(TimeZone.getTimeZone("China/Beijing"));	//设置时区为  北京时间(东八区)，不然后面的HH会自动加上8小时 
		SimpleDateFormat sdFormatter1 = new SimpleDateFormat("HH:mm:ss:SSS");
		System.out.println("运行时间 : "+sdFormatter1.format(end-start));

	}

	public void demo3_System() {			//arraycopy()复制数组
		// TODO Auto-generated method stub
		int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,0};
		
		final int copyLength = 5;
		
		int[] arr2 = new int[5+copyLength];
		
		
		//注意长度,小心数组越界，数组声明的时候就固定长度,可以用转换为数组列表
		System.arraycopy(arr1, 3, arr2, 1, copyLength);
		
		for(int i = 0 ;i < arr2.length; i++)
			System.out.print(arr2[i]+"  ");
		System.out.println();
		
		/*
		 * System.arraycopy(src,    srcPos,     dest,   destPos,      length);
		 * 					源数组    要复制的起始位置	目的数组       要复制到的起始位置           复制长度
		 * 两个数组类型要相同或者可以转换
		 */
		
		
	}

	public void demo4_System() {			//exit();终止当前正在运行的JAVA虚拟机
		// TODO Auto-generated method stub

		/*
		 * System.exit(0);表示正常退出,非0表示强制退出
		 */
		int[] array = new int[5];
		int i = 0;
		while(true){
			try{
				array[i] = i;
				if(i==10)
					break;
				i++;
			}
			catch(Exception e){
				System.out.println("出现异常,停止运行");
				System.exit(1);				//没有这句不能跳出循环
				
			}
			finally{
				for(int k = 0 ; k < 5 ; k++)
					System.out.print(array[k]+"  ");
				System.out.println();
			}
		}
		//这部分代码不可达
		
	}

	
	public void demo5_System() {			
		/* String getProperty(String key)确定当前系统属性,获得指定键指示的系统属性
		 * String getenr(String name)获取系统环境变量, 返回当前系统环境值
		 * void setProperties(Properties props),将系统属性设置为Properties参数
		 * props对象为新的系统属性
		 * String setProperty(String key,String value)设置指定键指示的属性
		 * 
		 * 	Windows下的换行\r\n		Unix下的换行\n  			但是JAVA的跨平台性，在任何系统都可以换行,虚拟机启动的时候都去拿操作系统的信息
		 *  "hello \r\n world!"		"hello \n world!" 		"hello"+System.getProperty("line.separator")+"world!"
		 *  其中getProperty的键line.separator 在遍历系统配置信息有出现
		 */
		//遍历系统配置信息,存储配置
		Properties prop = System.getProperties();			//class Properties extends Hashtable<Object,Object>
		Set<String> nameSet = prop.stringPropertyNames();	//把键放在集合
		for(String name : nameSet){
			String value = prop.getProperty(name);			//根据键(name)映射到值
			System.out.println(name +" :: "+value);
		}
		/*
		 * //ctrl + shift + x 大写  ctrl + shift + y 小写
		 * private static final String LINE_SEPARATOR = System.getProperty("line.separator");
		 * sop("hello"+LINE_SEPARATOR+"world!");	//任何平台都可以
		 * 
		 * System.setProperty("mykey","myvalue"); //给系统设置属性信息,信息是全局的,其他程序都可以使用
		 */
		/*
		System.out.println("java运行时环境版本:"+System.getProperty("java.version"));
		System.out.println("java运行时环境供应商："+System.getProperty("java.vender"));
		System.out.println("java供应商的URL："+System.getProperty("java.vender.url"));
		System.out.println("java安装目录:"+System.getProperty("java.home"));
		System.out.println("java虚拟机规范版本:"+System.getProperty("java.vm.specification.version"));
		System.out.println("java类格式版本号:"+System.getProperty("java.class.version"));
		System.out.println("java类路径:"+System.getProperty("java.class.path"));
		System.out.println("操作系统的名称:"+System.getProperty("os.name"));
		System.out.println("操作系统的架构:"+System.getProperty("os.arch"));
		System.out.println("操作系统的版本:"+System.getProperty("os.version"));
		System.out.println("用户的主目录:"+System.getProperty("user.home"));
		System.out.println("用户的当前工作目录:"+System.getProperty("user.dir"));
		System.out.println();
		System.out.println("自定义变量getProperty CONF_LOCATION:"+System.getProperty("conf.location"));
		System.out.println("自定义变量getenv CONF_LOCATION:"+System.getenv("conf.location"));
		*/
		
		
	}

	public void demo6_System() {			//in,out,err,输入输出重定向
		// TODO Auto-generated method stub
		/*
		 * System.out.println();能重定向到别的输出流，例如把输出显示到文件里面,而不是控制台
		 * System.err.println();只能输出到控制台
		 * setIn,setOut重定向(默认是键盘输入，控制台输出)
		 * 
		 * System.out 是希望用户可以看见的信息。错误信息是用黑颜色显示的
		 * System.err  是不希望用户可以看见的信息。则在IDE中将以红色的文字显示错误的信息。
		 * System.in  对就键盘输入
		 * 以上的三个常量的输入 、输出 都可以重定向，但是一般只建修改setOut 的重定向。
		 * Systemin 读取的时候会出现中文乱码问题，则可以通过BufferedReader 完成读取功能。
		 */
		//System.out.println("out");
		//System.err.println("err");	//控制台输出的字是红色的
		/*
		 * 每次输出结果不一样
		 * 1.outerr
		 * 2.out
		 * 	 err
		 * 3.err
		 *   out
		 */
		
		//System.setIn,System.setOut重定向
		//System.out 默认显示在控制台
		try {
			PrintStream out = System.out;				//这句话一定要放在第一次System.out.println()之前,
														//不然无法还原到控制台
			PrintStream ps = new PrintStream("E:\\Eclipse\\IO\\SystemSetOut.txt");
			System.setOut(ps);
			System.out.println("PrinStream ps =new PrintStream(\"路径\")");
			System.out.println("System.setOut(ps);  然后直接用System.out.println()就不会在控制台输出");
			System.out.println("lalal");
			//每次程序运行完后,在运行程序显示则会覆盖掉之前显示的内容
			//将显示定位到控制台
			System.setOut(out);
			System.out.println("aaa");		//为什么还是显示到ps 不是显示到控制台?
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		//System.in 默认键盘输入
		try {
			InputStream old = System.in;
			InputStream in = new FileInputStream("E:\\Eclipse\\IO\\SystemSetIn.txt");
			System.setIn(in);
	
			byte[] b = new byte[1024];
			int len = 0;
			try {
				len = in.read(b);					//每次读取一个二进制数到b数组中，inread读完=-1.
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			 }
			System.out.println("输入内容为： ");
			System.out.println(new String(b,0,len));//String(byte[],int offset,int length)
			 										/*
			 										 * 把字节集解码到byte子数组  
			 										 * offset 第一个位置, length  要解码byte数组的长度 
			 										 */
			System.setIn(old);
			System.out.println("请在控制台输入");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			System.out.println(s);
			scanner.close();
		}catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
	}
	
	public void demo7_System(){			//setSecurityManager()设置系统安全性
		/*
		 * 如果当前程序建立安全管理器,则返回安全管理器,否则返回null
		 */
		SecurityManager s = new SecurityManager();//各种check方法,要写类继承SecurityManager重写check方法?
		System.setSecurityManager(s);
		System.out.println(System.getSecurityManager());//java.lang.SecurityManager@784be29
		
	}

	public void demo1_Runtime() {		//内存管理 gc(); System继承了Runtime 等于System.gc()
		// TODO Auto-generated method stub
		//单例模式,没有构造方法,除了一个其他都不是是静态方法。只有一个静态方法返回Runtime对象
	}

	public void demo2_Runtime() {		//执行其他程序和Process类
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		Process p = null;		//Process抽象类,没有子类
		try {
			p = r.exec("D:\\QQ\\QQ\\Bin\\QQScLauncher.exe");//打开QQ,绝对路径
			//r.exec("Notepad.ext"); JAVA设置环境变量时 Path里面有记事本程序,所以就不用目录就可以执行了
			File dir = new File("C:");
			/*
			 * r.exec("Notepad.exe E:\\Eclipse\\workspace\\Demo\\src\\demo\\api\\APIDemo.JAVA");
			 * 用Notepad程序解析 APIDemo.java文件  如果不匹配则解析不了
			 */
			Process p1 = r.exec("Notepad.exe E:\\Eclipse\\workspace\\Demo\\src\\demo\\api\\APIDemo.JAVA", null, dir);
			Thread.sleep(5000);
			p1.destroy();					//杀死所有子进程
		} catch (Exception e/*InterruptedException e 和IOException合在一起*/) {
			// TODO 自动生成的 catch 块
			System.out.println("Error executing D:\\QQ\\QQ\\Bin\\QQScLauncher.exe");
			e.printStackTrace();
		}
		System.out.println("获得子进程的输入流:"+p.getInputStream());//java.io.BufferedInputStream@3c10b841
		System.out.println("获得子进程的输出流:"+p.getOutputStream());//java.io.BufferedOutputStream@6db0d235
		System.out.println("获得子进程的错误流:"+p.getErrorStream());//java.io.FileInputStream@73b8cdd5	
		
	}

	public void demo1_Object() {				//equals
		// TODO Auto-generated method stub
		/*
		 * 除了equals,hashCode,toString,getClass,还有和线程相关的
		 * wait,notify,notifyAll
		 * clone 要实现Cloneable接口,重载clone方法
		 */
		System.out.println("s1.equals(s2) ?  "+e.s1.equals(e.s2));	//true
		System.out.println("s1.equals(s3) ?  "+e.s1.equals(e.s3));	//true
		System.out.println("s1.equals(s4) ?  "+e.s1.equals(e.s4));	//true
		System.out.println("s1.equals(s5) ?  "+e.s1.equals(e.s5));	//false
		
		System.out.println("a.equals(b) ? "+e.getA().equals(e.getB()));		//false
		
	}
	
	public void demo2_Object() {			//hashCode 返回对象的哈希码值,相当于地址
											//该方法返回的值一般是通过将该对象的内部地址转换成一个整数来实现的。
											//在JVM虚拟出来的内存地址。不是实际物理内存地址
		System.out.println("s1的哈希码值 ： "+e.s1.hashCode());
		System.out.println("s2的哈希码值 ： "+e.s2.hashCode());
		System.out.println("s3的哈希码值 ： "+e.s3.hashCode());
		System.out.println("s4的哈希码值 ： "+e.s4.hashCode());
		System.out.println("s5的哈希码值 ： "+e.s5.hashCode());
		System.out.println("a的哈希码值 ： "+e.getA().hashCode());
		System.out.println("b的哈希码值 ： "+e.getB().hashCode());
	}
	public void demo3_Object() {			//toString 返回对象的字符串形表示
		// TODO Auto-generated method stub
		System.out.println(e.getA().toString());//A@5cfe174		A是数据类型,@是分隔符 5cfe174 相当于地址16进制表示
		System.out.println(e.getB().toString());//A@12da89a7	
		
	}

	public void demo4_Object() {			//getClass 返回一个对象的运行时类
		// TODO Auto-generated method stub
		
		System.out.println(e.getClass());			//class Example
		System.out.println(e.s1.getClass());		//class java.lang.String
		System.out.println(e.getA().getClass());	//class A
		
		
	}

	public void demo1_Math() {
		// TODO Auto-generated method stub
		System.out.println(Math.abs(-20.233));	//求绝对值
		System.out.println(Math.ceil(10.1));	//上取整
		System.out.println(Math.floor(10.1));	//下取整
		System.out.println(Math.max(2, 3));		//返回较大值,min返回最小值
		System.out.println(Math.random());		//随机 0<= x <1 的数
		System.out.println(Math.rint(10.5));	//四舍五入, 返回double型 .5的时候会取偶数,如10.5 -> 10.0  ; 11.5->12.0
		System.out.println(Math.round(21.1));	//四舍五入,参数是float则返回int,参数是double则返回long
		System.out.println(Math.sqrt(25));		//开方，Math.cbrt();立方根
		System.out.println(Math.toDegrees(Math.PI));//弧度换角度
		System.out.println(Math.toRadians(30));	//角度换弧度
												//三角函数，对数函数等
		
	}

	public void demo1_Date() {				//获取当前时间,日期对象转化成字符串
		// TODO Auto-generated method stub
		/*
		 * 把毫秒封装成对象可以获取当前年月日等。  	
		 * Date date = new Date();	date.getDay()(方法已过时，用Calendar对象调用);获取后还可以进行运算
		 * 为什么Date d1 =new Date();
		 * Date d2 =new Date();
		 * t1.getTime() 总是等于 t2.getTime()	//因为是获取当前时间. 
		 *  Date date1 = new Date();		//把当前时间封装成对象
		 *  Date date2 = new Date();		//2个date的时间不一样
		 * 而2次 System.currentTimeMillis();结果不一样
		 * 
		 * java.util.Date 转为 java.sql.Date 是日期的时分秒会被去掉
		 * 
		 * 设置日期  Date date = new Date(毫秒);
		 * 		data.setTime(毫秒);
		 */
		Date date = new Date();				//调用System.currentTimeMillis();
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//查阅SimpleDateFormat,看y,M,m等各代表什么。yy用2为代表年：15年; yyyy用4为代表年:2015
		System.out.println("当前时间 ："+sdFormatter.format(date.getTime()));//2015-08-11 15:26:00
		System.out.println("当前时间 ："+sdFormatter.format(date));
		//不用格式直接date：Tue Aug 11 15:26:00 CST 2015
		
	}

	public void demo2_Date() {				////获取当前时间标准格式
		// TODO Auto-generated method stub
		Date date = new Date();				//获取当前时间
		//注意getDateInstance和getTimeInstance的区别 一个是只获取日期(2015年8月11日)一个是只获取时间(下午5点3分1秒11毫秒)
		//getDateTimeInstance(参数);	日期和时间一起显示
		
		/*
		 * 这里的DateFormat.SHORT,MEDIUM,LONG,FULL是调用本地的信息(控制面板\时钟、语言和区域\更改日期、时间或数字格式)可以更改
		 */
		DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println(shortDateFormat.format(date));//15-8-11, .getTimeInstance 下午2:10
		
		DateFormat mediumDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(mediumDateFormat.format(date));//2015-7-29
		
		DateFormat longDateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(longDateFormat.format(date));//2015年7月29日
		
		DateFormat fullDateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(fullDateFormat.format(date));//2015年7月29日 星期三,time:下午03时44分01秒 CST
		
	}
	
	public void demo3_Date(){				//日期格式字符串转化Date对象
		
		String strDate = "2015-08-11 15:52:30";
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//指定格式,要和strDate能对应
		try {
			Date date = sdFormat.parse(strDate);
			System.out.println(sdFormat.format(date));//2015-08-11 03:52:30
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void demo4_Date(){
		/*
		 *	getTime获取毫秒值
		 * 求2012年9月10日 到现在(2015年8月11日)中间有多少天
		 * 1.String->Date	2.Date->long Millis		3.相减	4.
		 */
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String oldDateStr = "2012-9-10";
		try {
			Date oldDate = sdFormat.parse(oldDateStr);
			Date nowDate = new Date();
			int day = DateDifferent.DATE_DIFFER_DAY(oldDate, nowDate);
			System.out.println("求2012年9月10日 到现在(2015年8月11日)中间有多少天?  "+day+" 天");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void demo1_Calendar() {			//获取当前时间
		// TODO Auto-generated method stub
		
		/*
		 * Calendar类 单例模式
		 * TimeZone.getTimeZone("GMT+8"); 或者 TimeZone.getTimeZone("China/Beijing");
		 * sop(c);都是键值对  
		 */
		Calendar cc = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		int year = cc.get(Calendar.YEAR);
		
		int month = cc.get(Calendar.MONTH)+1;		//月份是从0开始, 0月到11月 表示  1月到12月
		int day = cc.get(Calendar.DAY_OF_MONTH);	//这个月的第几天,DAY_OF_YEAR 这年的第几天
		
		//int hour_12 = cc.get(Calendar.HOUR);		//12小时制
		int hour_24 = cc.get(Calendar.HOUR_OF_DAY);	//24小时制
		int minute = cc.get(Calendar.MINUTE);
		int second = cc.get(Calendar.SECOND);
		
		/*
		 * getWeekDay(Calendar.DAY_OF_WEEK);
		 * 可以新建函数String getWeekDay(int i){
		 * 	String s = {"","星期一","星期二",..."星期日"}
		 * 	return s[i];
		 * }
		 */
		int weekday = cc.get(Calendar.DAY_OF_WEEK)-1;	//从星期天 = 0  ,星期六==6
		
		System.out.println(year+"-"+month+"-"+day+" "+hour_24+":"+minute+":"+second+"  星期"+weekday);
		
	}

	public void demo2_Calendar() {			//Date Calendar 的转换
		// TODO Auto-generated method stub
		Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		Date d = c1.getTime();
		c1.setTime(d);
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdFormatter.format(d));
		System.out.println(c1.get(Calendar.YEAR)+"-"+(c1.get(Calendar.MONTH)+1)+"-"+c1.get(Calendar.DAY_OF_MONTH)+" "+c1.get(Calendar.HOUR_OF_DAY)+":"+c1.get(Calendar.MINUTE)+":"+c1.get(Calendar.SECOND)+"  星期"+(c1.get(Calendar.DAY_OF_WEEK)-1));
		
	}
	
	public void demo3_Calendar(){			//在指定日期偏移
		
		Calendar c = Calendar.getInstance();
		c.set(2012, 8, 10);					//设置日期 2012年9月10日   月从0算
		c.add(Calendar.YEAR, 3);			//负数则向前偏移
		System.out.println(c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月"+c.get(Calendar.DAY_OF_MONTH)+"日");
		
	}

}
class A{
	 
	A(){}
}

class ExampleforObject{
	
	public int i = 123;
	
	public double j = 0.618;
	
	public String s1 = "ABC";
	
	public String s2 = s1.intern();
	
	public String s3 = "ABC";
	
	public String s4 = new String("ABC");
	
	public String s5 = new String("abc");
	
	public A getA(){
		A a =new A();
		return a;
	}
	
	public A getB(){
		A b = new A();
		return b;
	}
}


