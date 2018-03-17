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
		 * Tomcat支持JavaWeb,但不支持JAVAEE
		 * SSH(轻量级)代替EJB(重量级)
		 */
		
		try{
			InputStream in = Class.forName("demo.Demo").getClassLoader().getResourceAsStream("demo/demo.properties");			
			Properties prop = new Properties();
			prop.load(in);
			if(prop.size()!=0){
				
				
				//获取一个内容的全部演示
				//获取被选中的演示
				String selected = prop.getProperty("selected");
//				singleDemo(prop.getProperty("demo39"));
//				singleDemo("demo.io.DataStreamDemo");
				singleDemo(prop.getProperty(selected));
				
				//获取全部演示
//				allDemo(prop);
				
				//获取一个内容的一个演示
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
		//demo函数都是不带参数的
		Method method = c.getDeclaredMethod(functionName);
		method.invoke(demo);
	}
	static void demo(DemoInterface d) throws Exception{
		d.demo();
	}
}
