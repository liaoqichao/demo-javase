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
		//demo4_Date();			//���������ڼ��������
		//demo1_Math();
		//demo1_Object();		//Object��ķ���������Ҫ����
		//demo2_Object();
		//demo3_Object();
		//demo4_Object();
		//demo1_Runtime();		//����ģʽ,û�й��췽��,����һ�������������Ǿ�̬������ֻ��һ����̬��������Runtime����
		//demo2_Runtime();
		//demo1_System();		//System�ķ������Ǿ�̬��
		//demo2_System();
		//demo3_System();
		//demo4_System();
		//demo5_System();		//�ص�
		//demo6_System();

	}

	public void demo1_System() {			//System.gc() ����������
		// TODO Auto-generated method stub
		/*
		 * �ڴ�й¶�������ڴ�ռ䵫��û�п����ͷ�,�㲻���˱���Ҳ�ò����ǿ��ڴ�ռ�
		 * ����Աͨ�� Object obj = new Object(); new�ؼ��ֵĴ�������, ͨ�� obj = null;  null�����ն���
		 * ������ʹ�á�������Զ�����System.gc()�����������ղ��ɴ����Ŀռ�,����Ҫ����Ա����
		 * ���ɴﲻ���ã��������������ʱ,gc������ǻ���,��C++����
		 * �����ÿɴ����������ܻ�����ڴ�й¶
		 * 
		 * �����ÿɴ�,���������Լ�û�н������,
		 * 	   �ٸ�����:
		 * 	����������У�����ѭ������Object���󣬲���������Ķ������һ��Vector�У�������ǽ����ͷ����ñ�����ôVector��Ȼ���øö���������������GC��˵�ǲ��ɻ��յġ���ˣ����������뵽Vector�󣬻������Vector��ɾ������򵥵ķ������ǽ�Vector��������Ϊnull
		 * 	Vector v=new Vector(10);
		 * 	for (int i=1;i<100; i++)
		 * 	{
		 * 		Object o=new Object();
		 * 		v.add(o);
		 * 		o=null;	
		 * 	} 
		 * 	
		 * 	//��ʱ�����е�Object����û�б��ͷţ���Ϊ����v������Щ���� 
		 * 	��ʱ����ЩObject���ǲ����ÿɴ�Ķ���,GC��������������, ��ʹ������ڴ�й¶��
		 * ���ÿɴ����ʹ��	
		 */
		//System.gc();
		
	}

	public void demo2_System() {			//System.currentTimeMillis() ,��ȡϵͳ��ǰʱ��,��ȡ��������ʱ��
		// TODO Auto-generated method stub
		//System.currentTimeMillis() ���ص�ǰʱ����1970��1��1��0��,ʱ���,��λΪ����
		//TimeZone.setDefault(TimeZone.getTimeZone("China/Beijing")); ����������,ʱ�䲻��ȷ(����8Сʱ)
		Date nowTime = new Date(System.currentTimeMillis());
		/*
		 * yyyy-MM-dd HH:mm:ss:SSS
		 *  ��         ��     ��     ʱ     ��     ��     ����
		 */
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		System.out.println(retStrFormatNowDate);
		
		//-------------------��������ʱ��-----------------
		long start = System.currentTimeMillis();
		long a = 0;
		for(long i = 0 ;i < 10000000; i++){
			
			a =  a + i;
			
		}
		System.out.println(a);
		long end = System.currentTimeMillis();
		TimeZone.setDefault(TimeZone.getTimeZone("China/Beijing"));	//����ʱ��Ϊ  ����ʱ��(������)����Ȼ�����HH���Զ�����8Сʱ 
		SimpleDateFormat sdFormatter1 = new SimpleDateFormat("HH:mm:ss:SSS");
		System.out.println("����ʱ�� : "+sdFormatter1.format(end-start));

	}

	public void demo3_System() {			//arraycopy()��������
		// TODO Auto-generated method stub
		int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,0};
		
		final int copyLength = 5;
		
		int[] arr2 = new int[5+copyLength];
		
		
		//ע�ⳤ��,С������Խ�磬����������ʱ��͹̶�����,������ת��Ϊ�����б�
		System.arraycopy(arr1, 3, arr2, 1, copyLength);
		
		for(int i = 0 ;i < arr2.length; i++)
			System.out.print(arr2[i]+"  ");
		System.out.println();
		
		/*
		 * System.arraycopy(src,    srcPos,     dest,   destPos,      length);
		 * 					Դ����    Ҫ���Ƶ���ʼλ��	Ŀ������       Ҫ���Ƶ�����ʼλ��           ���Ƴ���
		 * ������������Ҫ��ͬ���߿���ת��
		 */
		
		
	}

	public void demo4_System() {			//exit();��ֹ��ǰ�������е�JAVA�����
		// TODO Auto-generated method stub

		/*
		 * System.exit(0);��ʾ�����˳�,��0��ʾǿ���˳�
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
				System.out.println("�����쳣,ֹͣ����");
				System.exit(1);				//û����䲻������ѭ��
				
			}
			finally{
				for(int k = 0 ; k < 5 ; k++)
					System.out.print(array[k]+"  ");
				System.out.println();
			}
		}
		//�ⲿ�ִ��벻�ɴ�
		
	}

	
	public void demo5_System() {			
		/* String getProperty(String key)ȷ����ǰϵͳ����,���ָ����ָʾ��ϵͳ����
		 * String getenr(String name)��ȡϵͳ��������, ���ص�ǰϵͳ����ֵ
		 * void setProperties(Properties props),��ϵͳ��������ΪProperties����
		 * props����Ϊ�µ�ϵͳ����
		 * String setProperty(String key,String value)����ָ����ָʾ������
		 * 
		 * 	Windows�µĻ���\r\n		Unix�µĻ���\n  			����JAVA�Ŀ�ƽ̨�ԣ����κ�ϵͳ�����Ի���,�����������ʱ��ȥ�ò���ϵͳ����Ϣ
		 *  "hello \r\n world!"		"hello \n world!" 		"hello"+System.getProperty("line.separator")+"world!"
		 *  ����getProperty�ļ�line.separator �ڱ���ϵͳ������Ϣ�г���
		 */
		//����ϵͳ������Ϣ,�洢����
		Properties prop = System.getProperties();			//class Properties extends Hashtable<Object,Object>
		Set<String> nameSet = prop.stringPropertyNames();	//�Ѽ����ڼ���
		for(String name : nameSet){
			String value = prop.getProperty(name);			//���ݼ�(name)ӳ�䵽ֵ
			System.out.println(name +" :: "+value);
		}
		/*
		 * //ctrl + shift + x ��д  ctrl + shift + y Сд
		 * private static final String LINE_SEPARATOR = System.getProperty("line.separator");
		 * sop("hello"+LINE_SEPARATOR+"world!");	//�κ�ƽ̨������
		 * 
		 * System.setProperty("mykey","myvalue"); //��ϵͳ����������Ϣ,��Ϣ��ȫ�ֵ�,�������򶼿���ʹ��
		 */
		/*
		System.out.println("java����ʱ�����汾:"+System.getProperty("java.version"));
		System.out.println("java����ʱ������Ӧ�̣�"+System.getProperty("java.vender"));
		System.out.println("java��Ӧ�̵�URL��"+System.getProperty("java.vender.url"));
		System.out.println("java��װĿ¼:"+System.getProperty("java.home"));
		System.out.println("java������淶�汾:"+System.getProperty("java.vm.specification.version"));
		System.out.println("java���ʽ�汾��:"+System.getProperty("java.class.version"));
		System.out.println("java��·��:"+System.getProperty("java.class.path"));
		System.out.println("����ϵͳ������:"+System.getProperty("os.name"));
		System.out.println("����ϵͳ�ļܹ�:"+System.getProperty("os.arch"));
		System.out.println("����ϵͳ�İ汾:"+System.getProperty("os.version"));
		System.out.println("�û�����Ŀ¼:"+System.getProperty("user.home"));
		System.out.println("�û��ĵ�ǰ����Ŀ¼:"+System.getProperty("user.dir"));
		System.out.println();
		System.out.println("�Զ������getProperty CONF_LOCATION:"+System.getProperty("conf.location"));
		System.out.println("�Զ������getenv CONF_LOCATION:"+System.getenv("conf.location"));
		*/
		
		
	}

	public void demo6_System() {			//in,out,err,��������ض���
		// TODO Auto-generated method stub
		/*
		 * System.out.println();���ض��򵽱�������������������ʾ���ļ�����,�����ǿ���̨
		 * System.err.println();ֻ�����������̨
		 * setIn,setOut�ض���(Ĭ���Ǽ������룬����̨���)
		 * 
		 * System.out ��ϣ���û����Կ�������Ϣ��������Ϣ���ú���ɫ��ʾ��
		 * System.err  �ǲ�ϣ���û����Կ�������Ϣ������IDE�н��Ժ�ɫ��������ʾ�������Ϣ��
		 * System.in  �Ծͼ�������
		 * ���ϵ��������������� ����� �������ض��򣬵���һ��ֻ���޸�setOut ���ض���
		 * Systemin ��ȡ��ʱ�����������������⣬�����ͨ��BufferedReader ��ɶ�ȡ���ܡ�
		 */
		//System.out.println("out");
		//System.err.println("err");	//����̨��������Ǻ�ɫ��
		/*
		 * ÿ����������һ��
		 * 1.outerr
		 * 2.out
		 * 	 err
		 * 3.err
		 *   out
		 */
		
		//System.setIn,System.setOut�ض���
		//System.out Ĭ����ʾ�ڿ���̨
		try {
			PrintStream out = System.out;				//��仰һ��Ҫ���ڵ�һ��System.out.println()֮ǰ,
														//��Ȼ�޷���ԭ������̨
			PrintStream ps = new PrintStream("E:\\Eclipse\\IO\\SystemSetOut.txt");
			System.setOut(ps);
			System.out.println("PrinStream ps =new PrintStream(\"·��\")");
			System.out.println("System.setOut(ps);  Ȼ��ֱ����System.out.println()�Ͳ����ڿ���̨���");
			System.out.println("lalal");
			//ÿ�γ����������,�����г�����ʾ��Ḳ�ǵ�֮ǰ��ʾ������
			//����ʾ��λ������̨
			System.setOut(out);
			System.out.println("aaa");		//Ϊʲô������ʾ��ps ������ʾ������̨?
			
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		//System.in Ĭ�ϼ�������
		try {
			InputStream old = System.in;
			InputStream in = new FileInputStream("E:\\Eclipse\\IO\\SystemSetIn.txt");
			System.setIn(in);
	
			byte[] b = new byte[1024];
			int len = 0;
			try {
				len = in.read(b);					//ÿ�ζ�ȡһ������������b�����У�inread����=-1.
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			 }
			System.out.println("��������Ϊ�� ");
			System.out.println(new String(b,0,len));//String(byte[],int offset,int length)
			 										/*
			 										 * ���ֽڼ����뵽byte������  
			 										 * offset ��һ��λ��, length  Ҫ����byte����ĳ��� 
			 										 */
			System.setIn(old);
			System.out.println("���ڿ���̨����");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			System.out.println(s);
			scanner.close();
		}catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}		
	}
	
	public void demo7_System(){			//setSecurityManager()����ϵͳ��ȫ��
		/*
		 * �����ǰ��������ȫ������,�򷵻ذ�ȫ������,���򷵻�null
		 */
		SecurityManager s = new SecurityManager();//����check����,Ҫд��̳�SecurityManager��дcheck����?
		System.setSecurityManager(s);
		System.out.println(System.getSecurityManager());//java.lang.SecurityManager@784be29
		
	}

	public void demo1_Runtime() {		//�ڴ���� gc(); System�̳���Runtime ����System.gc()
		// TODO Auto-generated method stub
		//����ģʽ,û�й��췽��,����һ�������������Ǿ�̬������ֻ��һ����̬��������Runtime����
	}

	public void demo2_Runtime() {		//ִ�����������Process��
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		Process p = null;		//Process������,û������
		try {
			p = r.exec("D:\\QQ\\QQ\\Bin\\QQScLauncher.exe");//��QQ,����·��
			//r.exec("Notepad.ext"); JAVA���û�������ʱ Path�����м��±�����,���ԾͲ���Ŀ¼�Ϳ���ִ����
			File dir = new File("C:");
			/*
			 * r.exec("Notepad.exe E:\\Eclipse\\workspace\\Demo\\src\\demo\\api\\APIDemo.JAVA");
			 * ��Notepad������� APIDemo.java�ļ�  �����ƥ�����������
			 */
			Process p1 = r.exec("Notepad.exe E:\\Eclipse\\workspace\\Demo\\src\\demo\\api\\APIDemo.JAVA", null, dir);
			Thread.sleep(5000);
			p1.destroy();					//ɱ�������ӽ���
		} catch (Exception e/*InterruptedException e ��IOException����һ��*/) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("Error executing D:\\QQ\\QQ\\Bin\\QQScLauncher.exe");
			e.printStackTrace();
		}
		System.out.println("����ӽ��̵�������:"+p.getInputStream());//java.io.BufferedInputStream@3c10b841
		System.out.println("����ӽ��̵������:"+p.getOutputStream());//java.io.BufferedOutputStream@6db0d235
		System.out.println("����ӽ��̵Ĵ�����:"+p.getErrorStream());//java.io.FileInputStream@73b8cdd5	
		
	}

	public void demo1_Object() {				//equals
		// TODO Auto-generated method stub
		/*
		 * ����equals,hashCode,toString,getClass,���к��߳���ص�
		 * wait,notify,notifyAll
		 * clone Ҫʵ��Cloneable�ӿ�,����clone����
		 */
		System.out.println("s1.equals(s2) ?  "+e.s1.equals(e.s2));	//true
		System.out.println("s1.equals(s3) ?  "+e.s1.equals(e.s3));	//true
		System.out.println("s1.equals(s4) ?  "+e.s1.equals(e.s4));	//true
		System.out.println("s1.equals(s5) ?  "+e.s1.equals(e.s5));	//false
		
		System.out.println("a.equals(b) ? "+e.getA().equals(e.getB()));		//false
		
	}
	
	public void demo2_Object() {			//hashCode ���ض���Ĺ�ϣ��ֵ,�൱�ڵ�ַ
											//�÷������ص�ֵһ����ͨ�����ö�����ڲ���ַת����һ��������ʵ�ֵġ�
											//��JVM����������ڴ��ַ������ʵ�������ڴ��ַ
		System.out.println("s1�Ĺ�ϣ��ֵ �� "+e.s1.hashCode());
		System.out.println("s2�Ĺ�ϣ��ֵ �� "+e.s2.hashCode());
		System.out.println("s3�Ĺ�ϣ��ֵ �� "+e.s3.hashCode());
		System.out.println("s4�Ĺ�ϣ��ֵ �� "+e.s4.hashCode());
		System.out.println("s5�Ĺ�ϣ��ֵ �� "+e.s5.hashCode());
		System.out.println("a�Ĺ�ϣ��ֵ �� "+e.getA().hashCode());
		System.out.println("b�Ĺ�ϣ��ֵ �� "+e.getB().hashCode());
	}
	public void demo3_Object() {			//toString ���ض�����ַ����α�ʾ
		// TODO Auto-generated method stub
		System.out.println(e.getA().toString());//A@5cfe174		A����������,@�Ƿָ��� 5cfe174 �൱�ڵ�ַ16���Ʊ�ʾ
		System.out.println(e.getB().toString());//A@12da89a7	
		
	}

	public void demo4_Object() {			//getClass ����һ�����������ʱ��
		// TODO Auto-generated method stub
		
		System.out.println(e.getClass());			//class Example
		System.out.println(e.s1.getClass());		//class java.lang.String
		System.out.println(e.getA().getClass());	//class A
		
		
	}

	public void demo1_Math() {
		// TODO Auto-generated method stub
		System.out.println(Math.abs(-20.233));	//�����ֵ
		System.out.println(Math.ceil(10.1));	//��ȡ��
		System.out.println(Math.floor(10.1));	//��ȡ��
		System.out.println(Math.max(2, 3));		//���ؽϴ�ֵ,min������Сֵ
		System.out.println(Math.random());		//��� 0<= x <1 ����
		System.out.println(Math.rint(10.5));	//��������, ����double�� .5��ʱ���ȡż��,��10.5 -> 10.0  ; 11.5->12.0
		System.out.println(Math.round(21.1));	//��������,������float�򷵻�int,������double�򷵻�long
		System.out.println(Math.sqrt(25));		//������Math.cbrt();������
		System.out.println(Math.toDegrees(Math.PI));//���Ȼ��Ƕ�
		System.out.println(Math.toRadians(30));	//�ǶȻ�����
												//���Ǻ���������������
		
	}

	public void demo1_Date() {				//��ȡ��ǰʱ��,���ڶ���ת�����ַ���
		// TODO Auto-generated method stub
		/*
		 * �Ѻ����װ�ɶ�����Ի�ȡ��ǰ�����յȡ�  	
		 * Date date = new Date();	date.getDay()(�����ѹ�ʱ����Calendar�������);��ȡ�󻹿��Խ�������
		 * ΪʲôDate d1 =new Date();
		 * Date d2 =new Date();
		 * t1.getTime() ���ǵ��� t2.getTime()	//��Ϊ�ǻ�ȡ��ǰʱ��. 
		 *  Date date1 = new Date();		//�ѵ�ǰʱ���װ�ɶ���
		 *  Date date2 = new Date();		//2��date��ʱ�䲻һ��
		 * ��2�� System.currentTimeMillis();�����һ��
		 * 
		 * java.util.Date תΪ java.sql.Date �����ڵ�ʱ����ᱻȥ��
		 * 
		 * ��������  Date date = new Date(����);
		 * 		data.setTime(����);
		 */
		Date date = new Date();				//����System.currentTimeMillis();
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//����SimpleDateFormat,��y,M,m�ȸ�����ʲô��yy��2Ϊ�����꣺15��; yyyy��4Ϊ������:2015
		System.out.println("��ǰʱ�� ��"+sdFormatter.format(date.getTime()));//2015-08-11 15:26:00
		System.out.println("��ǰʱ�� ��"+sdFormatter.format(date));
		//���ø�ʽֱ��date��Tue Aug 11 15:26:00 CST 2015
		
	}

	public void demo2_Date() {				////��ȡ��ǰʱ���׼��ʽ
		// TODO Auto-generated method stub
		Date date = new Date();				//��ȡ��ǰʱ��
		//ע��getDateInstance��getTimeInstance������ һ����ֻ��ȡ����(2015��8��11��)һ����ֻ��ȡʱ��(����5��3��1��11����)
		//getDateTimeInstance(����);	���ں�ʱ��һ����ʾ
		
		/*
		 * �����DateFormat.SHORT,MEDIUM,LONG,FULL�ǵ��ñ��ص���Ϣ(�������\ʱ�ӡ����Ժ�����\�������ڡ�ʱ������ָ�ʽ)���Ը���
		 */
		DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println(shortDateFormat.format(date));//15-8-11, .getTimeInstance ����2:10
		
		DateFormat mediumDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(mediumDateFormat.format(date));//2015-7-29
		
		DateFormat longDateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(longDateFormat.format(date));//2015��7��29��
		
		DateFormat fullDateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(fullDateFormat.format(date));//2015��7��29�� ������,time:����03ʱ44��01�� CST
		
	}
	
	public void demo3_Date(){				//���ڸ�ʽ�ַ���ת��Date����
		
		String strDate = "2015-08-11 15:52:30";
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//ָ����ʽ,Ҫ��strDate�ܶ�Ӧ
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
		 *	getTime��ȡ����ֵ
		 * ��2012��9��10�� ������(2015��8��11��)�м��ж�����
		 * 1.String->Date	2.Date->long Millis		3.���	4.
		 */
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String oldDateStr = "2012-9-10";
		try {
			Date oldDate = sdFormat.parse(oldDateStr);
			Date nowDate = new Date();
			int day = DateDifferent.DATE_DIFFER_DAY(oldDate, nowDate);
			System.out.println("��2012��9��10�� ������(2015��8��11��)�м��ж�����?  "+day+" ��");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void demo1_Calendar() {			//��ȡ��ǰʱ��
		// TODO Auto-generated method stub
		
		/*
		 * Calendar�� ����ģʽ
		 * TimeZone.getTimeZone("GMT+8"); ���� TimeZone.getTimeZone("China/Beijing");
		 * sop(c);���Ǽ�ֵ��  
		 */
		Calendar cc = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		int year = cc.get(Calendar.YEAR);
		
		int month = cc.get(Calendar.MONTH)+1;		//�·��Ǵ�0��ʼ, 0�µ�11�� ��ʾ  1�µ�12��
		int day = cc.get(Calendar.DAY_OF_MONTH);	//����µĵڼ���,DAY_OF_YEAR ����ĵڼ���
		
		//int hour_12 = cc.get(Calendar.HOUR);		//12Сʱ��
		int hour_24 = cc.get(Calendar.HOUR_OF_DAY);	//24Сʱ��
		int minute = cc.get(Calendar.MINUTE);
		int second = cc.get(Calendar.SECOND);
		
		/*
		 * getWeekDay(Calendar.DAY_OF_WEEK);
		 * �����½�����String getWeekDay(int i){
		 * 	String s = {"","����һ","���ڶ�",..."������"}
		 * 	return s[i];
		 * }
		 */
		int weekday = cc.get(Calendar.DAY_OF_WEEK)-1;	//�������� = 0  ,������==6
		
		System.out.println(year+"-"+month+"-"+day+" "+hour_24+":"+minute+":"+second+"  ����"+weekday);
		
	}

	public void demo2_Calendar() {			//Date Calendar ��ת��
		// TODO Auto-generated method stub
		Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		Date d = c1.getTime();
		c1.setTime(d);
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdFormatter.format(d));
		System.out.println(c1.get(Calendar.YEAR)+"-"+(c1.get(Calendar.MONTH)+1)+"-"+c1.get(Calendar.DAY_OF_MONTH)+" "+c1.get(Calendar.HOUR_OF_DAY)+":"+c1.get(Calendar.MINUTE)+":"+c1.get(Calendar.SECOND)+"  ����"+(c1.get(Calendar.DAY_OF_WEEK)-1));
		
	}
	
	public void demo3_Calendar(){			//��ָ������ƫ��
		
		Calendar c = Calendar.getInstance();
		c.set(2012, 8, 10);					//�������� 2012��9��10��   �´�0��
		c.add(Calendar.YEAR, 3);			//��������ǰƫ��
		System.out.println(c.get(Calendar.YEAR)+"��"+(c.get(Calendar.MONTH)+1)+"��"+c.get(Calendar.DAY_OF_MONTH)+"��");
		
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


