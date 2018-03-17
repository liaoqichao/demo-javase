package demo;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo {

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		/*
		 * Tomcat֧��JavaWeb,����֧��JAVAEE
		 * SSH(������)����EJB(������)
		 */
		
		try{
			InputStream in = Class.forName("demo.Demo").getClassLoader().getResourceAsStream("demo/demo.properties");			
			Properties prop = new Properties();
			prop.load(in);
			if(prop.size()!=0){
				
				
				//��ȡһ�����ݵ�ȫ����ʾ
				//��ȡ��ѡ�е���ʾ
				String selected = prop.getProperty("selected");
//				singleDemo(prop.getProperty("demo39"));
//				singleDemo("demo.io.DataStreamDemo");
				singleDemo(prop.getProperty(selected));
				
				//��ȡȫ����ʾ
//				allDemo(prop);
				
				//��ȡһ�����ݵ�һ����ʾ
//				showFunctions(prop.getProperty(selected));
//				demoFunction(prop.getProperty(selected),"demo5");
				
//				demoFunction(prop.getProperty(selected),"demo6_jasp_findNode");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	static void singleDemo(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
		if(className!=null)
			reflect(className);
	}
	static void allDemo(Properties prop) throws Exception{

		for(int i = 0 ; i<prop.size() ; i++){
			String className = prop.getProperty("demo"+(i+1));
			if(className == null){
				continue;
			}
			reflect(className);
		}
	}
	private static void reflect(String className) throws Exception{
		Class<?> c = Class.forName(className);
		Object obj = c.newInstance();
		DemoInterface demo = (DemoInterface) obj;
		demo.demo();
	}
	public static void showFunctions(String className) throws Exception {
		Class<?> c = Class.forName(className);
		Object obj = c.newInstance();
		@SuppressWarnings("unused")
		DemoInterface demo = (DemoInterface) obj;
		Method[] methods = c.getDeclaredMethods();
		for(Method method : methods){
			System.out.println(method);
		}
	}
	public static void demoFunction(String className,String functionName) throws Exception{
		Class<?> c = Class.forName(className);
		Object obj = c.newInstance();
		DemoInterface demo = (DemoInterface) obj;
		//demo�������ǲ���������
		Method method = c.getDeclaredMethod(functionName);
		method.invoke(demo);
	}
	static void demo(DemoInterface d) throws Exception{
		d.demo();
	}
}
