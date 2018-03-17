package demo.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import demo.DemoInterface;
import demo.collectionFreamwork.example.Person;
import demo.reflect.demo6.Demo6_B;
import demo.reflect.demo6.Demo6_C;

public class ReflectDemo implements DemoInterface {

	/**
	 * 
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 反射一般用在通用性比较高的代码中。例如后面学习到的框架。
		 * 反射机制原理：
		 * 1.把.java文件存到本地硬盘
		 * 2.编译.java文件,生成.class文件
		 * 3.使用JVM把.class文件通过类加载器加载到内存中
		 * 4..class文件可以通过Class类来获取.class文件对象。有对象就可以获取里面的所有信息和使用里面的所有成员。
		 * 
		 * JAVA反射机制:在运行状态中,对于任意一个类(class文件),都能够知道这个类的所有属性和方法
		 * 对于任意一个对象，都能够调用它任意一个属性和方法。
		 * 这种动态获取信息以及动态调用对象的方法的功能称为JAVA反射机制
		 * 
		 * 动态获取类中的信息,就是java反射机制
		 * 
		 * 反射机制条件：接口+配置文件
		 * 
		 * 作用：已经可以运行的应用程序需要拓展功能的时候。新增类实现了接口。但是原来的应用程序是应用程序,没有源代码,不能在应用程序里面new对象
		 * 实现多态。所以实现完接口后,应该在配置文件写下类名。应用程序应该读取配置文件,根据类名(字符串)找到类名.class文件,并加载到应用程序，
		 * 然后在new对象,使用里面的方法。
		 * 
		 * 例子：Tomcat的Servlet接口。类A实现Servlet接口,配置文件(web.xml)增加A类名.Tomcat读取配置文件的A类名,加载A.class
		 * 并调用A.class的信息(创建对象,调用方法)
		 * 反射机制提高了程序的拓展性
		 */
		//demo1();
		//demo2();
		//demo3();
		//demo4();
//		demo6();
		demo7();
	}
	public void demo1() throws ClassNotFoundException{		//字节码对象的获取
		/*
		 * Class类可以获取.class文件中的所有内容 。反射就是依靠这个类来完成的。
		 * 只要拿到demo.class文件的Class类对象就可以清楚demo.class文件的所有内容(类名,构造函数,成员变量,成员方法)
		 * 
		 * 获取字节码对象的方式：
		 * 1.Object中的getClass方法
		 * 	 想用这种方式,必须明确具体的类,并创建对象。
		 * 	 换成Animal类后还是Person p =new Person(); Class clazz = p.getClass();不够扩展
		 * 2.任何数据类型都具有静态属性.class来获取对应的Class对象
		 * 	   相对简单,但是需要用到类中的静态成员。
		 *   换成Animal类后还是Person.class。不够扩展
		 * 3.只用通过给定的类的字符串名称就可以获取该类.这个方法够拓展性。Class.forName(String str);
		 * 	 这种方式只要有名称(字符串)即可
		 */
		
		//方式1
		/*
		Person p = new Person();
		Class clazz = p.getClass();
		
		Person p1 = new Person();
		Class clazz1 = p1.getClass();
		System.out.println(clazz==clazz1);//true
		*/
		
		//方式2
		/*
		Class clazz = Person.class;
		Class clazz1 = Person.class;
		System.out.println(clazz==clazz1);//true
		*/
		
		//方式3
		String className = "demo.collectionFreamwork.example.Person";
		//这里的Person应该是从配置文件中读取,然后赋值给className
		//类的classPath通常在src或者bin目录开始(就是导包的路径)
		//查看工程里面的.classPath文件
		Class<?> clazz = Class.forName(className);//如果不存在则抛出异常
		Class<?> clazz1 = Class.forName(className);
		System.out.println(clazz);//class demo.collectionFreamwork.example.Person
		System.out.println(clazz1);//class demo.collectionFreamwork.example.Person
		
	}
	public void demo2() throws Exception{	//获取Class对象的构造函数
		String className = "demo.collectionFreamwork.example.Person";
		
		//构造函数不带参数的实例化对象
		//找到Person.class文件并加载进内存,并产生Class对象
//		Class clazz = Class.forName(className);
		
		//newInstance()创建这个Class对象表示的类的一个新实例,并调用那个类的空参构造函数
		//一般被反射的类通常都带空参数
//		Object obj = clazz.newInstance();//抛2个异常
		
		
		//构造函数带参数的实例化对象
		/*
		 * 当获取指定名称对应的类的对象时,初始化带参数的构造函数
		 * 既然是通过指定的构造函数进行初始化,应该先获取该构造函数
		 * getConstructor(parameterTypes);获取构造函数
		 * getConstructors();获取所有构造函数
		 * getDeclearedConstructor();获取所有构造函数包括私有
		 * reflect中把构造函数,方法,字段封装成对象Constructor,Method,Field  体现了万物皆对象
		 */
		Class<?> clazz1 = Class.forName(className);
		Constructor<?> constructor = clazz1.getConstructor(String.class,int.class);
		//通过构造器对象的newInstance方法进行对象的初始化
		@SuppressWarnings("unused")
		Object obj = constructor.newInstance("喵了个咪",15);
		
		//上面3行代码等于 Person p = new Person("喵了个咪",15);
	}
	public void demo3() throws Exception{	//获取Class对象的字段
		
		String classname = "demo.collectionFreamwork.example.Person";
		Class<?> clazz = Class.forName(classname);
		
		Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
		Object c = constructor.newInstance("咪了个喵",15);
		
//		Field field = clazz.getField("age");//不能访问私有的
		Field field = clazz.getDeclaredField("age");//只获取本类,但包涵私有
		System.out.println(field);//private int demo.collectionFreamwork.example.Person.age
		
		/*
		 * 暴力访问：
		 * 对私有字段的访问取消权限检查
		 * AccessibleObject的方法 setAccessibel(boolean flag); flag = true 则取消权限检查
		 * AccessibleObject有三个子类Constructor,Field,Method
		 */
		//暴力访问:
		field.setAccessible(true);
		System.out.println(field.getInt(c));//输出：15  age是私有不能直接访问,需要取消权限检查
		field.setInt(c,16);//age是私有不能直接访问
		System.out.println(field.getInt(c));//16
		
	}
	public void demo4() throws Exception{	//获取Class对象的方法
		
		String classname = "demo.collectionFreamwork.example.Person";
		Class<?> clazz = Class.forName(classname);
		
		Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
		Object c = constructor.newInstance("提莫",1);
		
//		Method[] methods = clazz.getMethods();	//没有decleared获取的都是共有的方法
//		for(Method method : methods){
//			System.out.println(method);
//		}
		
//		public boolean demo.collectionFreamwork.example.Person.equals(java.lang.Object)
//		public java.lang.String demo.collectionFreamwork.example.Person.toString()
//		public int demo.collectionFreamwork.example.Person.hashCode()
//		public int demo.collectionFreamwork.example.Person.compareTo(java.lang.Object)
//		public java.lang.String demo.collectionFreamwork.example.Person.getName()
//		public int demo.collectionFreamwork.example.Person.getAge()
//		public static demo.collectionFreamwork.example.CompareByName demo.collectionFreamwork.example.Person.getCompareByName()
//		public static demo.collectionFreamwork.example.CompareByAge demo.collectionFreamwork.example.Person.getCompareByAge()
//		public void demo.collectionFreamwork.example.Person.chifan()
//		public final void java.lang.Object.wait() throws java.lang.InterruptedException
//		public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//		public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//		public final native java.lang.Class java.lang.Object.getClass()
//		public final native void java.lang.Object.notify()
//		public final native void java.lang.Object.notifyAll()
		
//		Method[] m = clazz.getDeclaredMethods();	//只获取本类的方法,包括私有
//		for(Method method : m){
//			System.out.println(method);
//		}
		
//		public boolean demo.collectionFreamwork.example.Person.equals(java.lang.Object)
//		public java.lang.String demo.collectionFreamwork.example.Person.toString()
//		public int demo.collectionFreamwork.example.Person.hashCode()
//		public int demo.collectionFreamwork.example.Person.compareTo(java.lang.Object)
//		public java.lang.String demo.collectionFreamwork.example.Person.getName()
//		public int demo.collectionFreamwork.example.Person.getAge()
//		public static demo.collectionFreamwork.example.CompareByName demo.collectionFreamwork.example.Person.getCompareByName()
//		public static demo.collectionFreamwork.example.CompareByAge demo.collectionFreamwork.example.Person.getCompareByAge()
//		public void demo.collectionFreamwork.example.Person.chifan()

//		Method method clazz.getMethod(name, parameterTypes);
//		Method singleMethod =  clazz.getMethod("chifan", null);//这里的null是形参，没有参数可以不写
		Method singleMethod = clazz.getMethod("chifan");
//		singleMethod.invoke(c, null);//这里的null是实参  输出：吃饭,没有参数可以不写
		singleMethod.invoke(c);//没有参数可以不写
		//第一个参数是实例,就是这个这个类的一个实例,Person p1
		//如果chifan是静态方法,那么就不需要实例参数	。
		//singleMethod.invoke(null,null);//第一个null表示调用的是静态方法
		
		Method singleMethod1 = clazz.getMethod("equals", Object.class);
		System.out.println(singleMethod1.invoke(c, new Person("张三",5)));
	}
	
	public void demo6(){	//泛型反射
		/*
		 * Class的Type getGenericSuperClass()方法，返回的是参数化类型(ParameterizedType)。
		 * 需要把Type强转为ParameterizedType
		 * 参数化类型：形如A<String>(类名+泛型)
		 * ParameterizedType的方法：Type[] getAuctualTypeArgument()，得到的是A<String>的String。
		 * 	Map<String,Object>中的{String,Object};
		 * 这个时候返回的Type[] 就是Class[]
		 */
		
		new Demo6_B();
//		this.getClass() = class demo.reflect.demo6.Demo6_B
//		class java.lang.Integer
		new Demo6_C();
//		this.getClass() = class demo.reflect.demo6.Demo6_C
//		class java.lang.String
	}
	
	public void demo7() throws ClassNotFoundException, NoSuchMethodException, SecurityException{	//反射注解
		/*
		 * 要求泛型的保留策略必须是RetentionPolicy.RUNTIME
		 * 1.反射注解需要从作用目标上反射
		 * 	* 类上的注解需要在Class上获取
		 * 	* 方法的注解需要在Method获取
		 *  * 构造器的注解需要在Constructor上获取
		 *  * 成员变量的注解需要在Field上获取
		 *  Class：getAnnotation等相关方法
		 *  Method、Constructor，Field的共同父类：AccessibleObject：getAnnotation等相关方法
		 */
		
		/*
		 * Class
		 */
		//1.得到作用目标
		@SuppressWarnings("unchecked")
		Class<ClassDemo7> clazz = (Class<ClassDemo7>) Class.forName("demo.reflect.ClassDemo7");
		//2.获取指定类型的注解
		AnnotationDemo7 anno1 = clazz.getAnnotation(AnnotationDemo7.class);
		//3.
		System.out.println(anno1.age()+", "+anno1.name()+", "+anno1.sex());
		//10, A类, 妖
		
		/*
		 * AccessibleObject
		 */
		//1.得到作用目标
		Class<ClassDemo7> c = ClassDemo7.class;
		Method method = c.getMethod("func1");
		//2.获取指定类型的注解
		AnnotationDemo7 anno2 = method.getAnnotation(AnnotationDemo7.class);
		//3.
		System.out.println(anno2.age()+", "+anno2.name()+", "+anno2.sex());
		
		/*
		 * 万一不知道注解的名字的话只能getAnnotations获取作用目标下的全部注解
		 */
	}

}

@AnnotationDemo7(age = 10, name = "A类", sex = "妖")
class ClassDemo7{
	@AnnotationDemo7(age = 20, name = "fun1方法", sex = "鬼")
	public void func1(){
		
	}
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface AnnotationDemo7{
	String name();
	int age();
	String sex();
}
